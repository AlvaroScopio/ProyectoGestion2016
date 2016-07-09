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
@Table(name = "semestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Semestre.findAll", query = "SELECT s FROM Semestre s"),
    @NamedQuery(name = "Semestre.findBySemeCodigo", query = "SELECT s FROM Semestre s WHERE s.semeCodigo = :semeCodigo"),
    @NamedQuery(name = "Semestre.findBySemeNombre", query = "SELECT s FROM Semestre s WHERE s.semeNombre = :semeNombre"),
    @NamedQuery(name = "Semestre.findBySemeDescripcion", query = "SELECT s FROM Semestre s WHERE s.semeDescripcion = :semeDescripcion")})
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seme_codigo")
    private Integer semeCodigo;
    @Size(max = 15)
    @Column(name = "seme_nombre")
    private String semeNombre;
    @Size(max = 100)
    @Column(name = "seme_descripcion")
    private String semeDescripcion;
    @OneToMany(mappedBy = "semeCodigo")
    private Collection<MateriaSemestreCarrera> materiaSemestreCarreraCollection;
    @OneToMany(mappedBy = "semeCodigo")
    private Collection<Curso> cursoCollection;

    public Semestre() {
    }

    public Semestre(Integer semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    public Integer getSemeCodigo() {
        return semeCodigo;
    }

    public void setSemeCodigo(Integer semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    public String getSemeNombre() {
        return semeNombre;
    }

    public void setSemeNombre(String semeNombre) {
        this.semeNombre = semeNombre;
    }

    public String getSemeDescripcion() {
        return semeDescripcion;
    }

    public void setSemeDescripcion(String semeDescripcion) {
        this.semeDescripcion = semeDescripcion;
    }

    @XmlTransient
    public Collection<MateriaSemestreCarrera> getMateriaSemestreCarreraCollection() {
        return materiaSemestreCarreraCollection;
    }

    public void setMateriaSemestreCarreraCollection(Collection<MateriaSemestreCarrera> materiaSemestreCarreraCollection) {
        this.materiaSemestreCarreraCollection = materiaSemestreCarreraCollection;
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
        hash += (semeCodigo != null ? semeCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Semestre)) {
            return false;
        }
        Semestre other = (Semestre) object;
        if ((this.semeCodigo == null && other.semeCodigo != null) || (this.semeCodigo != null && !this.semeCodigo.equals(other.semeCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Semestre[ semeCodigo=" + semeCodigo + " ]";
    }
    
}
