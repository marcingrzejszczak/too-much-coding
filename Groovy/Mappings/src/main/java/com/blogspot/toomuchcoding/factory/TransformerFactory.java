package com.blogspot.toomuchcoding.factory;

import com.blogspot.toomuchcoding.transformer.Transformer;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 22.03.13
 * Time: 23:53
 */
public interface TransformerFactory<T,V> {
    Transformer<T,V> createTransformer();
}
