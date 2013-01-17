package pl.grzejszczak.marcin.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeServiceImpl implements SomeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SomeServiceImpl.class);

	public SomeServiceImpl() {
		LOGGER.debug("SomeServiceImpl - I'm created!");
	}

	private void afterInit() {
		LOGGER.debug("SomeServiceImpl - After init!");
	}

	private void destroyMethod() {
		LOGGER.debug("SomeServiceImpl - Destroy Method!");
	}

	@Override
	public void methodA() {
		LOGGER.debug("SomeServiceImpl - Method A executed");
	}

	@Override
	public void methodB() {
		LOGGER.debug("SomeServiceImpl - Method B executed");
	}

}
