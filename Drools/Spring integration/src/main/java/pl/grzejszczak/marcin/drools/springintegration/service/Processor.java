package pl.grzejszczak.marcin.drools.springintegration.service;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public interface Processor<T> {
    void process(T input);
}
