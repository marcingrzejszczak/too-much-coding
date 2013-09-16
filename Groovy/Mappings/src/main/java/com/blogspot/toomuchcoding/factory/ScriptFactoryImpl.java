package com.blogspot.toomuchcoding.factory;

import com.google.common.io.Resources;

import java.io.File;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 30.03.13
 * Time: 16:57
 */
public class ScriptFactoryImpl implements ScriptFactory {
    private static final String TRANSFORMER_SCRIPT_PATH = "groovy/GroovyXmlTransformer.groovy";

    @Override
    public File createScript() {
        URL transformerScriptUrl = Resources.getResource(TRANSFORMER_SCRIPT_PATH);
        return new File(transformerScriptUrl.getFile());
    }
}
