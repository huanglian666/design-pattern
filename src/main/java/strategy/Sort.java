package strategy;

import cn.hutool.core.lang.Assert;
import strategy.service.Compare;

/**
 * Title: <br/>
 * Description: <br/>
 * Copyright: 2024 微数互联股份有限公司 版权所有.保留所有权<br/>
 * Company:微数互联股份有限公司(DATA LINK)<br/>
 * Project: design-pattern <br/>
 *
 * @Author huanglian <br/>
 * Create Time:2024/4/23 09:19 <br/>
 */
public class Sort<T> {
    public void sort(T[] arr, Compare<T> compare) {
        Assert.noNullElements(arr, "需要排序的数组不能为空");
        Assert.notNull(compare, "排序规则不能为空");
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            if (compare.compareTo(arr[i], arr[j]) == -1) {
                swap(arr, i, j);
            }
        }
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
