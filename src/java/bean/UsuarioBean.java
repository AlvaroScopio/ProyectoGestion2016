package bean;

import dao.UsuarioDao;
import imp.UsuarioDaoImp;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
    
    private List<Usuario> listaUsuarios;
    private Usuario usuario;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    public List<Usuario> getListaUsuarios() {
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        listaUsuarios = usuarioDao.findAll();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public void prepararNuevoUsuario(){
        usuario = new Usuario();
    }
    
    public void nuevoUsuario(){
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.newUsuario(usuario);
    }
    
    public void modificarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.updateUsuario(usuario);
        usuario = new Usuario();
    }
    
    public void eliminarUsuaio(){
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        usuarioDao.deleteUsuario(usuario);
        usuario = new Usuario();
    }
    
}
