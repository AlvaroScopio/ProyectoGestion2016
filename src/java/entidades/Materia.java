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
@Table(name = "materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
    @NamedQuery(name = "Materia.findByMateCodigo", query = "SELECT m FROM Materia m WHERE m.mateCodigo = :mateCodigo"),
    @NamedQuery(name = "Materia.findByMateNombre", query = "SELECT m FROM Materia m WHERE m.mateNombre = :mateNombre"),
    @NamedQuery(name = "Materia.findByMateCreditos", query = "SELECT m FROM Materia m WHERE m.mateCreditos = :mateCreditos"),
    @NamedQuery(name = "Materia.findByMateDescripcion", query = "SELECT m FROM Materia m WHERE m.mateDescripcion = :mateDescripcion")})
public class Materia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mate_codigo")
    private Integer mateCodigo;
    @Size(max = 50)
    @Column(name = "mate_nombre")
    private String mateNombre;
    @Column(name = "mate_creditos")
    private Integer mateCreditos;
    @Size(max = 100)
    @Column(name = "mate_descripcion")
    private String mateDescripcion;
    @OneToMany(mappedBy = "mateCodigo")
    private Collection<DocenteMateriaCurso> docenteMateriaCursoCollection;
    @OneToMany(mappedBy = "mateCodigo")
    private Collection<MateriaSemestreCarrera> materiaSemestreCarreraCollection;
    @OneToMany(mappedBy = "mateCodigo")
    private Collection<MateriaEstadistico> materiaEstadisticoCollection;
    @OneToMany(mappedBy = "mateCodigo")
    private Collection<DisponibilidadMateria> disponibilidadMateriaCollection;
    @OneToMany(mappedBy = "mateCodigo")
    private Collection<Preinscripcion> preinscripcionCollection;

    public Materia() {
    }

    public Materia(Integer mateCodigo) {
        this.mateCodigo = mateCodigo;
    }

    public Integer getMateCodigo() {
        return mateCodigo;
    }

    public void setMateCodigo(Integer mateCodigo) {
        this.mateCodigo = mateCodigo;
    }

    public String getMateNombre() {
        return mateNombre;
    }

    public void setMateNombre(String mateNombre) {
        this.mateNombre = mateNombre;
    }

    public Integer getMateCreditos() {
        return mateCreditos;
    }

    public void setMateCreditos(Integer mateCreditos) {
        this.mateCreditos = mateCreditos;
    }

    public String getMateDescripcion() {
        return mateDescripcion;
    }

    public void setMateDescripcion(String mateDescripcion) {
        this.mateDescripcion = mateDescripcion;
    }

    @XmlTransient
    public Collection<DocenteMateriaCurso> getDocenteMateriaCursoCollection() {
        return docenteMateriaCursoCollection;
    }

    public void setDocenteMateriaCursoCollection(Collection<DocenteMateriaCurso> docenteMateriaCursoCollection) {
        this.docenteMateriaCursoCollection = docenteMateriaCursoCollection;
    }

    @XmlTransient
    public Collection<MateriaSemestreCarrera> getMateriaSemestreCarreraCollection() {
        return materiaSemestreCarreraCollection;
    }

    public void setMateriaSemestreCarreraCollection(Collection<MateriaSemestreCarrera> materiaSemestreCarreraCollection) {
        this.materiaSemestreCarreraCollection = materiaSemestreCarreraCollection;
    }

    @XmlTransient
    public Collection<MateriaEstadistico> getMateriaEstadisticoCollection() {
        return materiaEstadisticoCollection;
    }

    public void setMateriaEstadisticoCollection(Collection<MateriaEstadistico> materiaEstadisticoCollection) {
        this.materiaEstadisticoCollection = materiaEstadisticoCollection;
    }

    @XmlTransient
    public Collection<DisponibilidadMateria> getDisponibilidadMateriaCollection() {
        return disponibilidadMateriaCollection;
    }

    public void setDisponibilidadMateriaCollection(Collection<DisponibilidadMateria> disponibilidadMateriaCollection) {
        this.disponibilidadMateriaCollection = disponibilidadMateriaCollection;
    }

    @XmlTransient
    public Collection<Preinscripcion> getPreinscripcionCollection() {
        return preinscripcionCollection;
    }

    public void setPreinscripcionCollection(Collection<Preinscripcion> preinscripcionCollection) {
        this.preinscripcionCollection = preinscripcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mateCodigo != null ? mateCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materia)) {
            return false;
        }
        Materia other = (Materia) object;
        if ((this.mateCodigo == null && other.mateCodigo != null) || (this.mateCodigo != null && !this.mateCodigo.equals(other.mateCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Materia[ mateCodigo=" + mateCodigo + " ]";
    }
    
}
