package pl.grzejszczak.marcin.drools.springintegration.factory.drools;

import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.springintegration.factory.ProcessingFactory;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("ProductProcessingFactory")
public class ProductProcessingFactory implements ProcessingFactory<StatelessKnowledgeSession, Product> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public StatelessKnowledgeSession createProcessingObject(Product inputObject) {
        return (StatelessKnowledgeSession)applicationContext.getBean(inputObject.getTypeEnum().getType() + "KSession");
    }
}
