
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de responsePrimeiroAcessoDoUsuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="responsePrimeiroAcessoDoUsuario">
 *   &lt;complexContent>
 *     &lt;extension base="{http://usuarioportal.ws.saa.fit.cbpi/}responseServices">
 *       &lt;sequence>
 *         &lt;element name="primeiro" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responsePrimeiroAcessoDoUsuario", propOrder = {
    "primeiro"
})
public class ResponsePrimeiroAcessoDoUsuario
    extends ResponseServices
{

    protected boolean primeiro;

    /**
     * Obtém o valor da propriedade primeiro.
     * 
     */
    public boolean isPrimeiro() {
        return primeiro;
    }

    /**
     * Define o valor da propriedade primeiro.
     * 
     */
    public void setPrimeiro(boolean value) {
        this.primeiro = value;
    }

}
