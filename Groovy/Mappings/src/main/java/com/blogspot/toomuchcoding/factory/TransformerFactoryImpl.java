package com.blogspot.toomuchcoding.factory;

import com.blogspot.toomuchcoding.transformer.Transformer;
import com.google.common.io.Resources;
import groovy.util.GroovyScriptEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 22.03.13
 * Time: 23:54
 */
public class TransformerFactoryImpl implements TransformerFactory<String, String> {
    private static final String GROOVY_SCRIPTS_CLASSPATH = "groovy/";
    private static Logger LOGGER = LoggerFactory.getLogger(TransformerFactoryImpl.class);

    private ScriptFactory scriptFactory;
    private GroovyScriptEngine groovyScriptEngine;

    public TransformerFactoryImpl(ScriptFactory scriptFactory) {
        this.scriptFactory = scriptFactory;
        try {
            groovyScriptEngine = new GroovyScriptEngine(GROOVY_SCRIPTS_CLASSPATH);
        } catch (IOException e) {
            LOGGER.error("Exception occurred while trying to create the Groovy script engine", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transformer<String, String> createTransformer() {
        Transformer<String, String> transformerFromScript = null;
        try {
            File scriptFile = scriptFactory.createScript();
            URL scriptAsAClasspathResource = Resources.getResource(GROOVY_SCRIPTS_CLASSPATH + scriptFile.getName());
            Class classFromScript = groovyScriptEngine.loadScriptByName(scriptAsAClasspathResource.getFile());
            transformerFromScript = (Transformer<String, String>) classFromScript.newInstance();
        } catch (Exception e) {
            LOGGER.error("Exception occurred while trying to execute Groovy script", e);
        }
        return transformerFromScript;
    }

}
