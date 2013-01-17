package pl.grzejszczak.marcin.aop.user;

import pl.grzejszczak.marcin.aop.type.Role;

public class UserHolder {
	private Role userRole;

	public UserHolder(Role userRole) {
		this.userRole = userRole;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

}
