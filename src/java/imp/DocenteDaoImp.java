package imp;

import dao.DocenteDao;
import model.Docente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class DocenteDaoImp implements DocenteDao{

    @Override
    public Docente docentePorCedula(String doceCedula) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select d from Docente d " 
                +    "where doceCedula=:doce_cedula";
        Query query = session.createQuery(hql);
        query.setParameter("doce_cedula", doceCedula);
        Docente docente = (Docente)query.uniqueResult();
        return docente;
        
    }

    
    
}
