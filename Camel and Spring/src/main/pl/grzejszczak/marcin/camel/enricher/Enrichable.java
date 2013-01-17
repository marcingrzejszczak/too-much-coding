package pl.grzejszczak.marcin.camel.enricher;

public interface Enrichable<T> {
	void enrich(T inputObject);
}
