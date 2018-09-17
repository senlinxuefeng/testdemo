package com.yumingchuan.testdemo.generic;

import java.util.List;

/**
 * Created by yumingchuan on 2018/9/17.原因是重用，效率（不需要强转），安全。
 */

public class GenericTest<T> {
    /**
     * @param t
     * @return 类泛型的写法
     */
    public T getTest(T t) {
        return t;
    }


    /**
     * @param strings
     * @return 方法泛型
     */
    public List<String> getStringTest(List<String> strings) {
        return strings;
    }

}
