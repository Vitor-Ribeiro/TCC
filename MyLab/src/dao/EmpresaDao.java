package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import dao.helper.BaseDao;
import model.Empresa;

public interface EmpresaDao extends BaseDao<Empresa, Long>{
	public Empresa pesquisarPorId(Long id, Session session) throws HibernateException;
	public List<Empresa> listarTodos(Session session) throws HibernateException ;
}
