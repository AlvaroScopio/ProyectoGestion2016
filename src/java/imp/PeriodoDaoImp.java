package imp;

import dao.PeriodoDao;
import model.Periodo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class PeriodoDaoImp implements PeriodoDao{

    @Override
    public Periodo periodoVigente() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Periodo WHERE periCodigo=1";
        Query query = session.createQuery(hql);
        Periodo periodo = (Periodo)query.uniqueResult();
        return periodo;
        
    }
    
}
