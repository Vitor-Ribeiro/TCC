package dao.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;

import com.google.gson.Gson;


import dao.SalaDAO;
import dao.helper.HibernateUtil;
import model.Sala;

@Path("/sala")
public class SalaServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sala> getSala(){
		 SalaDAO salaDAO = new SalaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Sala> tmp  = salaDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Sala getSala(@PathParam("id") Long id){
		 SalaDAO salaDAO = new SalaDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Sala sala = salaDAO.pesquisarPorId(id, session);
		 session.close();
		 return sala;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Sala sala = gson.fromJson(dadosJSON, Sala.class);
	     SalaDAO salaDAO = new SalaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     salaDAO.salvarOuAlterar(sala, session);
		 session.close();
	     return sala.getId();
	 }
	 
	 
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Sala sala = gson.fromJson(dadosJSON, Sala.class);	     	     
	     SalaDAO salaDAO = new SalaDAO();
	     Session session = HibernateUtil.abrirSessao();
	     salaDAO.salvarOuAlterar(sala, session);
		 session.close();
	     return sala.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     SalaDAO salaDAO = new SalaDAO();	     
	     Gson gson = new Gson();
	     Sala sala = gson.fromJson(dadosJSON, Sala.class);	     
	     Session session = HibernateUtil.abrirSessao();
	     salaDAO.excluir(sala, session);
		 session.close();
	     return true;
	 }
}


