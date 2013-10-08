
package br.com.fiap.sismultas.web.ws.relatorio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for emiteRelatorio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="emiteRelatorio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filtro" type="{http://ws.sismultas.fiap.com.br/}multaVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "emiteRelatorio", propOrder = {
    "filtro"
})
public class EmiteRelatorio_Type {

    protected MultaVO filtro;

    /**
     * Gets the value of the filtro property.
     * 
     * @return
     *     possible object is
     *     {@link MultaVO }
     *     
     */
    public MultaVO getFiltro() {
        return filtro;
    }

    /**
     * Sets the value of the filtro property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultaVO }
     *     
     */
    public void setFiltro(MultaVO value) {
        this.filtro = value;
    }

}
