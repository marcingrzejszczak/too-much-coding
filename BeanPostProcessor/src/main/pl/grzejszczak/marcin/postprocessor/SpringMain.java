package pl.grzejszczak.marcin.postprocessor;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SomeService someService = context.getBean(SomeService.class);
		someService.methodA();
		someService.methodB();
		SomeOtherService someOtherService = context.getBean(SomeOtherService.class);
		someOtherService.methodC();
		someOtherService.methodD();
		context.close();
	}

}
