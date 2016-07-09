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
@Table(name = "rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
    @NamedQuery(name = "Rol.findByRolCodigo", query = "SELECT r FROM Rol r WHERE r.rolCodigo = :rolCodigo"),
    @NamedQuery(name = "Rol.findByRolNombre", query = "SELECT r FROM Rol r WHERE r.rolNombre = :rolNombre"),
    @NamedQuery(name = "Rol.findByRolDescripcion", query = "SELECT r FROM Rol r WHERE r.rolDescripcion = :rolDescripcion"),
    @NamedQuery(name = "Rol.findByRolEstado", query = "SELECT r FROM Rol r WHERE r.rolEstado = :rolEstado")})
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rol_codigo")
    private Integer rolCodigo;
    @Size(max = 15)
    @Column(name = "rol_nombre")
    private String rolNombre;
    @Size(max = 50)
    @Column(name = "rol_descripcion")
    private String rolDescripcion;
    @Column(name = "rol_estado")
    private Integer rolEstado;
    @OneToMany(mappedBy = "rolCodigo")
    private Collection<RolMenu> rolMenuCollection;
    @OneToMany(mappedBy = "rolCodigo")
    private Collection<Usuario> usuarioCollection;

    public Rol() {
    }

    public Rol(Integer rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public Integer getRolCodigo() {
        return rolCodigo;
    }

    public void setRolCodigo(Integer rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public Integer getRolEstado() {
        return rolEstado;
    }

    public void setRolEstado(Integer rolEstado) {
        this.rolEstado = rolEstado;
    }

    @XmlTransient
    public Collection<RolMenu> getRolMenuCollection() {
        return rolMenuCollection;
    }

    public void setRolMenuCollection(Collection<RolMenu> rolMenuCollection) {
        this.rolMenuCollection = rolMenuCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolCodigo != null ? rolCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.rolCodigo == null && other.rolCodigo != null) || (this.rolCodigo != null && !this.rolCodigo.equals(other.rolCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Rol[ rolCodigo=" + rolCodigo + " ]";
    }
    
}
