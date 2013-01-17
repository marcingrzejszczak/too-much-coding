package pl.grzejszczak.marcin.camel.manual.jms;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component
public class FinalListenerImpl implements MessageListener {

	private static final Logger LOG = LoggerFactory.getLogger(FinalListenerImpl.class);

	@Autowired
	private MessageConverter messageConverter;

	@Override
	public void onMessage(Message message) {
		if (!(message instanceof BytesMessage)) {
			LOG.error("Wrong msg!");
			return;
		}

		PlayerDetails playerDetails = null;
		try {
			playerDetails = (PlayerDetails) messageConverter.fromMessage(message);

			if (playerDetails.getTeamName() != null) {
				LOG.debug("Message already enriched! Shutting down the system");
				System.exit(0);
			} else {
				LOG.debug("The message should have been enriched but wasn't");
				System.exit(1);
			}

		} catch (Exception e) {
			LOG.error("Exception occured", e);
		}
	}

}
