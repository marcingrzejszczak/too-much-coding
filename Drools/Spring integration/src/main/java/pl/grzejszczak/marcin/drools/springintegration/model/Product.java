package pl.grzejszczak.marcin.drools.springintegration.model;

import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public class Product {
    private final TypeEnum typeEnum;
    private String productName;

    public Product(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
        productName = typeEnum.getSomeOutputString();
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
