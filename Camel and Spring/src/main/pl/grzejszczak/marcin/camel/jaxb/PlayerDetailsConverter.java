package pl.grzejszczak.marcin.camel.jaxb;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.activemq.util.ByteArrayInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;

@Component("PlayerDetailsConverter")
public class PlayerDetailsConverter implements Convertable<PlayerDetails> {
	private static final Logger LOGGER = LoggerFactory.getLogger(PlayerDetailsConverter.class);

	private final JAXBContext jaxbContext;
	private final Marshaller jaxbMarshaller;
	private final Unmarshaller jaxbUnmarshaller;

	public PlayerDetailsConverter() throws JAXBException {
		jaxbContext = JAXBContext.newInstance(PlayerDetails.class);
		jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	}

	@Override
	public String marshal(PlayerDetails object) {
		OutputStream stream = new ByteArrayOutputStream();
		try {
			jaxbMarshaller.marshal(object, stream);
		} catch (JAXBException e) {
			LOGGER.error("Exception occured while marshalling", e);
		}
		return stream.toString();
	}

	@Override
	public PlayerDetails unmarshal(String objectAsString) {
		try {
			return (PlayerDetails) jaxbUnmarshaller.unmarshal(new ByteArrayInputStream(objectAsString.getBytes()));
		} catch (JAXBException e) {
			LOGGER.error("Exception occured while marshalling", e);
		}
		return null;
	}

}
