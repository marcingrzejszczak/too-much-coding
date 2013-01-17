package pl.grzejszczak.marcin.junit.matchers.service;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 22:31
 */
public interface SomeService {
    void someLogicForAPojoWithoutBuilder();
    void someLogicForAPojoWithBuilder();
    void someLogicForAPojoWithBuilderBadArgument();
}
