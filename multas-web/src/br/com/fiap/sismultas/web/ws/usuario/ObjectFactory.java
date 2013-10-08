
package br.com.fiap.sismultas.web.ws.usuario;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.usuario package. 
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

    private final static QName _CadastraResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastraResponse");
    private final static QName _GetPerfis_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getPerfis");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");
    private final static QName _GetPerfisResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getPerfisResponse");
    private final static QName _Cadastra_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastra");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.usuario
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PerfilVO }
     * 
     */
    public PerfilVO createPerfilVO() {
        return new PerfilVO();
    }

    /**
     * Create an instance of {@link Cadastra }
     * 
     */
    public Cadastra createCadastra() {
        return new Cadastra();
    }

    /**
     * Create an instance of {@link GetPerfis }
     * 
     */
    public GetPerfis createGetPerfis() {
        return new GetPerfis();
    }

    /**
     * Create an instance of {@link CadastraResponse }
     * 
     */
    public CadastraResponse createCadastraResponse() {
        return new CadastraResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link GetPerfisResponse }
     * 
     */
    public GetPerfisResponse createGetPerfisResponse() {
        return new GetPerfisResponse();
    }

    /**
     * Create an instance of {@link PessoaVO }
     * 
     */
    public PessoaVO createPessoaVO() {
        return new PessoaVO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerfis }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getPerfis")
    public JAXBElement<GetPerfis> createGetPerfis(GetPerfis value) {
        return new JAXBElement<GetPerfis>(_GetPerfis_QNAME, GetPerfis.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPerfisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getPerfisResponse")
    public JAXBElement<GetPerfisResponse> createGetPerfisResponse(GetPerfisResponse value) {
        return new JAXBElement<GetPerfisResponse>(_GetPerfisResponse_QNAME, GetPerfisResponse.class, null, value);
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
