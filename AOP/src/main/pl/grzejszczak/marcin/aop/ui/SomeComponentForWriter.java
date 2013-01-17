package pl.grzejszczak.marcin.aop.ui;

import pl.grzejszczak.marcin.aop.annotation.SecurityAnnotation;
import pl.grzejszczak.marcin.aop.type.Role;

@SecurityAnnotation(allowedRole = { Role.WRITER })
public class SomeComponentForWriter extends UIComponent {

	public SomeComponentForWriter() {
		this.componentName = "SomeComponentForWriter";
	}

	public static UIComponent getComponent() {
		return new SomeComponentForWriter();
	}
}
