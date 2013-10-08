
package br.com.fiap.sismultas.web.ws.veiculo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.veiculo package. 
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

    private final static QName _GetModelos_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getModelos");
    private final static QName _GetModelosResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getModelosResponse");
    private final static QName _CadastraResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastraResponse");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");
    private final static QName _Cadastra_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastra");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.veiculo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VeiculoVO }
     * 
     */
    public VeiculoVO createVeiculoVO() {
        return new VeiculoVO();
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
     * Create an instance of {@link GetModelosResponse }
     * 
     */
    public GetModelosResponse createGetModelosResponse() {
        return new GetModelosResponse();
    }

    /**
     * Create an instance of {@link GetModelos }
     * 
     */
    public GetModelos createGetModelos() {
        return new GetModelos();
    }

    /**
     * Create an instance of {@link Cadastra }
     * 
     */
    public Cadastra createCadastra() {
        return new Cadastra();
    }

    /**
     * Create an instance of {@link CadastraResponse }
     * 
     */
    public CadastraResponse createCadastraResponse() {
        return new CadastraResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModelos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getModelos")
    public JAXBElement<GetModelos> createGetModelos(GetModelos value) {
        return new JAXBElement<GetModelos>(_GetModelos_QNAME, GetModelos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModelosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getModelosResponse")
    public JAXBElement<GetModelosResponse> createGetModelosResponse(GetModelosResponse value) {
        return new JAXBElement<GetModelosResponse>(_GetModelosResponse_QNAME, GetModelosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "cadastraResponse")
    public JAXBElement<CadastraResponse> createCadastraResponse(CadastraResponse value) {
        return new JAXBElement<CadastraResponse>(_CadastraResponse_QNAME, CadastraResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Cadastra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "cadastra")
    public JAXBElement<Cadastra> createCadastra(Cadastra value) {
        return new JAXBElement<Cadastra>(_Cadastra_QNAME, Cadastra.class, null, value);
    }

}
