package pl.grzejszczak.marcin.camel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.grzejszczak.marcin.camel.enricher.Enrichable;
import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

public class EnrichingServiceImpl implements Enrichable<PlayerDetails> {

	private static final Logger LOGGER = LoggerFactory.getLogger(EnrichingServiceImpl.class);

	@Autowired
	private List<Enrichable<PlayerDetails>> listOfEnrichers;

	@Override
	public void enrich(PlayerDetails playerDetails) {
		LOGGER.debug("Enriching player details");

		for (Enrichable<PlayerDetails> enrichable : listOfEnrichers) {
			enrichable.enrich(playerDetails);
		}
	}

}
