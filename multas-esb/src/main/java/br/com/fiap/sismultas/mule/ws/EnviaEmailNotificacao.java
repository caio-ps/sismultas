
package br.com.fiap.sismultas.mule.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for enviaEmailNotificacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="enviaEmailNotificacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="relatorio" type="{http://ws.sismultas.fiap.com.br/}relatorioVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "enviaEmailNotificacao", propOrder = {
    "relatorio"
})
public class EnviaEmailNotificacao {

    protected RelatorioVO relatorio;

    /**
     * Gets the value of the relatorio property.
     * 
     * @return
     *     possible object is
     *     {@link RelatorioVO }
     *     
     */
    public RelatorioVO getRelatorio() {
        return relatorio;
    }

    /**
     * Sets the value of the relatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatorioVO }
     *     
     */
    public void setRelatorio(RelatorioVO value) {
        this.relatorio = value;
    }

}
