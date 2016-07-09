package imp;

import dao.CarreraDao;
import java.util.List;
import model.Carrera;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class CarreraDaoImp implements CarreraDao{
    
    @Override
    public List<Carrera> listarCarreras(){
        List<Carrera> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Carrera";
        try{
            lista = session.createQuery(hql).list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
    @Override
    public void newCarrera(Carrera carrera){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(carrera);
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
    public void updateCarrera(Carrera carrera){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(carrera);
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
    public void deleteCarrera(Carrera carrera){
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(carrera);
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