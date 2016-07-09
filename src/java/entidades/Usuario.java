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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUserCodigo", query = "SELECT u FROM Usuario u WHERE u.userCodigo = :userCodigo"),
    @NamedQuery(name = "Usuario.findByUserNombre", query = "SELECT u FROM Usuario u WHERE u.userNombre = :userNombre"),
    @NamedQuery(name = "Usuario.findByUserNombreCompleto", query = "SELECT u FROM Usuario u WHERE u.userNombreCompleto = :userNombreCompleto"),
    @NamedQuery(name = "Usuario.findByUserPassword", query = "SELECT u FROM Usuario u WHERE u.userPassword = :userPassword"),
    @NamedQuery(name = "Usuario.findByUserEstado", query = "SELECT u FROM Usuario u WHERE u.userEstado = :userEstado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_codigo")
    private Integer userCodigo;
    @Size(max = 20)
    @Column(name = "user_nombre")
    private String userNombre;
    @Size(max = 50)
    @Column(name = "user_nombre_completo")
    private String userNombreCompleto;
    @Size(max = 100)
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_estado")
    private Integer userEstado;
    @JoinColumn(name = "rol_codigo", referencedColumnName = "rol_codigo")
    @ManyToOne
    private Rol rolCodigo;

    public Usuario() {
    }

    public Usuario(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public Integer getUserCodigo() {
        return userCodigo;
    }

    public void setUserCodigo(Integer userCodigo) {
        this.userCodigo = userCodigo;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public void setUserNombre(String userNombre) {
        this.userNombre = userNombre;
    }

    public String getUserNombreCompleto() {
        return userNombreCompleto;
    }

    public void setUserNombreCompleto(String userNombreCompleto) {
        this.userNombreCompleto = userNombreCompleto;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserEstado() {
        return userEstado;
    }

    public void setUserEstado(Integer userEstado) {
        this.userEstado = userEstado;
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
        hash += (userCodigo != null ? userCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.userCodigo == null && other.userCodigo != null) || (this.userCodigo != null && !this.userCodigo.equals(other.userCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Usuario[ userCodigo=" + userCodigo + " ]";
    }
    
}
