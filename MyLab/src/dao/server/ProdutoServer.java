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


import dao.ProdutoDAO;
import dao.helper.HibernateUtil;
import model.Produto;

@Path("/produto")
public class ProdutoServer {

	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> getProduto(){
		 ProdutoDAO produtoDAO = new ProdutoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 List<Produto> tmp  = produtoDAO.listarTodos(session);
		 session.close();
		 return tmp;
    }
	 
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
    public Produto getProduto(@PathParam("id") Long id){
		 ProdutoDAO produtoDAO = new ProdutoDAO();
		 Session session = HibernateUtil.abrirSessao();
		 Produto produto = produtoDAO.pesquisarPorId(id, session);
		 session.close();
		 return produto;
    }
	 
	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long cadastrar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Produto produto = gson.fromJson(dadosJSON, Produto.class);
	     ProdutoDAO produtoDAO = new ProdutoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     produtoDAO.salvarOuAlterar(produto, session);
		 session.close();
	     return produto.getId();
	 }
	 
	 
	 
	 @PUT
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	 public Long alterar(@FormParam("dado") String dadosJSON ) {
		 Gson gson = new Gson();
	     Produto produto = gson.fromJson(dadosJSON, Produto.class);	     	     
	     ProdutoDAO produtoDAO = new ProdutoDAO();
	     Session session = HibernateUtil.abrirSessao();
	     produtoDAO.salvarOuAlterar(produto, session);
		 session.close();
	     return produto.getId();
	 }
	 
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Boolean deletar(@FormParam("dado") String dadosJSON){
	     ProdutoDAO produtoDAO = new ProdutoDAO();	     
	     Gson gson = new Gson();
	     Produto produto = gson.fromJson(dadosJSON, Produto.class);	     
	     Session session = HibernateUtil.abrirSessao();
	     produtoDAO.excluir(produto, session);
		 session.close();
	     return true;
	 }
}
