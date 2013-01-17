package pl.grzejszczak.marcin.drools.springintegration.factory;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public interface ProcessingFactory<T, V> {
    T createProcessingObject(V inputObject);
}
