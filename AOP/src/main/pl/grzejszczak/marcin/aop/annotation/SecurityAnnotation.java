package pl.grzejszczak.marcin.aop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import pl.grzejszczak.marcin.aop.type.Role;

@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityAnnotation {
	Role[] allowedRole();
}
