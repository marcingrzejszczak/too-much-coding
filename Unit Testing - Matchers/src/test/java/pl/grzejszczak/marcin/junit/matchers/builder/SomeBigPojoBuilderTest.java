package pl.grzejszczak.marcin.junit.matchers.builder;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;

import static java.lang.String.format;
import static junit.framework.Assert.assertTrue;
import static org.apache.commons.lang.StringUtils.isNumeric;
import static org.junit.Assert.assertThat;
import static pl.grzejszczak.marcin.junit.matchers.pojo.SomePojoConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 23:02
 */
public class SomeBigPojoBuilderTest {

    private SomeBigPojoBuilder objectUnderTest;

    @Before
    public void setUp(){
        objectUnderTest = new SomeBigPojoBuilder();
    }

    @Test
    public void testCreateSomeBigPojoWithBuilder() throws Exception {
        SomeBigPojo someBigPojo = objectUnderTest
                .setBooleanField1(true)
                .setStringField0("1")
                .setStringField1("12")
                .setStringField2("123")
                .setStringField3("1234")
                .setStringField4("12345")
                .setStringField5("123456")
                .setStringField6("1234567")
                .setStringField7("12345678")
                .setStringField8("123456789")
                .setStringField9("1234567890")
                .createSomeBigPojoWithBuilder();

        assertThat(someBigPojo, isPojoProperlyBuilt());
    }

    @Test(expected = AssertionError.class)
    public void testCreateSomeBigPojoWithBuilderWrongFields() throws Exception {
        SomeBigPojo someBigPojo = objectUnderTest
                .setStringField0("0")
                .setStringField1("Too long")
                .createSomeBigPojoWithBuilder();

        assertThat(someBigPojo, isPojoProperlyBuilt());
    }

    /**
     * Let us assume that there is a specific business case that we have to take into consideration regarding some particular field
     *
     * @return
     */
    private static Matcher isPojoProperlyBuilt() {

        return new BaseMatcher() {

            @Override
            public boolean matches(Object o) {
                assertTrue(o instanceof SomeBigPojo);
                SomeBigPojo someBigPojo = (SomeBigPojo) o;
                assertThat(someBigPojo.getStringField0(), isOfGivenLength(STRING_FIELD_0_LENGTH));
                assertThat(someBigPojo.getStringField0(), isFieldOfNumericValue());

                assertThat(someBigPojo.getStringField1(), isOfGivenLength(STRING_FIELD_1_LENGTH));
                assertThat(someBigPojo.getStringField1(), isFieldOfNumericValue());

                assertThat(someBigPojo.getStringField2(), isOfGivenLength(STRING_FIELD_2_LENGTH));
                assertThat(someBigPojo.getStringField2(), isFieldOfNumericValue());

                assertThat(someBigPojo.getStringField3(), isOfGivenLength(STRING_FIELD_3_LENGTH));
                assertThat(someBigPojo.getStringField3(), isFieldOfNumericValue());

                assertThat(someBigPojo.getStringField4(), isOfGivenLength(STRING_FIELD_4_LENGTH));
                assertThat(someBigPojo.getStringField4(), isFieldOfNumericValue());

                assertThat(someBigPojo.getStringField5(), isOfGivenLength(STRING_FIELD_5_LENGTH));

                assertThat(someBigPojo.getStringField6(), isOfGivenLength(STRING_FIELD_6_LENGTH));

                assertThat(someBigPojo.getStringField7(), isOfGivenLength(STRING_FIELD_7_LENGTH));

                assertThat(someBigPojo.getStringField8(), isOfGivenLength(STRING_FIELD_8_LENGTH));

                assertThat(someBigPojo.getStringField9(), isOfGivenLength(STRING_FIELD_9_LENGTH));

                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Lengths of fields are limited and the first 4 fields are numeric");
            }
        };
    }

    private static Matcher isOfGivenLength(final Integer expectedLength) {

        return new BaseMatcher() {

            public boolean matches(Object o) {
                assertTrue(o instanceof String);
                return expectedLength == String.valueOf(o).length();
            }

            public void describeTo(Description description) {
                description.appendText(format("String's length should be equal to [%d]", expectedLength));
            }
        };
    }

    private static Matcher isFieldOfNumericValue() {

        return new BaseMatcher() {

            public boolean matches(Object o) {
                assertTrue(o instanceof String);
                return isNumeric(String.valueOf(o));
            }

            public void describeTo(Description description) {
                description.appendText("The value of the field should be numeric");
            }
        };
    }
}
