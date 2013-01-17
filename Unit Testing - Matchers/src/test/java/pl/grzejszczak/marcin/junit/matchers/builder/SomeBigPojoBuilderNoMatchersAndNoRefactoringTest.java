package pl.grzejszczak.marcin.junit.matchers.builder;

import org.junit.Before;
import org.junit.Test;
import pl.grzejszczak.marcin.junit.matchers.pojo.SomeBigPojo;

import static junit.framework.Assert.assertTrue;
import static org.apache.commons.lang.StringUtils.isNumeric;
import static pl.grzejszczak.marcin.junit.matchers.pojo.SomePojoConstants.*;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.01.13
 * Time: 23:02
 */
public class SomeBigPojoBuilderNoMatchersAndNoRefactoringTest {

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
        assertTrue(someBigPojo.getStringField0().length() == STRING_FIELD_0_LENGTH);
        assertTrue(isNumeric(someBigPojo.getStringField0()));

        assertTrue(someBigPojo.getStringField1().length() == STRING_FIELD_1_LENGTH);
        assertTrue(isNumeric(someBigPojo.getStringField0()));

        assertTrue(someBigPojo.getStringField2().length() == STRING_FIELD_2_LENGTH);
        assertTrue(isNumeric(someBigPojo.getStringField0()));

        assertTrue(someBigPojo.getStringField3().length() == STRING_FIELD_3_LENGTH);
        assertTrue(isNumeric(someBigPojo.getStringField0()));

        assertTrue(someBigPojo.getStringField4().length() == STRING_FIELD_4_LENGTH);
        assertTrue(isNumeric(someBigPojo.getStringField0()));

        assertTrue(someBigPojo.getStringField5().length() == STRING_FIELD_5_LENGTH);

        assertTrue(someBigPojo.getStringField6().length() == STRING_FIELD_6_LENGTH);

        assertTrue(someBigPojo.getStringField7().length() == STRING_FIELD_7_LENGTH);

        assertTrue(someBigPojo.getStringField8().length() == STRING_FIELD_8_LENGTH);

        assertTrue(someBigPojo.getStringField9().length() == STRING_FIELD_9_LENGTH);

    }
}
