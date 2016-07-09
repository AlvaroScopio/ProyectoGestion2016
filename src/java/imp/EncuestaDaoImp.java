package imp;

import dao.EncuestaDao;
import model.Encuesta;
import org.hibernate.Session;
import util.HibernateUtil;

public class EncuestaDaoImp implements EncuestaDao{

    @Override
    public void newEncuesta(Encuesta Encuesta) {
        
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(Encuesta);
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

}
