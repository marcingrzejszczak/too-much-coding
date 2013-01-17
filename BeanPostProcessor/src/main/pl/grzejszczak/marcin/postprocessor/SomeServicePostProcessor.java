package pl.grzejszczak.marcin.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SomeServicePostProcessor extends AbstractBeanPostProcessor<SomeService> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SomeServicePostProcessor.class);

	public SomeServicePostProcessor() {
		super(SomeService.class);
	}

	@Override
	public void doBefore() {
		LOGGER.info("BEFORE it's init method has been executed but AFTER SomeServiceImpl has been instantiated I would like to do sth...");
	}

	@Override
	public void doAfter() {
		LOGGER.info("AFTER SomeServiceImpl has executed its init method I would like to do sth more...");
	}
}
