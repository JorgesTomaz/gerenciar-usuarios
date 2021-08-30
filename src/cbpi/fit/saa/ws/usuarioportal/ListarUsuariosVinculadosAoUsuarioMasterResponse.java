
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listarUsuariosVinculadosAoUsuarioMasterResponse complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listarUsuariosVinculadosAoUsuarioMasterResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://usuarioportal.ws.saa.fit.cbpi/}responseListarUsuariosVinculadosAoUsuarioMaster" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarUsuariosVinculadosAoUsuarioMasterResponse", propOrder = {
    "_return"
})
public class ListarUsuariosVinculadosAoUsuarioMasterResponse {

    @XmlElement(name = "return")
    protected ResponseListarUsuariosVinculadosAoUsuarioMaster _return;

    /**
     * Obtém o valor da propriedade return.
     * 
     * @return
     *     possible object is
     *     {@link ResponseListarUsuariosVinculadosAoUsuarioMaster }
     *     
     */
    public ResponseListarUsuariosVinculadosAoUsuarioMaster getReturn() {
        return _return;
    }

    /**
     * Define o valor da propriedade return.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseListarUsuariosVinculadosAoUsuarioMaster }
     *     
     */
    public void setReturn(ResponseListarUsuariosVinculadosAoUsuarioMaster value) {
        this._return = value;
    }

}
