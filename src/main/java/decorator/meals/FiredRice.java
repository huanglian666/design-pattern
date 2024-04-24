package decorator.meals;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/24 09:19 <br/>
 */
public class FiredRice extends Meals {
    public FiredRice() {
        super("炒饭");
    }

    @Override
    public void cost() {
        System.out.println("炒饭十元钱");
    }

}
