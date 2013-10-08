
package br.com.fiap.sismultas.mule.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for processaDadosMulta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="processaDadosMulta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dadosMulta" type="{http://ws.sismultas.fiap.com.br/}multaVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "processaDadosMulta", propOrder = {
    "dadosMulta"
})
public class ProcessaDadosMulta {

    protected MultaVO dadosMulta;

    /**
     * Gets the value of the dadosMulta property.
     * 
     * @return
     *     possible object is
     *     {@link MultaVO }
     *     
     */
    public MultaVO getDadosMulta() {
        return dadosMulta;
    }

    /**
     * Sets the value of the dadosMulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultaVO }
     *     
     */
    public void setDadosMulta(MultaVO value) {
        this.dadosMulta = value;
    }

}
