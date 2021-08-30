
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de usuarioVO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="usuarioVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdUsuarioAutenticado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dtFimBloqAcesso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dtInat" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dtIniBloqAcesso" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="emailAlternativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prefixoEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="senha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "usuarioVO", propOrder = {
    "cdUsuarioAutenticado",
    "codigo",
    "dtFimBloqAcesso",
    "dtInat",
    "dtIniBloqAcesso",
    "email",
    "emailAlternativo",
    "prefixoEmail",
    "senha"
})
@XmlSeeAlso({
    UsuarioPortalVO.class
})
public class UsuarioVO {

    protected String cdUsuarioAutenticado;
    protected String codigo;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtFimBloqAcesso;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtInat;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dtIniBloqAcesso;
    protected String email;
    protected String emailAlternativo;
    protected String prefixoEmail;
    protected String senha;

    /**
     * Obtém o valor da propriedade cdUsuarioAutenticado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdUsuarioAutenticado() {
        return cdUsuarioAutenticado;
    }

    /**
     * Define o valor da propriedade cdUsuarioAutenticado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdUsuarioAutenticado(String value) {
        this.cdUsuarioAutenticado = value;
    }

    /**
     * Obtém o valor da propriedade codigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o valor da propriedade codigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigo(String value) {
        this.codigo = value;
    }

    /**
     * Obtém o valor da propriedade dtFimBloqAcesso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtFimBloqAcesso() {
        return dtFimBloqAcesso;
    }

    /**
     * Define o valor da propriedade dtFimBloqAcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtFimBloqAcesso(XMLGregorianCalendar value) {
        this.dtFimBloqAcesso = value;
    }

    /**
     * Obtém o valor da propriedade dtInat.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtInat() {
        return dtInat;
    }

    /**
     * Define o valor da propriedade dtInat.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtInat(XMLGregorianCalendar value) {
        this.dtInat = value;
    }

    /**
     * Obtém o valor da propriedade dtIniBloqAcesso.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDtIniBloqAcesso() {
        return dtIniBloqAcesso;
    }

    /**
     * Define o valor da propriedade dtIniBloqAcesso.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDtIniBloqAcesso(XMLGregorianCalendar value) {
        this.dtIniBloqAcesso = value;
    }

    /**
     * Obtém o valor da propriedade email.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Obtém o valor da propriedade emailAlternativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    /**
     * Define o valor da propriedade emailAlternativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmailAlternativo(String value) {
        this.emailAlternativo = value;
    }

    /**
     * Obtém o valor da propriedade prefixoEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefixoEmail() {
        return prefixoEmail;
    }

    /**
     * Define o valor da propriedade prefixoEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefixoEmail(String value) {
        this.prefixoEmail = value;
    }

    /**
     * Obtém o valor da propriedade senha.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define o valor da propriedade senha.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenha(String value) {
        this.senha = value;
    }

}
