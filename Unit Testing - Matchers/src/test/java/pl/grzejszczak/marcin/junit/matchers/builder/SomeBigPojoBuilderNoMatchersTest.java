package pl.grzejszczak.marcin.junit.matchers.builder;

import org.junit.Before;
import org.junit.Test;
import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.apache.commons.lang.StringUtils.isNumeric;
import static pl.grzejszczak.marcin.junit.matchers.pojo.SomePojoConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 23:02
 */
public class SomeBigPojoBuilderNoMatchersTest {

    private SomeBigPojoBuilder objectUnderTest;

    @Before
    public void setUp() {
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

        isPojoProperlyBuilt(someBigPojo);
    }

    @Test(expected = AssertionError.class)
    public void testCreateSomeBigPojoWithBuilderWrongFields() throws Exception {
        SomeBigPojo someBigPojo = objectUnderTest
                .setStringField0("0")
                .setStringField1("too long")
                .createSomeBigPojoWithBuilder();

        isPojoProperlyBuilt(someBigPojo);
    }

    private void isPojoProperlyBuilt(SomeBigPojo someBigPojo) {
        isOfGivenLength(someBigPojo.getStringField0(), STRING_FIELD_0_LENGTH);
        isFieldOfNumericValue(someBigPojo.getStringField0());

        isOfGivenLength(someBigPojo.getStringField1(), STRING_FIELD_1_LENGTH);
        isFieldOfNumericValue(someBigPojo.getStringField0());

        isOfGivenLength(someBigPojo.getStringField2(), STRING_FIELD_2_LENGTH);
        isFieldOfNumericValue(someBigPojo.getStringField0());

        isOfGivenLength(someBigPojo.getStringField3(), STRING_FIELD_3_LENGTH);
        isFieldOfNumericValue(someBigPojo.getStringField0());

        isOfGivenLength(someBigPojo.getStringField4(), STRING_FIELD_4_LENGTH);
        isFieldOfNumericValue(someBigPojo.getStringField0());

        isOfGivenLength(someBigPojo.getStringField5(), STRING_FIELD_5_LENGTH);

        isOfGivenLength(someBigPojo.getStringField6(), STRING_FIELD_6_LENGTH);

        isOfGivenLength(someBigPojo.getStringField7(), STRING_FIELD_7_LENGTH);

        isOfGivenLength(someBigPojo.getStringField8(), STRING_FIELD_8_LENGTH);

        isOfGivenLength(someBigPojo.getStringField9(), STRING_FIELD_9_LENGTH);

    }

    private void isOfGivenLength(String pojo, final Integer expectedLength) {
        assertNotNull(pojo);
        assertTrue(expectedLength == pojo.length());
    }

    private void isFieldOfNumericValue(String field) {
        assertTrue(isNumeric(field));
    }
}
