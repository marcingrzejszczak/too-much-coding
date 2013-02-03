package pl.grzejszczak.marcin.drools.decisiontable.converter;

import org.apache.camel.Converter;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.grzejszczak.marcin.drools.decisiontable.model.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 30.01.13
 * Time: 21:42
 */
@Converter
public class ProductTypeConverter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeConverter.class);

    @Converter
    public static Command toCommandFromList(List inputList) {
        LOGGER.debug("Executing ProductTypeConverter's toCommandFromList method");
        return CommandFactory.newInsertElements(inputList);
    }

    @Converter
    public static Command toCommand(Product product) {
        LOGGER.debug("Executing ProductTypeConverter's toCommand method");
        return CommandFactory.newInsert(product);
    }
}
