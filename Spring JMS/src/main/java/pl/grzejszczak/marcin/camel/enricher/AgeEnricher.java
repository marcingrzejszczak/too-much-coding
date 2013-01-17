package pl.grzejszczak.marcin.camel.enricher;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component("AgeEnricher")
public class AgeEnricher implements Enrichable<PlayerDetails> {
	private static final Logger LOGGER = LoggerFactory.getLogger(AgeEnricher.class);

	@Override
	public void enrich(PlayerDetails inputObject) {
		LOGGER.debug("Enriching player [{}] with age data", new Object[] { inputObject.getSurname() });
		// Simulating accessing DB or some other service
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.error("Exception while sleeping occured", e);
		}
		inputObject.setAge(new Random().nextInt(35));
	}

}
