package imp;

import dao.MateriaDao;
import model.Materia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MateriaDaoImp implements MateriaDao{

    @Override
    public List<Materia> ListarMateriasPorCarrera(int carrCodigo) {
        
        List<Materia> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select m from Materia m, MateriaSemestreCarrera msc " +
                     "where msc.materia.mateCodigo=m.mateCodigo " +
                     "and msc.carrera.carrCodigo=:carr_codigo " +
                     "order by msc.semestre.semeCodigo";
        try{
            Query query = session.createQuery(hql);
            query.setParameter("carr_codigo", carrCodigo);
            lista = query.list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
        
    }

    @Override
    public Materia materiaPorCodigo(int mateCodigo) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Materia WHERE mateCodigo=:mate_codigo";
        Query query = session.createQuery(hql);
        query.setParameter("mate_codigo", mateCodigo);
        Materia materia = (Materia)query.uniqueResult();
        return materia;
        
    }
    
}