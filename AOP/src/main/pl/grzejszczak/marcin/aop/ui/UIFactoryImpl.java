package pl.grzejszczak.marcin.aop.ui;

import org.apache.commons.lang.NullArgumentException;
import org.springframework.stereotype.Component;

@Component
public class UIFactoryImpl implements UIFactory {

	@Override
	public UIComponent createComponent(Class<? extends UIComponent> componentClass) throws Exception {
		if (componentClass == null) {
			throw new NullArgumentException("Provide class for the component");
		}
		return (UIComponent) Class.forName(componentClass.getName()).newInstance();
	}

}
