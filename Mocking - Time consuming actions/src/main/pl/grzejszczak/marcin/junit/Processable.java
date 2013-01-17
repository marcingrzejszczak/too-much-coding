package pl.grzejszczak.marcin.junit;

import pl.grzejszczak.marcin.junit.invocation.SomePojo;

public interface Processable {
	void process();

	void processSomeObject(SomePojo argument);
}
