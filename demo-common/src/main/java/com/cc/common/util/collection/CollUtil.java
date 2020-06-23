package com.cc.common.util.collection;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/4 10:35
 * Description:
 */
public class CollUtil {

    /**
     * 集合是否为空
     *
     * @param collection 集合
     * @return 是否为空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 集合是否为非空
     *
     * @param collection 集合
     * @return 是否为非空
     */
    public static boolean isNotEmpty(Collection<?> collection) {
        return false == isEmpty(collection);
    }
}
