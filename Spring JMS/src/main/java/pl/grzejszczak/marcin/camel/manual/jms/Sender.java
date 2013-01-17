package pl.grzejszczak.marcin.camel.manual.jms;

public interface Sender<T> {
	void sendMessage(T object) throws Exception;
}
