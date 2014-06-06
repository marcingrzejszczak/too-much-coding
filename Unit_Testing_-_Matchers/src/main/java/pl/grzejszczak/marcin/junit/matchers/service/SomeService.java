package pl.grzejszczak.marcin.junit.matchers.service;

import static java.lang.String.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.grzejszczak.marcin.junit.matchers.builder.SomeBigPojoBuilder;
import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;


public class SomeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeService.class);

    /** Could be an abstraction of builders injected by a setter - possible to mock */
    private SomeBigPojoBuilder someBigPojoBuilder;

    /**
     * Hard to unit test
     */
    public void someLogicForAPojoWithoutBuilder() {
        LOGGER.debug("SomeLogicForAPojoWithoutBuilder executed");
        SomeBigPojo someBigPojo = new SomeBigPojo("string", 1, false, "other string", 123, true, "something else", 321, false, "yet another string", 111, true, "something", 2, false, "More", 3, true, "String", 12, false, "some", "value", "ofString");
        // Any chance of knowing what is the value of stringField8 basing on the constructor?
        LOGGER.debug(format("StringField8 is equal [%s]%n", someBigPojo.getStringField8()));
        // Print the object
        LOGGER.debug(someBigPojo.toString());
    }

    public void someLogicForAPojoWithBuilder() {
        LOGGER.debug("SomeLogicForAPojoWithBuilder executed");
        SomeBigPojo someBigPojo = someBigPojoBuilder
                .setStringField0("string")
                .setIntegerField0(1)
                .setBooleanField0(false)
                .setStringField1("other string")
                .setIntegerField1(123)
                .setBooleanField1(true)
                .setStringField2("something else")
                .setIntegerField2(321)
                .setBooleanField2(false)
                .setStringField3("yet another string")
                .setIntegerField3(111)
                .setBooleanField3(false)
                .setStringField4("something")
                .setIntegerField4(2)
                .setBooleanField4(false)
                .setStringField5("More")
                .setIntegerField5(3)
                .setBooleanField5(true)
                .setStringField6("String")
                .setIntegerField6(12)
                .setBooleanField6(false)
                .setStringField7("some")
                .setStringField8("value")
                .setStringField9("ofString")
                .createSomeBigPojoWithBuilder();
        // Looking at the builder now I guess it's obvious what the value of StringField8
        LOGGER.debug(format("StringField8 is equal [%s]%n", someBigPojo.getStringField8()));
        // Print the object
        LOGGER.debug(someBigPojo.toString());
    }

    public void someLogicForAPojoWithBuilderBadArgument() {
        LOGGER.debug("someLogicForAPojoWithBuilderBadArgument executed");
        SomeBigPojo someBigPojo = someBigPojoBuilder
                .setStringField0("string")
                .setIntegerField0(1)
                .setBooleanField0(true)
                .setIntegerField1(123)
                .setBooleanField1(true)
                .setStringField2("something else")
                .setIntegerField2(321)
                .setBooleanField2(false)
                .setStringField3("yet another string")
                .setIntegerField3(111).setBooleanField3(false)
                .setStringField4("something")
                .setIntegerField4(2)
                .setBooleanField4(false)
                .setStringField5("More")
                .setIntegerField5(3)
                .setBooleanField5(true)
                .setStringField6("String")
                .setIntegerField6(12)
                .setBooleanField6(false)
                .setStringField7("some")
                .setStringField8("value")
                .setStringField9("ofString")
                .createSomeBigPojoWithBuilder();
        // Print the object - will we even see an output
        LOGGER.debug(someBigPojo.toString());
    }

    public void setSomeBigPojoBuilder(SomeBigPojoBuilder someBigPojoBuilder) {
        this.someBigPojoBuilder = someBigPojoBuilder;
    }
}

