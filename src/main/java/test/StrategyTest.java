package test;

import strategy.Sort;
import strategy.entity.Dog;

import java.util.Arrays;
import java.util.Objects;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/23 09:27 <br/>
 */
public class StrategyTest {
    public static void main(String[] args) {
        Dog[] dogs = (Dog[]) Arrays.asList(
                new Dog(0), new Dog(2), new Dog(1)
        ).toArray();

        Sort<Dog> dogSort = new Sort<>();
        dogSort.sort(dogs, (o1, o2) -> {
            if (o1.getAge() < o2.getAge()) {
                return -1;
            } else if (Objects.equals(o1.getAge(), o2.getAge())) {
                return 0;
            } else {
                return 1;
            }
        });

        System.out.println(Arrays.toString(dogs));

    }
}
