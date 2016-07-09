package imp;

import dao.UsuarioDao;
import java.util.List;
import model.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class UsuarioDaoImp implements UsuarioDao{
    
    @Override
    public Usuario getByUserNombre(String userNombre){
     
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String hql = "FROM Usuario WHERE userNombre=:user_nombre";
        Query query = session.createQuery(hql);
        query.setParameter("user_nombre", userNombre);
        Usuario usuario = (Usuario)query.uniqueResult();
        return usuario;
        
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String sql = "select u from Usuario u";
        try{
            session.beginTransaction();
            lista = session.createQuery(sql).list();
            session.beginTransaction().commit();
        } catch (Exception e){
            session.beginTransaction().rollback();
        }
        return lista;
    }

    @Override
    public void newUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(usuario);
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
    public void updateUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
//            Usuario usuariodb = (Usuario) session.load(Usuario.class, usuario.getUserCodigo());
//            usuariodb.setUserNombre(usuario.getUserNombre());
//            usuariodb.setUserNombreCompleto(usuario.getUserNombreCompleto());
//            usuariodb.setUserEstado(usuario.getUserEstado());
//            usuariodb.setRol(usuario.getRol());
            session.update(usuario);
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
    public void deleteUsuario(Usuario usuario) {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(usuario);
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
