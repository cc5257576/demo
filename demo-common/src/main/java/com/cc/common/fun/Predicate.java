//package com.cc.common.fun;
//
//import java.util.Objects;
//
//@FunctionalInterface
//public interface Predicate<T> {
//
//    boolean test(T t);
//
//    //and方法与关系型运算符"&&"相似，两边都成立才返回true
//    default Predicate<T> and(Predicate<? super T> other) {
//        Objects.requireNonNull(other);
//        return (t) -> test(t) && other.test(t);
//    }
//}
