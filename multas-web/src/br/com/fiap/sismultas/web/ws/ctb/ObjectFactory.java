
package br.com.fiap.sismultas.web.ws.ctb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.ctb package. 
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

    private final static QName _CadastraItemCtb_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastraItemCtb");
    private final static QName _CadastraItemCtbResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "cadastraItemCtbResponse");
    private final static QName _GetGravidades_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getGravidades");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");
    private final static QName _GetGravidadesResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "getGravidadesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.ctb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CadastraItemCtbResponse }
     * 
     */
    public CadastraItemCtbResponse createCadastraItemCtbResponse() {
        return new CadastraItemCtbResponse();
    }

    /**
     * Create an instance of {@link GetGravidades }
     * 
     */
    public GetGravidades createGetGravidades() {
        return new GetGravidades();
    }

    /**
     * Create an instance of {@link ItemCTBVO }
     * 
     */
    public ItemCTBVO createItemCTBVO() {
        return new ItemCTBVO();
    }

    /**
     * Create an instance of {@link GravidadeInfracaoVO }
     * 
     */
    public GravidadeInfracaoVO createGravidadeInfracaoVO() {
        return new GravidadeInfracaoVO();
    }

    /**
     * Create an instance of {@link CadastraItemCtb }
     * 
     */
    public CadastraItemCtb createCadastraItemCtb() {
        return new CadastraItemCtb();
    }

    /**
     * Create an instance of {@link GetGravidadesResponse }
     * 
     */
    public GetGravidadesResponse createGetGravidadesResponse() {
        return new GetGravidadesResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastraItemCtb }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "cadastraItemCtb")
    public JAXBElement<CadastraItemCtb> createCadastraItemCtb(CadastraItemCtb value) {
        return new JAXBElement<CadastraItemCtb>(_CadastraItemCtb_QNAME, CadastraItemCtb.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CadastraItemCtbResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "cadastraItemCtbResponse")
    public JAXBElement<CadastraItemCtbResponse> createCadastraItemCtbResponse(CadastraItemCtbResponse value) {
        return new JAXBElement<CadastraItemCtbResponse>(_CadastraItemCtbResponse_QNAME, CadastraItemCtbResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGravidades }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getGravidades")
    public JAXBElement<GetGravidades> createGetGravidades(GetGravidades value) {
        return new JAXBElement<GetGravidades>(_GetGravidades_QNAME, GetGravidades.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGravidadesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "getGravidadesResponse")
    public JAXBElement<GetGravidadesResponse> createGetGravidadesResponse(GetGravidadesResponse value) {
        return new JAXBElement<GetGravidadesResponse>(_GetGravidadesResponse_QNAME, GetGravidadesResponse.class, null, value);
    }

}
