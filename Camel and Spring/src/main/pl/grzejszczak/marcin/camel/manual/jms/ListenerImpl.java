package pl.grzejszczak.marcin.camel.manual.jms;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.support.converter.MessageConverter;

import pl.grzejszczak.marcin.camel.enricher.Enrichable;
import pl.grzejszczak.marcin.camel.jaxb.Convertable;
import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

public class ListenerImpl implements MessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(ListenerImpl.class);

	public ListenerImpl() {
		LOG.info("Listener is created");
	}

	@Autowired
	private Convertable<PlayerDetails> playerDetailsConverter;

	@Autowired
	@Qualifier("enrichingService")
	private Enrichable<PlayerDetails> enrichingService;

	@Autowired
	private MessageConverter messageConverter;

	@Autowired
	@Qualifier("destinationPlayerSender")
	private Sender<PlayerDetails> sender;

	@Override
	public void onMessage(Message message) {
		if (!(message instanceof BytesMessage)) {
			LOG.error("Wrong msg!");
			return;
		}

		PlayerDetails playerDetails = null;
		try {
			playerDetails = (PlayerDetails) messageConverter.fromMessage(message);

			LOG.debug("Enriching the input message");
			enrichingService.enrich(playerDetails);

			LOG.debug("Enriched text message: [{}]", new Object[] { playerDetailsConverter.marshal(playerDetails) });
			sender.sendMessage(playerDetails);
		} catch (Exception e) {
			LOG.error("Exception occured", e);
		}

	}

}
