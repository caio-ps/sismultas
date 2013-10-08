
package br.com.fiap.sismultas.web.ws.ctb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for itemCTBVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="itemCTBVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="artigo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="codigoInfracao" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descricaoResumida" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desdobramento" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="gravidade" type="{http://ws.sismultas.fiap.com.br/}gravidadeInfracaoVO" minOccurs="0"/>
 *         &lt;element name="mensagem" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paragrafo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="sucesso" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="valorMulta" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemCTBVO", propOrder = {
    "artigo",
    "codigoInfracao",
    "descricaoResumida",
    "desdobramento",
    "gravidade",
    "mensagem",
    "paragrafo",
    "sucesso",
    "valorMulta"
})
public class ItemCTBVO {

    protected Integer artigo;
    protected String codigoInfracao;
    protected String descricaoResumida;
    protected Integer desdobramento;
    protected GravidadeInfracaoVO gravidade;
    protected String mensagem;
    protected Integer paragrafo;
    protected Boolean sucesso;
    protected Double valorMulta;

    /**
     * Gets the value of the artigo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getArtigo() {
        return artigo;
    }

    /**
     * Sets the value of the artigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setArtigo(Integer value) {
        this.artigo = value;
    }

    /**
     * Gets the value of the codigoInfracao property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoInfracao() {
        return codigoInfracao;
    }

    /**
     * Sets the value of the codigoInfracao property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoInfracao(String value) {
        this.codigoInfracao = value;
    }

    /**
     * Gets the value of the descricaoResumida property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricaoResumida() {
        return descricaoResumida;
    }

    /**
     * Sets the value of the descricaoResumida property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricaoResumida(String value) {
        this.descricaoResumida = value;
    }

    /**
     * Gets the value of the desdobramento property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDesdobramento() {
        return desdobramento;
    }

    /**
     * Sets the value of the desdobramento property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDesdobramento(Integer value) {
        this.desdobramento = value;
    }

    /**
     * Gets the value of the gravidade property.
     * 
     * @return
     *     possible object is
     *     {@link GravidadeInfracaoVO }
     *     
     */
    public GravidadeInfracaoVO getGravidade() {
        return gravidade;
    }

    /**
     * Sets the value of the gravidade property.
     * 
     * @param value
     *     allowed object is
     *     {@link GravidadeInfracaoVO }
     *     
     */
    public void setGravidade(GravidadeInfracaoVO value) {
        this.gravidade = value;
    }

    /**
     * Gets the value of the mensagem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * Sets the value of the mensagem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensagem(String value) {
        this.mensagem = value;
    }

    /**
     * Gets the value of the paragrafo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getParagrafo() {
        return paragrafo;
    }

    /**
     * Sets the value of the paragrafo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setParagrafo(Integer value) {
        this.paragrafo = value;
    }

    /**
     * Gets the value of the sucesso property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSucesso() {
        return sucesso;
    }

    /**
     * Sets the value of the sucesso property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSucesso(Boolean value) {
        this.sucesso = value;
    }

    /**
     * Gets the value of the valorMulta property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getValorMulta() {
        return valorMulta;
    }

    /**
     * Sets the value of the valorMulta property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setValorMulta(Double value) {
        this.valorMulta = value;
    }

}
