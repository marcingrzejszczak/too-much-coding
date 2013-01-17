package pl.grzejszczak.marcin.aop.ui;

import pl.grzejszczak.marcin.aop.annotation.SecurityAnnotation;
import pl.grzejszczak.marcin.aop.type.Role;

@SecurityAnnotation(allowedRole = { Role.GUEST })
public class SomeComponentForGuest extends UIComponent {

	public SomeComponentForGuest() {
		this.componentName = "SomeComponentForGuest";
	}

	public static UIComponent getComponent() {
		return new SomeComponentForGuest();
	}
}
