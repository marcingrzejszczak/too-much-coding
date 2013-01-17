package pl.grzejszczak.marcin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.grzejszczak.marcin.junit.Processable;
import pl.grzejszczak.marcin.junit.SomeTask;

public class ServiceIntegrationTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceIntegrationTest.class);

	private ExecutorService executorService = Executors.newSingleThreadExecutor();
	private Processable timeConsumingExternalServiceMock = Mockito.mock(Processable.class);
	private SomeTask someTask = new SomeTask();

	public ServiceIntegrationTest() {
		initializeMocks();
	}

	private void initializeMocks() {
		Mockito.doAnswer(new Answer<Object>() {
			public Object answer(InvocationOnMock invocation) throws Throwable {
				// Simulation of connection to external services
				LOGGER.debug("Sleeping");
				Thread.sleep(5000);
				LOGGER.debug("Stopped Sleeping");
				return null;
			}
		}).when(timeConsumingExternalServiceMock).process();
		// Inject the mock to the Task - in any possible way
		someTask.setTimeConsumingExternalService(timeConsumingExternalServiceMock);
	}

	public void executeTest() {
		executorService.execute(someTask);
	}

	public static void main(String args[]) {
		ServiceIntegrationTest integrationTest = new ServiceIntegrationTest();
		integrationTest.executeTest();
	}
}
