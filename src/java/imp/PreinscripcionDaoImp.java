package imp;

import dao.PreinscripcionDao;
import java.util.List;
import model.Preinscripcion;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PreinscripcionDaoImp implements PreinscripcionDao{

    @Override
    public void newPreinscripcion(Preinscripcion preinscripcion) {
        
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(preinscripcion);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if(session != null){
                session.close();
            }
        }
        
    }

    @Override
    public boolean validaPreinscripcion(int estuCodigo, int periCodigo) {
        
        boolean p;
        List<Preinscripcion> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select p from Preinscripcion p " +
                     "where p.periodo.periCodigo=:peri_codigo " +
                     "and p.estudiante.estuCodigo=:estu_codigo ";
        try{
            Query query = session.createQuery(hql);
            query.setParameter("peri_codigo", periCodigo);
            query.setParameter("estu_codigo", estuCodigo);
            lista = query.list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        
        if(lista.size() > 0){
            p = false;            
        } else {
            p = true;
        }
        
        return p;
        
    }
    
}
