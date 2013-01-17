package pl.grzejszczak.marcin.camel.jaxb;

public interface Convertable<T> {
	String marshal(T object);

	T unmarshal(String objectAsString);
}
