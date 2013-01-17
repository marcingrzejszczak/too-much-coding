package pl.grzejszczak.marcin.aop.ui;

import pl.grzejszczak.marcin.aop.annotation.SecurityAnnotation;
import pl.grzejszczak.marcin.aop.type.Role;

@SecurityAnnotation(allowedRole = { Role.ADMIN })
public class SomeComponentForAdmin extends UIComponent {

	public SomeComponentForAdmin() {
		this.componentName = "SomeComponentForAdmin";
	}

	public static UIComponent getComponent() {
		return new SomeComponentForAdmin();
	}
}
