
package cbpi.fit.saa.ws.usuarioportal;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "FuncionarioClienteWS", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface FuncionarioClienteWS {


    /**
     * 
     * @param usuarioMaster
     * @param pontosDeVenda
     * @param usuarioAutenticado
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "associarCnpjsAoUsuario", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.AssociarCnpjsAoUsuario")
    @ResponseWrapper(localName = "associarCnpjsAoUsuarioResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.AssociarCnpjsAoUsuarioResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/associarCnpjsAoUsuarioRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/associarCnpjsAoUsuarioResponse")
    public ResponseServices associarCnpjsAoUsuario(
        @WebParam(name = "usuarioMaster", targetNamespace = "")
        String usuarioMaster,
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "usuarioAutenticado", targetNamespace = "")
        String usuarioAutenticado,
        @WebParam(name = "pontosDeVenda", targetNamespace = "")
        List<DadosClienteRIVO> pontosDeVenda);

    /**
     * 
     * @param usuarioMaster
     * @param usuarioAutenticado
     * @param usuario
     * @param cdPerfis
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "associarPerfisAoUsuario", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.AssociarPerfisAoUsuario")
    @ResponseWrapper(localName = "associarPerfisAoUsuarioResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.AssociarPerfisAoUsuarioResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/associarPerfisAoUsuarioRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/associarPerfisAoUsuarioResponse")
    public ResponseServices associarPerfisAoUsuario(
        @WebParam(name = "usuarioMaster", targetNamespace = "")
        String usuarioMaster,
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "usuarioAutenticado", targetNamespace = "")
        String usuarioAutenticado,
        @WebParam(name = "cdPerfis", targetNamespace = "")
        List<String> cdPerfis);

    /**
     * 
     * @param usuario
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseListarPerfisDisponiveisParaAssociacao
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarPerfisDisponiveisParaAssociacao", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.ListarPerfisDisponiveisParaAssociacao")
    @ResponseWrapper(localName = "listarPerfisDisponiveisParaAssociacaoResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.ListarPerfisDisponiveisParaAssociacaoResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/listarPerfisDisponiveisParaAssociacaoRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/listarPerfisDisponiveisParaAssociacaoResponse")
    public ResponseListarPerfisDisponiveisParaAssociacao listarPerfisDisponiveisParaAssociacao(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario);

    /**
     * 
     * @param usuarioMaster
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseListarUsuariosVinculadosAoUsuarioMaster
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listarUsuariosVinculadosAoUsuarioMaster", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.ListarUsuariosVinculadosAoUsuarioMaster")
    @ResponseWrapper(localName = "listarUsuariosVinculadosAoUsuarioMasterResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.ListarUsuariosVinculadosAoUsuarioMasterResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/listarUsuariosVinculadosAoUsuarioMasterRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/listarUsuariosVinculadosAoUsuarioMasterResponse")
    public ResponseListarUsuariosVinculadosAoUsuarioMaster listarUsuariosVinculadosAoUsuarioMaster(
        @WebParam(name = "usuarioMaster", targetNamespace = "")
        String usuarioMaster);

    /**
     * 
     * @param usuarioMaster
     * @param pontosDeVenda
     * @param usuarioPortal
     * @param cdPerfis
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseIncluirFuncionarioCliente
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "incluir", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.Incluir")
    @ResponseWrapper(localName = "incluirResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.IncluirResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/incluirRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/incluirResponse")
    public ResponseIncluirFuncionarioCliente incluir(
        @WebParam(name = "usuarioMaster", targetNamespace = "")
        String usuarioMaster,
        @WebParam(name = "usuarioPortal", targetNamespace = "")
        UsuarioPortalVO usuarioPortal,
        @WebParam(name = "cdPerfis", targetNamespace = "")
        List<String> cdPerfis,
        @WebParam(name = "pontosDeVenda", targetNamespace = "")
        List<DadosClienteRIVO> pontosDeVenda);

    /**
     * 
     * @param usuarioMaster
     * @param usuarioPortal
     * @return
     *     returns cbpi.fit.saa.ws.funcionariocliente.ResponseServices
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "alterar", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.Alterar")
    @ResponseWrapper(localName = "alterarResponse", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", className = "cbpi.fit.saa.ws.funcionariocliente.AlterarResponse")
    @Action(input = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/alterarRequest", output = "http://usuarioportal.ws.saa.fit.cbpi/FuncionarioClienteWS/alterarResponse")
    public ResponseServices alterar(
        @WebParam(name = "usuarioMaster", targetNamespace = "")
        String usuarioMaster,
        @WebParam(name = "usuarioPortal", targetNamespace = "")
        UsuarioPortalVO usuarioPortal);

}
