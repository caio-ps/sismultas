
package br.com.fiap.sismultas.mule.auth.ws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://ws.sismultas.fiap.com.br/")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private br.com.fiap.sismultas.mule.auth.ws.Exception faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public Exception_Exception(String message, br.com.fiap.sismultas.mule.auth.ws.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public Exception_Exception(String message, br.com.fiap.sismultas.mule.auth.ws.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: br.com.fiap.sismultas.mule.auth.ws.Exception
     */
    public br.com.fiap.sismultas.mule.auth.ws.Exception getFaultInfo() {
        return faultInfo;
    }

}
