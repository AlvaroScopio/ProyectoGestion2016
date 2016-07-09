/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "rol_menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolMenu.findAll", query = "SELECT r FROM RolMenu r"),
    @NamedQuery(name = "RolMenu.findByRomeCodigo", query = "SELECT r FROM RolMenu r WHERE r.romeCodigo = :romeCodigo")})
public class RolMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rome_codigo")
    private Integer romeCodigo;
    @JoinColumn(name = "menu_codigo", referencedColumnName = "menu_codigo")
    @ManyToOne
    private Menu menuCodigo;
    @JoinColumn(name = "rol_codigo", referencedColumnName = "rol_codigo")
    @ManyToOne
    private Rol rolCodigo;

    public RolMenu() {
    }

    public RolMenu(Integer romeCodigo) {
        this.romeCodigo = romeCodigo;
    }

    public Integer getRomeCodigo() {
        return romeCodigo;
    }

    public void setRomeCodigo(Integer romeCodigo) {
        this.romeCodigo = romeCodigo;
    }

    public Menu getMenuCodigo() {
        return menuCodigo;
    }

    public void setMenuCodigo(Menu menuCodigo) {
        this.menuCodigo = menuCodigo;
    }

    public Rol getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Rol rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (romeCodigo != null ? romeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolMenu)) {
            return false;
        }
        RolMenu other = (RolMenu) object;
        if ((this.romeCodigo == null && other.romeCodigo != null) || (this.romeCodigo != null && !this.romeCodigo.equals(other.romeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.RolMenu[ romeCodigo=" + romeCodigo + " ]";
    }
    
}
