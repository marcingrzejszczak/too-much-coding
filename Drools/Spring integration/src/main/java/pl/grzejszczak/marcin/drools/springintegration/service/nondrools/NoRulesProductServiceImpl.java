package pl.grzejszczak.marcin.drools.springintegration.service.nondrools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.service.Processor;
import pl.grzejszczak.marcin.drools.springintegration.service.ProductService;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("NoRulesProductServiceImpl")
public class NoRulesProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoRulesProductServiceImpl.class);

    @Autowired
    @Qualifier("ProductProcessingService")
    private Processor<List<Product>> productProcessingService;

    @Override
    public void runProductLogic() {
        LOGGER.debug("Running product logic without Drools");
        Product medicalProduct = new Product(TypeEnum.MEDICAL);
        Product electronicProduct = new Product(TypeEnum.ELECTRONIC);
        LOGGER.debug("Running rules for products...");
        productProcessingService.process(newArrayList(medicalProduct, electronicProduct));
        LOGGER.debug("...finished running products.");
    }
}
