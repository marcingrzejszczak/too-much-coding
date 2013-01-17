package pl.grzejszczak.marcin.junit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.grzejszczak.marcin.junit.invocation.SomePojo;

/**
 * Service that does some things including processing of the external service
 * 
 * @author marcin
 * 
 */
public class SomeTask implements Runnable {

	private static final Logger LOGGER = LoggerFactory.getLogger(SomeTask.class);

	// Service is injected via a dependency injection system
	private Processable timeConsumingExternalService;

	private void methodThatConnectsToExternalServices() {
		// connects to an external service and spends a couple of seconds there
		LOGGER.debug("Before processing");
		timeConsumingExternalService.process();
		LOGGER.debug("After processing");
	}

	public void run() {
		methodThatConnectsToExternalServices();
	}

	public void setTimeConsumingExternalService(Processable timeConsumingExternalService) {
		this.timeConsumingExternalService = timeConsumingExternalService;
	}

}
