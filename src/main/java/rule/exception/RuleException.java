package rule.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: YangC
 * Date: 2025-06-03 15:33
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
@Data
@AllArgsConstructor
public class RuleException extends RuntimeException{
    private String ruleCode;

    private String message;
}
