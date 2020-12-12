package dao.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;

import dao.EmpresaDaoImpl;
import dao.helper.HibernateUtil;
import model.Empresa;


@Path("/empresa")
public class EmpresaServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Empresa> getEmpresa(){
		 EmpresaDaoImpl empresaDAO = new EmpresaDaoImpl();
		 Session session = HibernateUtil.abrirSessao();
		 List<Empresa> tmp  = empresaDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Empresa getEmpresa(@PathParam("id") Long id){
		 EmpresaDaoImpl empresaDAO = new EmpresaDaoImpl();
		 Session session = HibernateUtil.abrirSessao();
		 Empresa empresa = empresaDAO.pesquisarPorId(id, session);
		 session.close();
		 return empresa;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON) {
		 Gson gson = new Gson();
	     Empresa empresa = gson.fromJson(dadosJSON, Empresa.class);	     
	     EmpresaDaoImpl empresaDAO = new EmpresaDaoImpl();
	     Session session = HibernateUtil.abrirSessao();
	     empresaDAO.salvarOuAlterar(empresa, session);
		 session.close();
	     return empresa.getId();
	 }
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Empresa empresa = gson.fromJson(dadosJSON, Empresa.class);	     	     
	     EmpresaDaoImpl empresaDAO = new EmpresaDaoImpl();
	     Session session = HibernateUtil.abrirSessao();
	     empresaDAO.salvarOuAlterar(empresa, session);
		 session.close();
	     return empresa.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     EmpresaDaoImpl empresaDAO = new EmpresaDaoImpl();	     
	     Gson gson = new Gson();
	     Empresa empresa = gson.fromJson(dadosJSON, Empresa.class);	     
	     Session session = HibernateUtil.abrirSessao();
	     empresaDAO.excluir(empresa, session);
		 session.close();
	     return true;
	 }
}
