package bean;

import dao.MenuDao;
import imp.MenuDaoImp;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import model.Menu;
import model.Usuario;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable{

    private List<Menu> listaMenus;
    private MenuModel model;
    
    @PostConstruct
    public void init(){
        listarMenus();
        model = new DefaultMenuModel();
        establecerPermisos();
    }
    
    public MenuBean() {
    }

    public List<Menu> getListaMenus() {
        return listaMenus;
    }

    public void setListaMenus(List<Menu> listaMenus) {
        this.listaMenus = listaMenus;
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
       
    public void listarMenus(){
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        int rolCodigo = us.getRol().getRolCodigo();
        MenuDao menuDao = new MenuDaoImp();
        listaMenus = menuDao.ListarMenusPorUsuario(rolCodigo);
        //listaMenus = menuDao.ListarMenus();
    }
    
    public void establecerPermisos(){
        for(Menu m : listaMenus){
            if(m.getMenuNivel() == 1){
                DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getMenuNombre());
                firstSubmenu.setIcon(m.getMenuIcono());
                for(Menu i : listaMenus){
                    if((i.getMenuPadre()) != 0 && (i.getMenuNivel() == 2)){
                        if(i.getMenuPadre() == m.getMenuCodigo()){
                            DefaultMenuItem item = new DefaultMenuItem(i.getMenuNombre());
                            item.setIcon(i.getMenuIcono());
                            item.setOutcome(i.getMenuUrl());
                            firstSubmenu.addElement(item);
                        }
                    }
                }
                model.addElement(firstSubmenu);
            }
        }
    }
    
}
