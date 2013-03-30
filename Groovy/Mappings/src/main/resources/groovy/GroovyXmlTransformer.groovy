package groovy

/**
 * Created with IntelliJ IDEA.
 * User: mgrzejszczak
 * Date: 22.03.13
 * Time: 23:59
 *
 * additional functions:
 *
 * convertDate.from(Node).havingDateFormat("DateFormat").toOutputDateFormat("AnotherDateFormat")
 * map.given("Value to be mapped from" : "Value to be mapped to", "default" : "default value").from(Node)
 *
 */
class GroovyXmlTransformer extends AbstractGroovyXmlTransformer {

    @Override
    void doTransform(inputXml, outputXml) {
        outputXml.OutputSystemEnvelope() {
            OutputSystemContext {
                ResponseID(inputXml.InputSystemContext.RequestID.text().reverse())
                OutputSource('OUTPUT_SYSTEM')
                OutputDate(convertDate.from(inputXml.InputSystemContext.InputDate).havingDateFormat("dd/MM/yyyy").toOutputDateFormat("yy/MM/dd"))
            }
            OutputAdditionalData {
                OutputReferenceNo("SOME_PREFIX_${inputXml.AdditionalData.ReferenceNo.text()}_SOME_SUFIX")
                OutputTypeOfAction(map.given("Some_action" : "Some_output_action", "default" : "something else").from(inputXml.AdditionalData.TypeOfAction))
                OutputTransactions {
                    inputXml.AdditionalData.Transactions.Transaction.each {
                        OutputTransaction(Client: it.Client, ProductType: it.ProductType, 'Done')
                    }
                }
                OutputProducts {
                    def minProduct = inputXml.AdditionalData.Products.Product.list().min { it.Value.text() }
                    def maxProduct = inputXml.AdditionalData.Products.Product.list().max { it.Value.text() }
                    MinProduct(name: minProduct.Name.text(), minProduct.Value.text())
                    MaxProduct(name: maxProduct.Name.text(), maxProduct.Value.text())
                }
            }
        }
    }
}