package pl.grzejszczak.marcin.aop.type;


public enum Role {
	ADMIN("ADM"), WRITER("WRT"), GUEST("GST");

	private String name;

	private Role(String name) {
		this.name = name;
	}

	public static Role getRoleByName(String name) {

		for (Role role : Role.values()) {

			if (role.name.equals(name)) {
				return role;
			}
		}

		throw new IllegalArgumentException("No such role exists [" + name + "]");
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

}
