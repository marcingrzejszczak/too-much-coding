package com.blogspot.toomuchcoding;

import com.blogspot.toomuchcoding.factory.ScriptFactoryImpl;
import com.blogspot.toomuchcoding.factory.TransformerFactory;
import com.blogspot.toomuchcoding.factory.TransformerFactoryImpl;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 22.03.13
 * Time: 23:50
 */

public class XmlTransformer {

    public static void main(String... args) throws IOException{
        URL sampleXmlUrl = Resources.getResource("xml/SampleXml.xml");
        String inputXml = Resources.toString(sampleXmlUrl, Charsets.UTF_8);
        System.out.println("Converted from [" + inputXml + "]\n");
        TransformerFactory<String, String> transformerFactory = new TransformerFactoryImpl(new ScriptFactoryImpl());
        System.out.println(" to\n\n[" + transformerFactory.createTransformer().transform(inputXml) + "]");
    }
}
