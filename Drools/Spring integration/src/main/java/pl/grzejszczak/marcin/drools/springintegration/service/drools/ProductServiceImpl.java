package pl.grzejszczak.marcin.drools.springintegration.service.drools;

import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;
import pl.grzejszczak.marcin.drools.springintegration.factory.ProcessingFactory;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.service.ProductService;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    @Qualifier("ProductProcessingFactory")
    ProcessingFactory<StatelessKnowledgeSession, Product> processingFactory;

    @Override
    public void runProductLogic() {
        LOGGER.debug("Running product logic");
        Product medicalProduct = new Product(TypeEnum.MEDICAL);
        Product electronicProduct = new Product(TypeEnum.ELECTRONIC);
        StatelessKnowledgeSession statelessKnowledgeSession = processingFactory.createProcessingObject(medicalProduct);
        LOGGER.debug("Running rules for products...");
        statelessKnowledgeSession.execute(newArrayList(medicalProduct, electronicProduct));
        LOGGER.debug("...finished running products.");
    }
}
