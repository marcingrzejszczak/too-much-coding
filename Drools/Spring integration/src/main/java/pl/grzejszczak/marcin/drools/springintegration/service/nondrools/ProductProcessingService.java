package pl.grzejszczak.marcin.drools.springintegration.service.nondrools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.springintegration.factory.ProcessingFactory;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.service.Processor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("ProductProcessingService")
public class ProductProcessingService implements Processor<List<Product>> {

    @Autowired
    @Qualifier("NoRulesProcessingFactory")
    private ProcessingFactory<Processor, Product> processingFactory;

    @Override
    public void process(List<Product> input) {
        for(Product product : input){
            Processor<Product> processor = processingFactory.createProcessingObject(product);
            processor.process(product);
        }
    }
}
