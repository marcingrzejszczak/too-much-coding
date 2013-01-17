package pl.grzejszczak.marcin.aop.ui;

public interface UIFactory {
	UIComponent createComponent(Class<? extends UIComponent> componentClass) throws Exception;
}
