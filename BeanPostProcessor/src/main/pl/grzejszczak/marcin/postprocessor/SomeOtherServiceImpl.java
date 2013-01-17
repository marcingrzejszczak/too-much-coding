package pl.grzejszczak.marcin.postprocessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeOtherServiceImpl implements SomeOtherService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SomeOtherServiceImpl.class);

	public SomeOtherServiceImpl() {
		LOGGER.debug("SomeOtherServiceImpl - I'm created!");
	}

	private void afterInit() {
		LOGGER.debug("SomeOtherServiceImpl - After init!");
	}

	private void destroyMethod() {
		LOGGER.debug("SomeOtherServiceImpl - Destroy Method!");
	}

	@Override
	public void methodC() {
		LOGGER.debug("SomeOtherServiceImpl - Method C executed");
	}

	@Override
	public void methodD() {
		LOGGER.debug("SomeOtherServiceImpl - Method D executed");
	}

}
