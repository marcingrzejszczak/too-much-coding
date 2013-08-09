package com.blogspot.postprocessor;


import com.blogspot.toomuchcoding.processor.AbstractBeanPostProcessor;
import com.blogspot.toomuchcoding.service.PlayerWebService;
import org.springframework.stereotype.Component;

import static org.mockito.Mockito.spy;

/**
 * User: mgrzejszczak
 * Date: 07.05.13
 * Time: 11:30
 */
@Component
public class PlayerWebServicePostProcessor extends AbstractBeanPostProcessor<PlayerWebService> {
    public PlayerWebServicePostProcessor() {
        super(PlayerWebService.class);
    }

    @Override
    public PlayerWebService doBefore(PlayerWebService bean) {
        return spy(bean);
    }

    @Override
    public PlayerWebService doAfter(PlayerWebService bean) {
        return bean;
    }
}
