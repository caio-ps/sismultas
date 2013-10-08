
package br.com.fiap.sismultas.web.ws.consulta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.consulta package. 
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

    private final static QName _GetMultas_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getMultas");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");
    private final static QName _GetMultasResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getMultasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.consulta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultaVO }
     * 
     */
    public MultaVO createMultaVO() {
        return new MultaVO();
    }

    /**
     * Create an instance of {@link VeiculoVO }
     * 
     */
    public VeiculoVO createVeiculoVO() {
        return new VeiculoVO();
    }

    /**
     * Create an instance of {@link GetMultasResponse }
     * 
     */
    public GetMultasResponse createGetMultasResponse() {
        return new GetMultasResponse();
    }

    /**
     * Create an instance of {@link GetMultas }
     * 
     */
    public GetMultas createGetMultas() {
        return new GetMultas();
    }

    /**
     * Create an instance of {@link InfracaoVO }
     * 
     */
    public InfracaoVO createInfracaoVO() {
        return new InfracaoVO();
    }

    /**
     * Create an instance of {@link ModeloVO }
     * 
     */
    public ModeloVO createModeloVO() {
        return new ModeloVO();
    }

    /**
     * Create an instance of {@link NotificacaoVO }
     * 
     */
    public NotificacaoVO createNotificacaoVO() {
        return new NotificacaoVO();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getMultas")
    public JAXBElement<GetMultas> createGetMultas(GetMultas value) {
        return new JAXBElement<GetMultas>(_GetMultas_QNAME, GetMultas.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMultasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getMultasResponse")
    public JAXBElement<GetMultasResponse> createGetMultasResponse(GetMultasResponse value) {
        return new JAXBElement<GetMultasResponse>(_GetMultasResponse_QNAME, GetMultasResponse.class, null, value);
    }

}
