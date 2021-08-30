
package cbpi.fit.saa.ws.usuarioportal;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "UsuarioPortalWS", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface UsuarioPortalWS {


    /**
     * 
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponsePrimeiroAcessoDoUsuario
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "primeiroLogin", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.PrimeiroLogin")
    @ResponseWrapper(localName = "primeiroLoginResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.PrimeiroLoginResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/primeiroLoginRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/primeiroLoginResponse")
    public ResponsePrimeiroAcessoDoUsuario primeiroLogin(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

    /**
     * 
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponseListarClientesAssociadosAoUsuario
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarClientesAssociadosAoUsuario", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.ListarClientesAssociadosAoUsuario")
    @ResponseWrapper(localName = "listarClientesAssociadosAoUsuarioResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.ListarClientesAssociadosAoUsuarioResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/listarClientesAssociadosAoUsuarioRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/listarClientesAssociadosAoUsuarioResponse")
    public ResponseListarClientesAssociadosAoUsuario listarClientesAssociadosAoUsuario(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

    /**
     * 
     * @param usuarioAutenticado
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "reativar", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.Reativar")
    @ResponseWrapper(localName = "reativarResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.ReativarResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/reativarRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/reativarResponse")
    public ResponseServices reativar(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "usuarioAutenticado", targetNamespace = "")
        String usuarioAutenticado);

    /**
     * 
     * @param cdEmail
     * @param usuarioAutenticado
     * @param cdEmpr
     * @param cdPtov
     * @param cnpj
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "criarPrimeiroLoginDoUsuario", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.CriarPrimeiroLoginDoUsuario")
    @ResponseWrapper(localName = "criarPrimeiroLoginDoUsuarioResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.CriarPrimeiroLoginDoUsuarioResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/criarPrimeiroLoginDoUsuarioRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/criarPrimeiroLoginDoUsuarioResponse")
    public ResponseServices criarPrimeiroLoginDoUsuario(
        @WebParam(name = "cdEmpr", targetNamespace = "")
        String cdEmpr,
        @WebParam(name = "cdPtov", targetNamespace = "")
        String cdPtov,
        @WebParam(name = "cnpj", targetNamespace = "")
        String cnpj,
        @WebParam(name = "cdEmail", targetNamespace = "")
        String cdEmail,
        @WebParam(name = "usuarioAutenticado", targetNamespace = "")
        String usuarioAutenticado);

    /**
     * 
     * @param usuarioAutenticado
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "inativar", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.Inativar")
    @ResponseWrapper(localName = "inativarResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.InativarResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/inativarRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/inativarResponse")
    public ResponseServices inativar(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "usuarioAutenticado", targetNamespace = "")
        String usuarioAutenticado);

    /**
     * 
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.usuarioportal.ResponseListarPerfisDoUsuario
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPerfisDoUsuario", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.ListarPerfisDoUsuario")
    @ResponseWrapper(localName = "listarPerfisDoUsuarioResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.usuarioportal.ListarPerfisDoUsuarioResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/listarPerfisDoUsuarioRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/UsuarioPortalWS/listarPerfisDoUsuarioResponse")
    public ResponseListarPerfisDoUsuario listarPerfisDoUsuario(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

}
