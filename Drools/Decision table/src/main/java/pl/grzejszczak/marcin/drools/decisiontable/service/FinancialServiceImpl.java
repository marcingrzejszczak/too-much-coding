package pl.grzejszczak.marcin.drools.decisiontable.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.decisiontable.model.Product;
import pl.grzejszczak.marcin.drools.decisiontable.model.User;

import static pl.grzejszczak.marcin.drools.decisiontable.model.DecisionType.ACCEPTED;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.02.13
 * Time: 18:45
 */
@Component("financialServiceImpl")
public class FinancialServiceImpl implements FinancialService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinancialServiceImpl.class);

    @Override
    public boolean processOrder(User user, Product product) {
        if(ACCEPTED.equals(user.getDecision())){
            LOGGER.debug("User has been approved - processing the order...");
            return true;
        }

        LOGGER.debug("Sorry, user has been rejected...");
        return false;
    }
}
