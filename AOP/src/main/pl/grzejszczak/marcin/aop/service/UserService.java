package pl.grzejszczak.marcin.aop.service;

import pl.grzejszczak.marcin.aop.type.Role;
import pl.grzejszczak.marcin.aop.user.UserHolder;

public interface UserService {
	UserHolder getCurrentUser();

	void setCurrentUser(UserHolder userHolder);

	Role getUserRole();
}
