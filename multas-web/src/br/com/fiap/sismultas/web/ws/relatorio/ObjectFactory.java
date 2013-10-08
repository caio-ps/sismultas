
package br.com.fiap.sismultas.web.ws.relatorio;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.relatorio package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmiteRelatorio_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "emiteRelatorio");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");
    private final static QName _EmiteRelatorioResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "emiteRelatorioResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.relatorio
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InfracaoVO }
     * 
     */
    public InfracaoVO createInfracaoVO() {
        return new InfracaoVO();
    }

    /**
     * Create an instance of {@link MultaVO }
     * 
     */
    public MultaVO createMultaVO() {
        return new MultaVO();
    }

    /**
     * Create an instance of {@link EmiteRelatorioResponse }
     * 
     */
    public EmiteRelatorioResponse createEmiteRelatorioResponse() {
        return new EmiteRelatorioResponse();
    }

    /**
     * Create an instance of {@link NotificacaoVO }
     * 
     */
    public NotificacaoVO createNotificacaoVO() {
        return new NotificacaoVO();
    }

    /**
     * Create an instance of {@link RelatorioVO }
     * 
     */
    public RelatorioVO createRelatorioVO() {
        return new RelatorioVO();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link ModeloVO }
     * 
     */
    public ModeloVO createModeloVO() {
        return new ModeloVO();
    }

    /**
     * Create an instance of {@link VeiculoVO }
     * 
     */
    public VeiculoVO createVeiculoVO() {
        return new VeiculoVO();
    }

    /**
     * Create an instance of {@link EmiteRelatorio_Type }
     * 
     */
    public EmiteRelatorio_Type createEmiteRelatorio_Type() {
        return new EmiteRelatorio_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmiteRelatorio_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "emiteRelatorio")
    public JAXBElement<EmiteRelatorio_Type> createEmiteRelatorio(EmiteRelatorio_Type value) {
        return new JAXBElement<EmiteRelatorio_Type>(_EmiteRelatorio_QNAME, EmiteRelatorio_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmiteRelatorioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "emiteRelatorioResponse")
    public JAXBElement<EmiteRelatorioResponse> createEmiteRelatorioResponse(EmiteRelatorioResponse value) {
        return new JAXBElement<EmiteRelatorioResponse>(_EmiteRelatorioResponse_QNAME, EmiteRelatorioResponse.class, null, value);
    }

}
