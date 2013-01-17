package pl.grzejszczak.marcin.aop;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.grzejszczak.marcin.aop.service.UserService;
import pl.grzejszczak.marcin.aop.type.Role;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForAdmin;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForAdminAndGuest;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForGuest;
import pl.grzejszczak.marcin.aop.ui.SomeComponentForWriter;
import pl.grzejszczak.marcin.aop.ui.UIFactory;
import pl.grzejszczak.marcin.aop.user.UserHolder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:aopApplicationContext.xml" })
public class AopTest {

	@Autowired
	private UIFactory uiFactory;

	@Autowired
	private UserService userService;

	@Test
	public void adminTest() throws Exception {
		userService.setCurrentUser(new UserHolder(Role.ADMIN));
		Assert.assertNotNull(uiFactory.createComponent(SomeComponentForAdmin.class));
		Assert.assertNotNull(uiFactory.createComponent(SomeComponentForAdminAndGuest.class));
		Assert.assertNull(uiFactory.createComponent(SomeComponentForGuest.class));
		Assert.assertNull(uiFactory.createComponent(SomeComponentForWriter.class));
	}
}
