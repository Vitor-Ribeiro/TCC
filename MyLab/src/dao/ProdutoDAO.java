package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDaoImpl;
import model.Produto;

public class ProdutoDAO extends BaseDaoImpl<Produto, Long> implements Serializable {
	@Override
    public Produto pesquisarPorId(Long id, Session session) throws HibernateException {
        Produto produto = (Produto) session.get(Produto.class, id);
        return produto;
    }

	@Override
	public List<Produto> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Produto");
        return consulta.list();
	}

}