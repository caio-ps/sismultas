
package br.com.fiap.sismultas.mule.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for relatorioVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="relatorioVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="caminhoArquivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="tipoRelatorio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "relatorioVO", propOrder = {
    "caminhoArquivo",
    "id",
    "tipoRelatorio"
})
public class RelatorioVO {

    protected String caminhoArquivo;
    protected Long id;
    protected String tipoRelatorio;

    /**
     * Gets the value of the caminhoArquivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    /**
     * Sets the value of the caminhoArquivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaminhoArquivo(String value) {
        this.caminhoArquivo = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the tipoRelatorio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoRelatorio() {
        return tipoRelatorio;
    }

    /**
     * Sets the value of the tipoRelatorio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoRelatorio(String value) {
        this.tipoRelatorio = value;
    }

}
