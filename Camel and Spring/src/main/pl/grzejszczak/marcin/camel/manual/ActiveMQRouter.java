package pl.grzejszczak.marcin.camel.manual;

import java.io.File;
import java.util.Scanner;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import pl.grzejszczak.marcin.camel.jaxb.PlayerDetailsConverter;
import pl.grzejszczak.marcin.camel.jaxb.generated.PlayerDetails;
import pl.grzejszczak.marcin.camel.manual.jms.FinalListenerImpl;
import pl.grzejszczak.marcin.camel.manual.jms.Sender;

public class ActiveMQRouter {

	/**
	 * @param args
	 * @throws JMSException
	 */
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("/camel/jmsApplicationContext.xml");
		@SuppressWarnings("unchecked")
		Sender<PlayerDetails> sender = (Sender<PlayerDetails>) context.getBean("originPlayerSender");

		Resource resource = new ClassPathResource("/camel/RobertLewandowski.xml");

		Scanner scanner = new Scanner(new File(resource.getURI())).useDelimiter("\\Z");
		String contents = scanner.next();

		PlayerDetailsConverter converter = context.getBean(PlayerDetailsConverter.class);

		FinalListenerImpl listener = (FinalListenerImpl) context.getBean("finalListenerImpl");

		sender.sendMessage(converter.unmarshal(contents));
	}
}
