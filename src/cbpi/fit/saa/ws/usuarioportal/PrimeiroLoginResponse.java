
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de primeiroLoginResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="primeiroLoginResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://usuarioportal.ws.saa.fit.cbpi/}responsePrimeiroAcessoDoUsuario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "primeiroLoginResponse", propOrder = {
    "_return"
})
public class PrimeiroLoginResponse {

    @XmlElement(name = "return")
    protected ResponsePrimeiroAcessoDoUsuario _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link ResponsePrimeiroAcessoDoUsuario }
     *     
     */
    public ResponsePrimeiroAcessoDoUsuario getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponsePrimeiroAcessoDoUsuario }
     *     
     */
    public void setReturn(ResponsePrimeiroAcessoDoUsuario value) {
        this._return = value;
    }

}
