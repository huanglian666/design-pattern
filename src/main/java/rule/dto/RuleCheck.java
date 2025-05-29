package rule.dto;

import lombok.*;

/**
 * Description:
 * Company: 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司
 * Author: 黄炼
 * Date: 2025-05-29 18:32
 * Version: 1.0
 * <p>
 * Copyright (c) 2023 华信永道（北京）科技股份有限公司 - 金政数字科技（昆明）有限公司.
 * All rights reserved.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleCheck {
    /**
     * 交易码
     */
    private String tranCode;

    /**
     * 校验规则名称
     */
    private String validRuleName;

    /**
     * 执行顺序
     */
    private Integer execSort;

    /**
     * 是否可以并行执行
     */
    private Boolean isParallel;

    /**
     * 执行分组
     */
    private Integer execGroup;

}
