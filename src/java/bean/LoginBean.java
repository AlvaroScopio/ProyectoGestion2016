package bean;

import dao.UsuarioDao;
import imp.UsuarioDaoImp;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import model.Usuario;

@Named(value = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    
    private Usuario usuario;
    
    public LoginBean() {
        
        HttpSession miSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        miSession.setMaxInactiveInterval(30000);
        
    }
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
    }
    
    public String login(){
        
        Usuario us;
        UsuarioDao usuarioDao = new UsuarioDaoImp();
        us = usuarioDao.getByUserNombre(usuario.getUserNombre());
        if(us != null){
            if(us.getUserPassword().equals(usuario.getUserPassword())){
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("user", usuario.getUserNombre());
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", us);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", us.getUserNombre()));
                return "index2?faces-redirect=true";
            }
        }
        usuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de Acceso", "Usuario o Contraseña incorrecto"));
        return "/index";
        
    }
    
    public String cerrarSession(){
        
        usuario = new Usuario();
        
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index?faces-redirect=true";
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
