package test;

import decorator.Ingredients.Chili;
import decorator.meals.FiredRice;
import decorator.meals.Meals;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/24 09:37 <br/>
 */
public class DecoratorTest {
    public static void main(String[] args) {
        //创建原料
        FiredRice firedRice = new FiredRice();
        //加调料
        Meals finalMeals = new Chili(firedRice);

        //输出最终的产品
        finalMeals.cost();
    }
}
