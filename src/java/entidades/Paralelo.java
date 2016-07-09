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
@Table(name = "paralelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paralelo.findAll", query = "SELECT p FROM Paralelo p"),
    @NamedQuery(name = "Paralelo.findByParaCodigo", query = "SELECT p FROM Paralelo p WHERE p.paraCodigo = :paraCodigo"),
    @NamedQuery(name = "Paralelo.findByParaNombre", query = "SELECT p FROM Paralelo p WHERE p.paraNombre = :paraNombre"),
    @NamedQuery(name = "Paralelo.findByParaDescripcion", query = "SELECT p FROM Paralelo p WHERE p.paraDescripcion = :paraDescripcion")})
public class Paralelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "para_codigo")
    private Integer paraCodigo;
    @Size(max = 15)
    @Column(name = "para_nombre")
    private String paraNombre;
    @Size(max = 50)
    @Column(name = "para_descripcion")
    private String paraDescripcion;
    @OneToMany(mappedBy = "paraCodigo")
    private Collection<Curso> cursoCollection;

    public Paralelo() {
    }

    public Paralelo(Integer paraCodigo) {
        this.paraCodigo = paraCodigo;
    }

    public Integer getParaCodigo() {
        return paraCodigo;
    }

    public void setParaCodigo(Integer paraCodigo) {
        this.paraCodigo = paraCodigo;
    }

    public String getParaNombre() {
        return paraNombre;
    }

    public void setParaNombre(String paraNombre) {
        this.paraNombre = paraNombre;
    }

    public String getParaDescripcion() {
        return paraDescripcion;
    }

    public void setParaDescripcion(String paraDescripcion) {
        this.paraDescripcion = paraDescripcion;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paraCodigo != null ? paraCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paralelo)) {
            return false;
        }
        Paralelo other = (Paralelo) object;
        if ((this.paraCodigo == null && other.paraCodigo != null) || (this.paraCodigo != null && !this.paraCodigo.equals(other.paraCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Paralelo[ paraCodigo=" + paraCodigo + " ]";
    }
    
}
