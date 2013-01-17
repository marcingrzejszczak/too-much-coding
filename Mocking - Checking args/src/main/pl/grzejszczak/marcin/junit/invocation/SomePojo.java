package pl.grzejszczak.marcin.junit.invocation;

public class SomePojo {
	private String name;
	private String surname;
	private int intValue;
	private double doubleValue;

	public SomePojo(String name, String surname, int intValue, double doubleValue) {
		super();
		this.name = name;
		this.surname = surname;
		this.intValue = intValue;
		this.doubleValue = doubleValue;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getIntValue() {
		return intValue;
	}

	public double getDoubleValue() {
		return doubleValue;
	}

	@Override
	public String toString() {
		return "SomePojo [name=" + name + ", surname=" + surname + ", intValue=" + intValue + ", doubleValue=" + doubleValue + "]";
	}

}
