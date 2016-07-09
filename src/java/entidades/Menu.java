/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuCodigo", query = "SELECT m FROM Menu m WHERE m.menuCodigo = :menuCodigo"),
    @NamedQuery(name = "Menu.findByMenuPadre", query = "SELECT m FROM Menu m WHERE m.menuPadre = :menuPadre"),
    @NamedQuery(name = "Menu.findByMenuNivel", query = "SELECT m FROM Menu m WHERE m.menuNivel = :menuNivel"),
    @NamedQuery(name = "Menu.findByMenuOrden", query = "SELECT m FROM Menu m WHERE m.menuOrden = :menuOrden"),
    @NamedQuery(name = "Menu.findByMenuNombre", query = "SELECT m FROM Menu m WHERE m.menuNombre = :menuNombre"),
    @NamedQuery(name = "Menu.findByMenuUrl", query = "SELECT m FROM Menu m WHERE m.menuUrl = :menuUrl"),
    @NamedQuery(name = "Menu.findByMenuIcono", query = "SELECT m FROM Menu m WHERE m.menuIcono = :menuIcono"),
    @NamedQuery(name = "Menu.findByMenuEstado", query = "SELECT m FROM Menu m WHERE m.menuEstado = :menuEstado")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_codigo")
    private Integer menuCodigo;
    @Column(name = "menu_padre")
    private Integer menuPadre;
    @Column(name = "menu_nivel")
    private Integer menuNivel;
    @Column(name = "menu_orden")
    private Integer menuOrden;
    @Size(max = 50)
    @Column(name = "menu_nombre")
    private String menuNombre;
    @Size(max = 200)
    @Column(name = "menu_url")
    private String menuUrl;
    @Size(max = 50)
    @Column(name = "menu_icono")
    private String menuIcono;
    @Column(name = "menu_estado")
    private Integer menuEstado;
    @OneToMany(mappedBy = "menuCodigo")
    private Collection<RolMenu> rolMenuCollection;

    public Menu() {
    }

    public Menu(Integer menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    public Integer getMenuCodigo() {
        return menuCodigo;
    }

    public void setMenuCodigo(Integer menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    public Integer getMenuPadre() {
        return menuPadre;
    }

    public void setMenuPadre(Integer menuPadre) {
        this.menuPadre = menuPadre;
    }

    public Integer getMenuNivel() {
        return menuNivel;
    }

    public void setMenuNivel(Integer menuNivel) {
        this.menuNivel = menuNivel;
    }

    public Integer getMenuOrden() {
        return menuOrden;
    }

    public void setMenuOrden(Integer menuOrden) {
        this.menuOrden = menuOrden;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcono() {
        return menuIcono;
    }

    public void setMenuIcono(String menuIcono) {
        this.menuIcono = menuIcono;
    }

    public Integer getMenuEstado() {
        return menuEstado;
    }

    public void setMenuEstado(Integer menuEstado) {
        this.menuEstado = menuEstado;
    }

    @XmlTransient
    public Collection<RolMenu> getRolMenuCollection() {
        return rolMenuCollection;
    }

    public void setRolMenuCollection(Collection<RolMenu> rolMenuCollection) {
        this.rolMenuCollection = rolMenuCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuCodigo != null ? menuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuCodigo == null && other.menuCodigo != null) || (this.menuCodigo != null && !this.menuCodigo.equals(other.menuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Menu[ menuCodigo=" + menuCodigo + " ]";
    }
    
}
