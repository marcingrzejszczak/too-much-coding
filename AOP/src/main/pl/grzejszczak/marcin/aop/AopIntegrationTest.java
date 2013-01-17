package pl.grzejszczak.marcin.aop;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.grzejszczak.marcin.aop.service.UserService;
import pl.grzejszczak.marcin.aop.type.Role;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForAdmin;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForGuest;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForWriter;
import pl.grzejszczak.marcin.aop.ui.UIFactory;
import pl.grzejszczak.marcin.aop.user.UserHolder;

public class AopIntegrationTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopApplicationContext.xml");

		UIFactory uiFactory = context.getBean(UIFactory.class);
		UserService userService = context.getBean(UserService.class);

		userService.setCurrentUser(new UserHolder(Role.ADMIN));
		Assert.assertNotNull(uiFactory.createComponent(SomeComponentForAdmin.class));
		Assert.assertNull(uiFactory.createComponent(SomeComponentForGuest.class));
		Assert.assertNull(uiFactory.createComponent(SomeComponentForWriter.class));

	}
}
