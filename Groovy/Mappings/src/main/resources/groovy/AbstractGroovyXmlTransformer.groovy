package groovy

import com.blogspot.toomuchcoding.transformer.Transformer
import groovy.util.slurpersupport.NodeChildren
import groovy.xml.MarkupBuilder

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 23.03.13
 * Time: 02:16
 */
abstract class AbstractGroovyXmlTransformer implements Transformer<String, String> {

    static Map<String, Object> MISSING_PROPERTIES = ["convertDate": new DateConverter(), "map": new Mapper()]

    @Override
    String transform(String input) {
        def inputXml = new XmlSlurper().parseText input
        def writer = new StringWriter()
        def outputXml = new MarkupBuilder(writer)
        doTransform inputXml, outputXml
        writer.toString()
    }

    abstract void doTransform(inputXml, outputXml)

    def propertyMissing(String name) {
        Object property = MISSING_PROPERTIES[name]
        assert property != null, "There is no function like [$name]. The ones that are supported are ${MISSING_PROPERTIES.keySet()}"
        property
    }


    protected static class Mapper {
        private Map<String, String> inputParameters

        Mapper given(Map inputParameters) {
            this.inputParameters = inputParameters
            this
        }

        String from(NodeChildren nodeChildren) {
            assert inputParameters != null, "The mapping can't be null!"
            assert nodeChildren != null, "Node can't be null!"
            String nodeText = nodeChildren.text()
            String mappedValue = inputParameters[nodeText]
            mappedValue ?: inputParameters.default
        }

        static Mapper map(Map<String, String> inputParameters) {
            return new Mapper(inputParameters)
        }
    }

    protected static class DateConverter {
        private String inputDate
        private String inputDateFormat

        DateConverter from(NodeChildren nodeChildren) {
            this.inputDate = nodeChildren.text()
            this
        }

        DateConverter havingDateFormat(String inputDateFormat) {
            this.inputDateFormat = inputDateFormat
            this
        }

        String toOutputDateFormat(String outputDateFormat) {
            assert inputDate != null, "The input date for which you are trying to do the conversion can't be null"
            assert inputDateFormat != null, "The input date format for which you are trying to do the conversion can't be null"
            assert outputDateFormat != null, "The output date format for which you are trying to do the conversion can't be null"
            Date.parse(inputDateFormat, inputDate).format(outputDateFormat)
        }

        static DateConverter convertDate() {
            new DateConverter()
        }
    }
}
