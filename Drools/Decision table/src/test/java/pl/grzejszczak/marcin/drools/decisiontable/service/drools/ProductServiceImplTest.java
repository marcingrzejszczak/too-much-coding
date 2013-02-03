package pl.grzejszczak.marcin.drools.decisiontable.service.drools;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.grzejszczak.marcin.drools.decisiontable.model.*;
import pl.grzejszczak.marcin.drools.decisiontable.service.ProductService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.02.13
 * Time: 16:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ProductServiceImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImplTest.class);

    @Autowired
    ProductService objectUnderTest;

    @Test
    public void testRunProductLogicUserPlUnderageElectronicCountryPLQuantity10() throws Exception {
        int initialPrice = 1000;
        int userAge = 6;
        int quantity = 10;

        User user = createUser("Smith", CountryType.PL, userAge);
        Product product = createProduct("Electronic", initialPrice, CountryType.PL, ProductType.ELECTRONIC, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);

        assertTrue(product.getPrice() == initialPrice);
        assertEquals(DecisionType.REJECTED, user.getDecision());
    }

    @Test
    public void testRunProductLogicUserPlAge19ElectronicCountryPLQuantity1() throws Exception {
        int initialPrice = 1000;
        int userAge = 19;
        int quantity = 1;

        User user = createUser("Smith", CountryType.PL, userAge);
        Product product = createProduct("Electronic", initialPrice, CountryType.PL, ProductType.ELECTRONIC, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);

        assertTrue(product.getPrice() == initialPrice);
        assertEquals(DecisionType.ACCEPTED, user.getDecision());
    }

    @Test
    public void testRunProductLogicUserPlAge19ElectronicCountryPLQuantity10() throws Exception {
        int initialPrice = 1000;
        int userAge = 19;
        int quantity = 8;

        User user = createUser("Smith", CountryType.PL, userAge);
        Product product = createProduct("Electronic", initialPrice, CountryType.PL, ProductType.ELECTRONIC, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);
        double expectedDiscount = 0.1;

        assertTrue(product.getPrice() == initialPrice * (1 - expectedDiscount));
        assertEquals(DecisionType.ACCEPTED, user.getDecision());
    }

    @Test
    public void testRunProductLogicUserUsaAge19ElectronicCountryPLQuantity10() throws Exception {
        int initialPrice = 1000;
        int userAge = 19;
        int quantity = 8;

        User user = createUser("Smith", CountryType.USA, userAge);
        Product product = createProduct("Electronic", initialPrice, CountryType.PL, ProductType.ELECTRONIC, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);

        assertTrue(product.getPrice() == initialPrice);
        assertEquals(DecisionType.REJECTED, user.getDecision());
    }

    @Test
    public void testRunProductLogicUserUsaAge22MedicalCountrySWEQuantity4() throws Exception {
        int initialPrice = 1000;
        int userAge = 22;
        int quantity = 4;

        User user = createUser("Smith", CountryType.USA, userAge);
        Product product = createProduct("Some name", initialPrice, CountryType.SWE, ProductType.MEDICAL, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);

        assertTrue(product.getPrice() == initialPrice);
        assertEquals(DecisionType.ACCEPTED, user.getDecision());
    }

    @Test
    public void testRunProductLogicUserUsaAge22MedicalCountrySWEQuantity8() throws Exception {
        int initialPrice = 1000;
        int userAge = 22;
        int quantity = 8;

        User user = createUser("Smith", CountryType.USA, userAge);
        Product product = createProduct("Some name", initialPrice, CountryType.SWE, ProductType.MEDICAL, quantity);

        printInputs(user, product);

        objectUnderTest.runProductLogic(user, product);

        printInputs(user, product);
        double expectedDiscount = 0.25;

        assertTrue(product.getPrice() == initialPrice * (1 - expectedDiscount));
        assertEquals(DecisionType.ACCEPTED, user.getDecision());
    }

    private void printInputs(User user, Product product) {
        LOGGER.debug(ReflectionToStringBuilder.reflectionToString(user, ToStringStyle.MULTI_LINE_STYLE));
        LOGGER.debug(ReflectionToStringBuilder.reflectionToString(product, ToStringStyle.MULTI_LINE_STYLE));
    }

    private User createUser(String name, CountryType countryType, int userAge){
        User user = new User();
        user.setUserName(name);
        user.setUserCountry(countryType);
        user.setUserAge(userAge);
        return user;
    }

    private Product createProduct(String name, double price, CountryType countryOfOrigin, ProductType productType, int quantity){
        Product product = new Product();
        product.setPrice(price);
        product.setCountryOfOrigin(countryOfOrigin);
        product.setName(name);
        product.setType(productType);
        product.setQuantity(quantity);
        return product;
    }

}
