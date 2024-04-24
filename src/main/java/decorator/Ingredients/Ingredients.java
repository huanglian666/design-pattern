package decorator.Ingredients;

import decorator.meals.Meals;
import lombok.*;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/24 09:24 <br/>
 */
@Setter
@Getter
public abstract class Ingredients extends Meals {
    private Meals baseMeals;

    public Ingredients(String name, Meals baseMeals) {
        super(name);
        this.baseMeals = baseMeals;
    }
}
