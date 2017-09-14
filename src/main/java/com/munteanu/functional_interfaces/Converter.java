package com.munteanu.functional_interfaces;

/**
 * Created by romunteanu on 1/12/2016.
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
