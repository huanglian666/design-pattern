package rule.check;

import java.util.Map;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: YangC
 * Date: 2025-05-29 20:19
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
public class Check2 implements CheckRuleInterface {


    @Override
    public void check(Map<String, Object> param) {
        System.out.println("check2执行了");
    }
}
