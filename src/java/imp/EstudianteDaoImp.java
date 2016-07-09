package imp;

import dao.EstudianteDao;
import model.Estudiante;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EstudianteDaoImp implements EstudianteDao{

    @Override
    public Estudiante estudiantePorCedula(String estuCedula) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select e from Estudiante e " 
                +    "where estuCedula=:estu_cedula";
        Query query = session.createQuery(hql);
        query.setParameter("estu_cedula", estuCedula);
        Estudiante estudiante = (Estudiante)query.uniqueResult();
        return estudiante;
        
    }

    
    
}
