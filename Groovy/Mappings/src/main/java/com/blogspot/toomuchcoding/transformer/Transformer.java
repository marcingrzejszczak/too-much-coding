package com.blogspot.toomuchcoding.transformer;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 22.03.13
 * Time: 23:51
 */
public interface Transformer<T, V> {
    T transform(V input);
}
