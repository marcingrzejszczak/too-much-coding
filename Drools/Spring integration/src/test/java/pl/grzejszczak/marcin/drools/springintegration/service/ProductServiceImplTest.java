package pl.grzejszczak.marcin.drools.springintegration.service;

import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;
import pl.grzejszczak.marcin.drools.springintegration.factory.ProcessingFactory;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.utils.SomeUtil;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProductServiceImplTest {

    @Autowired
    @Qualifier("ProductProcessingFactory")
    ProcessingFactory<StatelessKnowledgeSession, Product> processingFactory;

    /**
     * Test is not run in perfect isolation - the purpose is to show the outcome of processing with Drools
     * @throws Exception
     */
    @Test
    public void testRunProductLogic() throws Exception {
        Product medicalProduct = new Product(TypeEnum.MEDICAL);
        Product electronicProduct = new Product(TypeEnum.ELECTRONIC);
        String initialMedicalProductName = medicalProduct.getProductName();
        String initialElectronicProduct = electronicProduct.getProductName();
        System.out.println(format("Initial productName for Medical [%s]", medicalProduct.getProductName()));
        System.out.println(format("Initial productName for Electronic [%s]", electronicProduct.getProductName()));

        StatelessKnowledgeSession statelessKnowledgeSessionForMedical = processingFactory.createProcessingObject(medicalProduct);
        StatelessKnowledgeSession statelessKnowledgeSessionForElectronic = processingFactory.createProcessingObject(electronicProduct);
        assertTrue(statelessKnowledgeSessionForMedical == statelessKnowledgeSessionForElectronic);
        System.out.println("References for stateless sessions are the same, executing rules...");

        statelessKnowledgeSessionForMedical.execute(newArrayList(medicalProduct, electronicProduct));

        String finalMedicalProduct = medicalProduct.getProductName();
        String finalElectronicProduct = electronicProduct.getProductName();
        assertNotSame(finalMedicalProduct, initialMedicalProductName);
        assertNotSame(finalElectronicProduct, initialElectronicProduct);
        assertEquals(SomeUtil.replaceAWithB(initialMedicalProductName), finalMedicalProduct);
        assertEquals(SomeUtil.replaceAWithB(initialElectronicProduct), finalElectronicProduct);

        System.out.println(format("Final productName for Medical [%s]", medicalProduct.getProductName()));
        System.out.println(format("Final productName for Electronic [%s]", electronicProduct.getProductName()));
    }
}
