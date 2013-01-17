package pl.grzejszczak.marcin.drools.springintegration.service.nondrools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.service.Processor;
import pl.grzejszczak.marcin.drools.springintegration.utils.SomeUtil;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public class ElectronicProductProcessingService implements Processor<Product> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElectronicProductProcessingService.class);

    @Override
    public void process(Product input) {
        checkArgument(TypeEnum.ELECTRONIC.equals(input.getTypeEnum()), "This processing service works only for electronic devices");
        checkArgument(!SomeUtil.replaceAWithB(input.getProductName()).equals(input.getProductName()), "The input has already been processed");
        LOGGER.debug("Running processing for Electronic Product");
        input.setProductName(SomeUtil.replaceAWithB(input.getProductName()));
        LOGGER.debug(format("ELECTRONIC rule applied without Drools, product name is now equal to [%s]", input.getProductName()));
    }
}
