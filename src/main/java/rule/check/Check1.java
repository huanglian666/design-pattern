package rule.check;

import rule.exception.RuleException;

import java.util.Map;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: 黄炼
 * Date: 2025-05-29 18:38
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
public class Check1 implements CheckRuleInterface {

    @Override
    public void check(Map<String, Object> param) {
        System.out.println("执行了check1");
        throw new RuleException("check1","check1异常");
    }
}
