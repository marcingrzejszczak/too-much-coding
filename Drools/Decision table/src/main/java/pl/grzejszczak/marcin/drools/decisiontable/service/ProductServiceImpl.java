package pl.grzejszczak.marcin.drools.decisiontable.service;

import org.apache.camel.CamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.decisiontable.model.Product;
import pl.grzejszczak.marcin.drools.decisiontable.model.User;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    CamelContext camelContext;

    @Autowired
    FinancialService financialService;

    @Override
    public void runProductLogic(User user, Product product) {
        LOGGER.debug("Running product logic - first acceptance Route, then discount Route");
        camelContext.createProducerTemplate().sendBody("direct:acceptanceRoute", newArrayList(user, product));
        camelContext.createProducerTemplate().sendBody("direct:discountRoute", newArrayList(user, product));
        financialService.processOrder(user, product);
    }

}
