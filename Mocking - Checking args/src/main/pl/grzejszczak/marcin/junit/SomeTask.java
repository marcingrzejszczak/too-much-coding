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
		LOGGER.debug("Before processing an object");
		timeConsumingExternalService.processSomeObject(new SomePojo("name", "surname", 1, 1.0));
		LOGGER.debug("After processing an object");
	}

	public void run() {
		methodThatConnectsToExternalServices();
	}

	public Processable getTimeConsumingExternalService() {
		return timeConsumingExternalService;
	}

	public void setTimeConsumingExternalService(Processable timeConsumingExternalService) {
		this.timeConsumingExternalService = timeConsumingExternalService;
	}

}
