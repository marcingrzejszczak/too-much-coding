package pl.grzejszczak.marcin.junit.matchers;

import pl.grzejszczak.marcin.junit.matchers.builder.SomeBigPojoBuilder;
import pl.grzejszczak.marcin.junit.matchers.service.SomeServiceImpl;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 22:38
 */
public class MatcherMain {
    public static void main(String[] args){
        SomeServiceImpl someService = new SomeServiceImpl();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithoutBuilder();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithBuilder();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithBuilderBadArgument();
    }
}
