package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDaoImpl;
import model.Empresa;

public class EmpresaDaoImpl extends BaseDaoImpl<Empresa, Long> implements Serializable, EmpresaDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Empresa pesquisarPorId(Long id, Session session) throws HibernateException {
        Empresa empresa = (Empresa) session.get(Empresa.class, id);
        return empresa;
    }

	@SuppressWarnings("rawtypes")
	@Override
	public List listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Empresa");
        return consulta.list();
	}

}