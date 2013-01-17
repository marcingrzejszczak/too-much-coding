package pl.grzejszczak.marcin.junit.matchers.builder;

import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 21:08
 */
public class SomeBigPojoBuilder {
    /** A field with some default value */
    private String stringField0 = "defaultValueForString0";
    /** A field with some default value */
    private Integer integerField0 = 100;
    /** A field with some default value */
    private Boolean booleanField0 = true;
    private String stringField1;
    private Integer integerField1;
    private Boolean booleanField1;
    private String stringField2;
    private Integer integerField2;
    private Boolean booleanField2;
    private String stringField3;
    private Integer integerField3;
    private Boolean booleanField3;
    private String stringField4;
    private Integer integerField4;
    private Boolean booleanField4;
    private String stringField5;
    private Integer integerField5;
    private Boolean booleanField5;
    private String stringField6;
    private Integer integerField6;
    private Boolean booleanField6;
    private String stringField7;
    private String stringField8;
    private String stringField9;

    public SomeBigPojoBuilder setStringField0(String stringField0) {
        this.stringField0 = stringField0;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField0(Integer integerField0) {
        this.integerField0 = integerField0;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField0(Boolean booleanField0) {
        this.booleanField0 = booleanField0;
        return this;
    }

    public SomeBigPojoBuilder setStringField1(String stringField1) {
        this.stringField1 = stringField1;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField1(Integer integerField1) {
        this.integerField1 = integerField1;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField1(Boolean booleanField1) {
        this.booleanField1 = booleanField1;
        return this;
    }

    public SomeBigPojoBuilder setStringField2(String stringField2) {
        this.stringField2 = stringField2;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField2(Integer integerField2) {
        this.integerField2 = integerField2;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField2(Boolean booleanField2) {
        this.booleanField2 = booleanField2;
        return this;
    }

    public SomeBigPojoBuilder setStringField3(String stringField3) {
        this.stringField3 = stringField3;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField3(Integer integerField3) {
        this.integerField3 = integerField3;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField3(Boolean booleanField3) {
        this.booleanField3 = booleanField3;
        return this;
    }

    public SomeBigPojoBuilder setStringField4(String stringField4) {
        this.stringField4 = stringField4;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField4(Integer integerField4) {
        this.integerField4 = integerField4;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField4(Boolean booleanField4) {
        this.booleanField4 = booleanField4;
        return this;
    }

    public SomeBigPojoBuilder setStringField5(String stringField5) {
        this.stringField5 = stringField5;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField5(Integer integerField5) {
        this.integerField5 = integerField5;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField5(Boolean booleanField5) {
        this.booleanField5 = booleanField5;
        return this;
    }

    public SomeBigPojoBuilder setStringField6(String stringField6) {
        this.stringField6 = stringField6;
        return this;
    }

    public SomeBigPojoBuilder setIntegerField6(Integer integerField6) {
        this.integerField6 = integerField6;
        return this;
    }

    public SomeBigPojoBuilder setBooleanField6(Boolean booleanField6) {
        this.booleanField6 = booleanField6;
        return this;
    }

    public SomeBigPojoBuilder setStringField7(String stringField7) {
        this.stringField7 = stringField7;
        return this;
    }

    public SomeBigPojoBuilder setStringField8(String stringField8) {
        this.stringField8 = stringField8;
        return this;
    }

    public SomeBigPojoBuilder setStringField9(String stringField9) {
        this.stringField9 = stringField9;
        return this;
    }

    /**
     * Some function checking the state of our POJO
     */
    private void checkState(){
        checkNotNull(stringField1, "StringField1 must not be null!");
    }

    public SomeBigPojo createSomeBigPojoWithBuilder() {
        checkState();
        return new SomeBigPojo(stringField0, integerField0, booleanField0, stringField1, integerField1, booleanField1, stringField2, integerField2, booleanField2, stringField3, integerField3, booleanField3, stringField4, integerField4, booleanField4, stringField5, integerField5, booleanField5, stringField6, integerField6, booleanField6, stringField7, stringField8, stringField9);
    }
}