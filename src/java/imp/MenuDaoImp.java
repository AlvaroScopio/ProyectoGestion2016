package imp;

import dao.MenuDao;
import java.util.List;
import model.Menu;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MenuDaoImp implements MenuDao{

    @Override
    public List<Menu> ListarMenus(){
        List<Menu> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select m from Menu m";
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
    public List<Menu> ListarMenusPorUsuario(int rolCodigo) {
        List<Menu> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "select m from Menu m, RolMenu rm, Rol r "
                +    "where rm.rol.rolCodigo=r.rolCodigo "
                +    "and rm.menu.menuCodigo=m.menuCodigo "
                +    "and r.rolCodigo=:rol_codigo "
                +    "order by m.menuCodigo";
        try{
            Query query = session.createQuery(hql);
            query.setParameter("rol_codigo", rolCodigo);
            lista = query.list();
            t.commit();
            session.close();
        } catch (Exception e) {
            t.rollback();
        }
        return lista;
    }
    
    
}
