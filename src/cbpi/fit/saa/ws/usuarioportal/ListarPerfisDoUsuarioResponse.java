
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listarPerfisDoUsuarioResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listarPerfisDoUsuarioResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://usuarioportal.ws.saa.fit.cbpi/}responseListarPerfisDoUsuario" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarPerfisDoUsuarioResponse", propOrder = {
    "_return"
})
public class ListarPerfisDoUsuarioResponse {

    @XmlElement(name = "return")
    protected ResponseListarPerfisDoUsuario _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link ResponseListarPerfisDoUsuario }
     *     
     */
    public ResponseListarPerfisDoUsuario getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseListarPerfisDoUsuario }
     *     
     */
    public void setReturn(ResponseListarPerfisDoUsuario value) {
        this._return = value;
    }

}
