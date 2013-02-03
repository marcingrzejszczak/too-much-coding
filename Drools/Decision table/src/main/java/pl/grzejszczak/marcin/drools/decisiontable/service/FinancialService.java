package pl.grzejszczak.marcin.drools.decisiontable.service;

import pl.grzejszczak.marcin.drools.decisiontable.model.Product;
import pl.grzejszczak.marcin.drools.decisiontable.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 03.02.13
 * Time: 18:45
 */
public interface FinancialService {
    boolean processOrder(User user, Product product);
}
