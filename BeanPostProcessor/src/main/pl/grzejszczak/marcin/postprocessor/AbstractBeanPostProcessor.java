package pl.grzejszczak.marcin.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public abstract class AbstractBeanPostProcessor<T> implements BeanPostProcessor {

	private Class<T> clazz;

	public AbstractBeanPostProcessor(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		checkConditions();

		if (clazz.isAssignableFrom(bean.getClass())) {
			doAfter();
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		checkConditions();

		if (clazz.isAssignableFrom(bean.getClass())) {
			doBefore();
		}
		return bean;
	}

	private void checkConditions() {
		if (clazz == null) {
			throw new NullPointerException("Provide the interface for the post processor");
		}
	}

	public abstract void doBefore();

	public abstract void doAfter();

}
