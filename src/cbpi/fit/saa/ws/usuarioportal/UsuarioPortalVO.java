
package cbpi.fit.saa.ws.usuarioportal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de usuarioPortalVO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="usuarioPortalVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://usuarioportal.ws.saa.fit.cbpi/}usuarioVO">
 *       &lt;sequence>
 *         &lt;element name="cdPerfis" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cpf" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataAtivacao" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dddTelefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtAlter" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dtIncl" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="nome" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pontosDeVenda" type="{http://usuarioportal.ws.saa.fit.cbpi/}dadosClienteRIVO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="senhaWebmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="telefone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioPortalVO", propOrder = {
    "cdPerfis",
    "cpf",
    "dataAtivacao",
    "dddTelefone",
    "dtAlter",
    "dtIncl",
    "nome",
    "pontosDeVenda",
    "senhaWebmail",
    "telefone"
})
public class UsuarioPortalVO
    extends UsuarioVO
{

    @XmlElement(nillable = true)
	private List<String> cdPerfis;
    protected String cpf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataAtivacao;
    protected String dddTelefone;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtAlter;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtIncl;
    protected String nome;
    @XmlElement(nillable = true)
	private List<DadosClienteRIVO> pontosDeVenda;
    protected String senhaWebmail;
    protected String telefone;

    /**
     * Gets the value of the cdPerfis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdPerfis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdPerfis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCdPerfis() {
        if (cdPerfis == null) {
            cdPerfis = new ArrayList<String>();
        }
        return this.cdPerfis;
    }

    public void setCdPerfis(List<String> cdPerfis) {
		this.cdPerfis = cdPerfis;
	}

	/**
     * Obtém o valor da propriedade cpf.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o valor da propriedade cpf.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCpf(String value) {
        this.cpf = value;
    }

    /**
     * Obtém o valor da propriedade dataAtivacao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataAtivacao() {
        return dataAtivacao;
    }

    /**
     * Define o valor da propriedade dataAtivacao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataAtivacao(XMLGregorianCalendar value) {
        this.dataAtivacao = value;
    }

    /**
     * Obtém o valor da propriedade dddTelefone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDddTelefone() {
        return dddTelefone;
    }

    /**
     * Define o valor da propriedade dddTelefone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDddTelefone(String value) {
        this.dddTelefone = value;
    }

    /**
     * Obtém o valor da propriedade dtAlter.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtAlter() {
        return dtAlter;
    }

    /**
     * Define o valor da propriedade dtAlter.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtAlter(XMLGregorianCalendar value) {
        this.dtAlter = value;
    }

    /**
     * Obtém o valor da propriedade dtIncl.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtIncl() {
        return dtIncl;
    }

    /**
     * Define o valor da propriedade dtIncl.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtIncl(XMLGregorianCalendar value) {
        this.dtIncl = value;
    }

    /**
     * Obtém o valor da propriedade nome.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor da propriedade nome.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNome(String value) {
        this.nome = value;
    }

    /**
     * Gets the value of the pontosDeVenda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pontosDeVenda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPontosDeVenda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DadosClienteRIVO }
     * 
     * 
     */
    public List<DadosClienteRIVO> getPontosDeVenda() {
        if (pontosDeVenda == null) {
            pontosDeVenda = new ArrayList<DadosClienteRIVO>();
        }
        return this.pontosDeVenda;
    }

    public void setPontosDeVenda(List<DadosClienteRIVO> pontosDeVenda) {
		this.pontosDeVenda = pontosDeVenda;
	}

	/**
     * Obtém o valor da propriedade senhaWebmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenhaWebmail() {
        return senhaWebmail;
    }

    /**
     * Define o valor da propriedade senhaWebmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenhaWebmail(String value) {
        this.senhaWebmail = value;
    }

    /**
     * Obtém o valor da propriedade telefone.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o valor da propriedade telefone.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefone(String value) {
        this.telefone = value;
    }

}
