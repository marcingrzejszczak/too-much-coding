package com.blogspot.toomuchcoding.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 26.03.13
 * Time: 13:14
 */
public abstract class AbstractBeanPostProcessor<T> implements BeanPostProcessor, ApplicationContextAware {

    private Class<T> clazz;
    protected ApplicationContext applicationContext;

    public AbstractBeanPostProcessor(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
        checkConditions();
        if (clazz.isAssignableFrom(bean.getClass())) {
            return doAfter((T) bean);
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
        checkConditions();

        if (clazz.isAssignableFrom(bean.getClass())) {
            return doBefore((T) bean);
        }
        return bean;
    }

    private void checkConditions() {
        if (clazz == null) {
            throw new RuntimeException("Provide the interface for the post processor");
        }
    }

    public abstract T doBefore(T bean);

    public abstract T doAfter(T bean);

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
