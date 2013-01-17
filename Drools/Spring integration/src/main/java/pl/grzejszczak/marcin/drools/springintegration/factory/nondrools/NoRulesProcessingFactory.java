package pl.grzejszczak.marcin.drools.springintegration.factory.nondrools;

import com.google.common.collect.ImmutableMap;
import org.springframework.stereotype.Component;
import pl.grzejszczak.marcin.drools.springintegration.enums.TypeEnum;
import pl.grzejszczak.marcin.drools.springintegration.factory.ProcessingFactory;
import pl.grzejszczak.marcin.drools.springintegration.model.Product;
import pl.grzejszczak.marcin.drools.springintegration.service.nondrools.ElectronicProductProcessingService;
import pl.grzejszczak.marcin.drools.springintegration.service.nondrools.MedicalProductProcessingService;
import pl.grzejszczak.marcin.drools.springintegration.service.Processor;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
@Component("NoRulesProcessingFactory")
public class NoRulesProcessingFactory  implements ProcessingFactory<Processor, Product> {

    private static final Map<TypeEnum, Processor> PROCESSOR_MAP = new ImmutableMap.Builder<TypeEnum, Processor>().
            put(TypeEnum.MEDICAL, new MedicalProductProcessingService()).
            put(TypeEnum.ELECTRONIC, new ElectronicProductProcessingService()).
            build();

    /**
     * By using the map we don't have any ifs
     * @param inputObject
     * @return
     */
    @Override
    public Processor createProcessingObject(Product inputObject) {
        return PROCESSOR_MAP.get(inputObject.getTypeEnum());
    }
}
