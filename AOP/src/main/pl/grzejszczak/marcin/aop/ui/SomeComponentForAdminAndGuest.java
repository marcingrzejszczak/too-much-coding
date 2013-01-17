package pl.grzejszczak.marcin.aop.ui;

import pl.grzejszczak.marcin.aop.annotation.SecurityAnnotation;
import pl.grzejszczak.marcin.aop.type.Role;

@SecurityAnnotation(allowedRole = { Role.ADMIN, Role.GUEST })
public class SomeComponentForAdminAndGuest extends UIComponent {

	public SomeComponentForAdminAndGuest() {
		this.componentName = "SomeComponentForAdmin";
	}

	public static UIComponent getComponent() {
		return new SomeComponentForAdminAndGuest();
	}
}
