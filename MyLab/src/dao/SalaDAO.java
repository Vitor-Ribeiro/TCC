package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import dao.helper.BaseDaoImpl;
import model.Sala;

public class SalaDAO extends BaseDaoImpl<Sala, Long> implements Serializable {
	@Override
    public Sala pesquisarPorId(Long id, Session session) throws HibernateException {
        Sala sala = (Sala) session.get(Sala.class, id);
        return sala;
    }

	@Override
	public List<Sala> listarTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Sala");
        return consulta.list();
	}

}
