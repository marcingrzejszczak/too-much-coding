package pl.grzejszczak.marcin.drools.decisiontable.service;

import pl.grzejszczak.marcin.drools.decisiontable.model.User;
import pl.grzejszczak.marcin.drools.decisiontable.model.Product;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public interface ProductService {
    void runProductLogic(User user, Product product);
}
