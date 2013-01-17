package pl.grzejszczak.marcin.drools.springintegration.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 14.01.13
 */
public final class SomeUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SomeUtil.class);

    private SomeUtil(){
        throw new UnsupportedOperationException("SomeUtil is a utility class that should not be instantiated");
    }

    public static String replaceAWithB(String input){
        LOGGER.debug("Executing some logic");
        return input.toLowerCase().replaceAll("a", "b");
    }

}
