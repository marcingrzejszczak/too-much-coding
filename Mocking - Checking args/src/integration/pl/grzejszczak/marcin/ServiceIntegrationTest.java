package pl.grzejszczak.marcin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.grzejszczak.marcin.junit.Processable;
import pl.grzejszczak.marcin.junit.SomeTask;
import pl.grzejszczak.marcin.junit.invocation.SomePojo;

public class ServiceIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceIntegrationTest.class);

	private ExecutorService executorService = Executors.newCachedThreadPool();
	private Processable timeConsumingExternalServiceMock = Mockito.mock(Processable.class);
	private SomeTask someTask = new SomeTask();

	public ServiceIntegrationTest() {
		initializeMocks();
	}

	private void initializeMocks() {
		// Inject the mock to the Task - in any possible way
		someTask.setTimeConsumingExternalService(timeConsumingExternalServiceMock);
	}

	public void executeTest() {
		executorService.execute(someTask);

		final ArgumentCaptor<SomePojo> argumentCaptor = ArgumentCaptor.forClass(SomePojo.class);
		Mockito.verify(timeConsumingExternalServiceMock).processSomeObject(argumentCaptor.capture());
		SomePojo somePojo = argumentCaptor.getValue();
		Assert.assertEquals("name", somePojo.getName());
		LOGGER.debug("Names are equal");
		Assert.assertEquals("surname", somePojo.getSurname());
		LOGGER.debug("Surnames are equal");
		Assert.assertTrue(1 == somePojo.getIntValue());
		LOGGER.debug("Ints are equal");
		Assert.assertTrue(1.0 == somePojo.getDoubleValue());
		LOGGER.debug("Doubles are equal");

	}

	public static void main(String args[]) {
		ServiceIntegrationTest integrationTest = new ServiceIntegrationTest();
		integrationTest.executeTest();
		System.exit(0);
	}
}
