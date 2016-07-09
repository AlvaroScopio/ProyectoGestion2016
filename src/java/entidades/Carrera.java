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
@Table(name = "carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrera.findAll", query = "SELECT c FROM Carrera c"),
    @NamedQuery(name = "Carrera.findByCarrCodigo", query = "SELECT c FROM Carrera c WHERE c.carrCodigo = :carrCodigo"),
    @NamedQuery(name = "Carrera.findByCarrNombre", query = "SELECT c FROM Carrera c WHERE c.carrNombre = :carrNombre"),
    @NamedQuery(name = "Carrera.findByCarrDescripcion", query = "SELECT c FROM Carrera c WHERE c.carrDescripcion = :carrDescripcion")})
public class Carrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "carr_codigo")
    private Integer carrCodigo;
    @Size(max = 50)
    @Column(name = "carr_nombre")
    private String carrNombre;
    @Size(max = 100)
    @Column(name = "carr_descripcion")
    private String carrDescripcion;
    @OneToMany(mappedBy = "carrCodigo")
    private Collection<Estudiante> estudianteCollection;
    @OneToMany(mappedBy = "carrCodigo")
    private Collection<Aula> aulaCollection;
    @OneToMany(mappedBy = "carrCodigo")
    private Collection<MateriaSemestreCarrera> materiaSemestreCarreraCollection;
    @OneToMany(mappedBy = "carrCodigo")
    private Collection<Curso> cursoCollection;

    public Carrera() {
    }

    public Carrera(Integer carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    public Integer getCarrCodigo() {
        return carrCodigo;
    }

    public void setCarrCodigo(Integer carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    public String getCarrNombre() {
        return carrNombre;
    }

    public void setCarrNombre(String carrNombre) {
        this.carrNombre = carrNombre;
    }

    public String getCarrDescripcion() {
        return carrDescripcion;
    }

    public void setCarrDescripcion(String carrDescripcion) {
        this.carrDescripcion = carrDescripcion;
    }

    @XmlTransient
    public Collection<Estudiante> getEstudianteCollection() {
        return estudianteCollection;
    }

    public void setEstudianteCollection(Collection<Estudiante> estudianteCollection) {
        this.estudianteCollection = estudianteCollection;
    }

    @XmlTransient
    public Collection<Aula> getAulaCollection() {
        return aulaCollection;
    }

    public void setAulaCollection(Collection<Aula> aulaCollection) {
        this.aulaCollection = aulaCollection;
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
        hash += (carrCodigo != null ? carrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.carrCodigo == null && other.carrCodigo != null) || (this.carrCodigo != null && !this.carrCodigo.equals(other.carrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Carrera[ carrCodigo=" + carrCodigo + " ]";
    }
    
}
