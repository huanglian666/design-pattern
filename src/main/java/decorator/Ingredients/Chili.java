package decorator.Ingredients;

import decorator.meals.Meals;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/24 09:28 <br/>
 */
public class Chili extends Ingredients{
    public Chili(Meals baseMeals) {
        super("辣椒", baseMeals);
    }

    @Override
    public void cost() {
        Meals baseMeals = this.getBaseMeals();
        baseMeals.cost();
        System.out.println(baseMeals.getName() + "添加了" + this.getName());
    }
}
