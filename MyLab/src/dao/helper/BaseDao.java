package dao.helper;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import model.Empresa;

public interface BaseDao <T, ID>{
	public void salvarOuAlterar(T entidade, Session session) throws HibernateException;
	public void excluir(T entidade, Session session) throws HibernateException;
	public Empresa pesquisarPorId(Long id, Session session) throws HibernateException;
	public List<Empresa> listarTodos(Session session) throws HibernateException ;
}
