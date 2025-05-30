package rule;

import org.apache.commons.compress.utils.Lists;
import rule.dto.RuleCheck;
import rule.execute.CheckExecute;

import java.util.HashMap;
import java.util.List;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: 黄炼
 * Date: 2025-05-29 19:41
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
public class RuleCheckTest {
    private static final List<RuleCheck> testData = Lists.newArrayList();
    static {
        testData.add(
                RuleCheck.builder()
                        .tranCode("1")
                        .validRuleName("check1")
                        .execSort(1)
                        .isParallel(Boolean.TRUE)
                        .execGroup(1)
                        .build()
        );

        testData.add(
                RuleCheck.builder()
                        .tranCode("1")
                        .validRuleName("check2")
                        .execSort(2)
                        .isParallel(Boolean.FALSE)
                        .execGroup(1)
                        .build()
        );

    }

    public static void main(String[] args) {
        List<String> strings = CheckExecute.execCheckRule(testData, new HashMap<>());
        System.out.println(strings);
    }
}
