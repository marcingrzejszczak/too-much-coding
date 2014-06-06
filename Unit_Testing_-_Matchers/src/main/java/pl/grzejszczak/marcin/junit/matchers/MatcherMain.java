package pl.grzejszczak.marcin.junit.matchers;

import pl.grzejszczak.marcin.junit.matchers.builder.SomeBigPojoBuilder;
import pl.grzejszczak.marcin.junit.matchers.service.SomeService;

public class MatcherMain {
    public static void main(String[] args){
	    SomeService someService = new SomeService();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithoutBuilder();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithBuilder();

        someService.setSomeBigPojoBuilder(new SomeBigPojoBuilder());
        someService.someLogicForAPojoWithBuilderBadArgument();
    }
}
