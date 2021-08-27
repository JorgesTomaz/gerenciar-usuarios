
package cbpi.fit.saa.ws.usuarioportal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dadosClienteRIVO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dadosClienteRIVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://usuarioportal.ws.saa.fit.cbpi/}dadosClienteVO">
 *       &lt;sequence>
 *         &lt;element name="cdPtoeCli" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnpjPrincipal" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="mapaPropriedades">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dadosClienteRIVO", propOrder = {
    "cdPtoeCli",
    "cnpjPrincipal",
    "mapaPropriedades"
})
public class DadosClienteRIVO
    extends DadosClienteVO implements Serializable
{

	private static final long serialVersionUID = 5544340183817149808L;
	
	protected String cdPtoeCli;
    protected boolean cnpjPrincipal;
    @XmlElement(required = true)
    protected DadosClienteRIVO.MapaPropriedades mapaPropriedades;

    /**
     * Obtém o valor da propriedade cdPtoeCli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdPtoeCli() {
        return cdPtoeCli;
    }

    /**
     * Define o valor da propriedade cdPtoeCli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdPtoeCli(String value) {
        this.cdPtoeCli = value;
    }

    /**
     * Obtém o valor da propriedade cnpjPrincipal.
     * 
     */
    public boolean isCnpjPrincipal() {
        return cnpjPrincipal;
    }

    /**
     * Define o valor da propriedade cnpjPrincipal.
     * 
     */
    public void setCnpjPrincipal(boolean value) {
        this.cnpjPrincipal = value;
    }

    /**
     * Obtém o valor da propriedade mapaPropriedades.
     * 
     * @return
     *     possible object is
     *     {@link DadosClienteRIVO.MapaPropriedades }
     *     
     */
    public DadosClienteRIVO.MapaPropriedades getMapaPropriedades() {
        return mapaPropriedades;
    }

    /**
     * Define o valor da propriedade mapaPropriedades.
     * 
     * @param value
     *     allowed object is
     *     {@link DadosClienteRIVO.MapaPropriedades }
     *     
     */
    public void setMapaPropriedades(DadosClienteRIVO.MapaPropriedades value) {
        this.mapaPropriedades = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     * 
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class MapaPropriedades {

        protected List<DadosClienteRIVO.MapaPropriedades.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DadosClienteRIVO.MapaPropriedades.Entry }
         * 
         * 
         */
        public List<DadosClienteRIVO.MapaPropriedades.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<DadosClienteRIVO.MapaPropriedades.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Classe Java de anonymous complex type.
         * 
         * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected Object key;
            protected Object value;

            /**
             * Obtém o valor da propriedade key.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getKey() {
                return key;
            }

            /**
             * Define o valor da propriedade key.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setKey(Object value) {
                this.key = value;
            }

            /**
             * Obtém o valor da propriedade value.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getValue() {
                return value;
            }

            /**
             * Define o valor da propriedade value.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setValue(Object value) {
                this.value = value;
            }

        }

    }

}
