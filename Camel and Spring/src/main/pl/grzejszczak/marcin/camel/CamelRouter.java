package pl.grzejszczak.marcin.camel;

import org.apache.camel.spring.Main;

public class CamelRouter {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Main main = new Main();
		main.setApplicationContextUri("/camel/camelContext.xml");
		main.run(args);
	}

}
