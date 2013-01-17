package pl.grzejszczak.marcin.camel.enricher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component("ClubEnricher")
public class ClubEnricher implements Enrichable<PlayerDetails> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClubEnricher.class);

	@Override
	public void enrich(PlayerDetails inputObject) {
		LOGGER.debug("Enriching player [{}] with club data", new Object[] { inputObject.getSurname() });
		// Simulating accessing DB or some other service
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			LOGGER.error("Exception while sleeping occured", e);
		}
		inputObject.setTeamName("Borussia Dortmund");
	}

}
