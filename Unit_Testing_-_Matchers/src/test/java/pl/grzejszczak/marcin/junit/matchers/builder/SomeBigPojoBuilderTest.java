package pl.grzejszczak.marcin.junit.matchers.builder;

import static java.lang.String.format;
import static junit.framework.Assert.*;
import static org.apache.commons.lang.StringUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static pl.grzejszczak.marcin.junit.matchers.pojo.SomePojoConstants.*;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;


public class SomeBigPojoBuilderTest {

    SomeBigPojoBuilder objectUnderTest = new SomeBigPojoBuilder();

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

    @Test
    public void should_fail_to_build_pojo() throws Exception {
        // given
	    SomeBigPojo someBigPojo = objectUnderTest
                .setStringField0("0")
                .setStringField1("Too long")
                .createSomeBigPojoWithBuilder();
	    
	    // expect
	    try {
		    assertThat(someBigPojo, isPojoProperlyBuilt());
		    fail();
	    } catch (AssertionError error) {}        
    }

    /**
     * Let us assume that there is a specific business case that we have to take into consideration regarding some particular field
     *
     */
    private static Matcher isPojoProperlyBuilt() {

        return new TypeSafeMatcher<SomeBigPojo>() {

            @Override
            public boolean matchesSafely(SomeBigPojo someBigPojo) {
                assertThat(someBigPojo.getStringField0(), both(isOfGivenLength(STRING_FIELD_0_LENGTH)).and(isFieldOfNumericValue()));
                assertThat(someBigPojo.getStringField1(), both(isOfGivenLength(STRING_FIELD_1_LENGTH)).and(isFieldOfNumericValue()));              
                assertThat(someBigPojo.getStringField2(), both(isOfGivenLength(STRING_FIELD_2_LENGTH)).and(isFieldOfNumericValue()));
                assertThat(someBigPojo.getStringField3(), both(isOfGivenLength(STRING_FIELD_3_LENGTH)).and(isFieldOfNumericValue()));
                assertThat(someBigPojo.getStringField4(), both(isOfGivenLength(STRING_FIELD_4_LENGTH)).and(isFieldOfNumericValue()));
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

    private static Matcher<String> isOfGivenLength(final Integer expectedLength) {

        return new TypeSafeMatcher<String>() {

            public boolean matchesSafely(String o) {
                return expectedLength == String.valueOf(o).length();
            }

            public void describeTo(Description description) {
                description.appendText(format("String's length should be equal to [%d]", expectedLength));
            }
        };
    }

    private static Matcher<String> isFieldOfNumericValue() {

        return new TypeSafeMatcher<String>() {

            public boolean matchesSafely(String o) {
                return isNumeric(String.valueOf(o));
            }

            public void describeTo(Description description) {
                description.appendText("The value of the field should be numeric");
            }
        };
    }
}
