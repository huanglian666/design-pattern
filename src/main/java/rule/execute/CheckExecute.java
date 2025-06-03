package rule.execute;

import cn.hutool.core.map.MapBuilder;
import lombok.SneakyThrows;
import org.springframework.util.Assert;
import rule.check.Check1;
import rule.check.Check2;
import rule.check.CheckRuleInterface;
import rule.dto.RuleCheck;
import rule.exception.RuleException;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: 黄炼
 * Date: 2025-05-29 18:40
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
public class CheckExecute {
    public final static Map<String, CheckRuleInterface> execBeans =
            MapBuilder.<String, CheckRuleInterface>create()
                    .put("check1", new Check1())
                    .put("check2", new Check2())
                    .build();
    /**
     * 串行专用线程
     */
    private static final ExecutorService serialExecutor = Executors.newSingleThreadExecutor();

    /**
     * 并行线程池
     */
    private static final ThreadPoolExecutor parallelPool =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    /**
     * 执行规则检查
     *
     * @param tranCheckConfigs 数据记录某一个交易码需要校验的规则
     * @param params           检查的请求参数
     * @return 规则检查中的错误信息
     */
    @SneakyThrows
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static List<String> execCheckRule(List<RuleCheck> tranCheckConfigs, Map<String, Object> params) {
        Assert.notEmpty(tranCheckConfigs, "检查规则不能为空");
        //1. 排序并分组（分为串行执行和并行执行）
        Map<Boolean, List<RuleCheck>> groupByExec = tranCheckConfigs.stream()
                .sorted(Comparator.comparing(RuleCheck::getExecSort))
                .collect(Collectors.groupingBy(RuleCheck::getIsParallel));

        //2. 分组执行
        List<String> errorList = new Vector<>();
        List<RuleCheck> parallelGroup = groupByExec.getOrDefault(Boolean.TRUE, Collections.emptyList());
        int parallelTaskCount = parallelGroup.size();
        CountDownLatch parallelLatch = new CountDownLatch(parallelTaskCount);
        //并行执行组
        parallelGroup.forEach(item -> parallelPool.submit(() -> {
                try {
                    CheckRuleInterface checkRule = execBeans.get(item.getValidRuleName());
                    Assert.notNull(
                            checkRule, String.format("没有找到[%s]对应的执行规则", item.getValidRuleName())
                    );
                    checkRule.check(params);
                } catch (Exception e) {
                    String msg= e.getMessage();
                    if (e instanceof RuleException){
                        msg = String.format("[%s]提示:%s", ((RuleException) e).getRuleCode(), msg);
                    }
                    errorList.add(msg);
                } finally {
                    // 确保计数减少
                    parallelLatch.countDown();
                }
        }));

        //串行执行组
        serialExecutor.submit(() ->
                groupByExec.getOrDefault(Boolean.FALSE, Collections.emptyList()).forEach(item -> {
                    try {
                        CheckRuleInterface checkRule = execBeans.get(item.getValidRuleName());
                        System.out.println(item.getValidRuleName());
                        Assert.notNull(
                                checkRule, String.format("没有找到[%s]对应的执行规则", item.getValidRuleName())
                        );
                        checkRule.check(params);
                    } catch (Exception e) {
                        errorList.add(e.getMessage());
                    }
                })
        );

        // 同步等待（替代原有while循环）
        // 关闭线程池前等待（需确保不再提交新任务）
        parallelPool.shutdown();
        serialExecutor.shutdown();
        parallelLatch.await(30, TimeUnit.SECONDS);
        serialExecutor.awaitTermination(10, TimeUnit.SECONDS);

        return errorList;
    }
}
