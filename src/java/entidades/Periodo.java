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
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByPeriCodigo", query = "SELECT p FROM Periodo p WHERE p.periCodigo = :periCodigo"),
    @NamedQuery(name = "Periodo.findByPeriNombre", query = "SELECT p FROM Periodo p WHERE p.periNombre = :periNombre"),
    @NamedQuery(name = "Periodo.findByPeriVigencia", query = "SELECT p FROM Periodo p WHERE p.periVigencia = :periVigencia"),
    @NamedQuery(name = "Periodo.findByPeriDescripcion", query = "SELECT p FROM Periodo p WHERE p.periDescripcion = :periDescripcion")})
public class Periodo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "peri_codigo")
    private Integer periCodigo;
    @Size(max = 15)
    @Column(name = "peri_nombre")
    private String periNombre;
    @Column(name = "peri_vigencia")
    private Integer periVigencia;
    @Size(max = 100)
    @Column(name = "peri_descripcion")
    private String periDescripcion;
    @OneToMany(mappedBy = "periCodigo")
    private Collection<MateriaEstadistico> materiaEstadisticoCollection;
    @OneToMany(mappedBy = "periCodigo")
    private Collection<Encuesta> encuestaCollection;
    @OneToMany(mappedBy = "periCodigo")
    private Collection<Curso> cursoCollection;
    @OneToMany(mappedBy = "periCodigo")
    private Collection<Preinscripcion> preinscripcionCollection;

    public Periodo() {
    }

    public Periodo(Integer periCodigo) {
        this.periCodigo = periCodigo;
    }

    public Integer getPeriCodigo() {
        return periCodigo;
    }

    public void setPeriCodigo(Integer periCodigo) {
        this.periCodigo = periCodigo;
    }

    public String getPeriNombre() {
        return periNombre;
    }

    public void setPeriNombre(String periNombre) {
        this.periNombre = periNombre;
    }

    public Integer getPeriVigencia() {
        return periVigencia;
    }

    public void setPeriVigencia(Integer periVigencia) {
        this.periVigencia = periVigencia;
    }

    public String getPeriDescripcion() {
        return periDescripcion;
    }

    public void setPeriDescripcion(String periDescripcion) {
        this.periDescripcion = periDescripcion;
    }

    @XmlTransient
    public Collection<MateriaEstadistico> getMateriaEstadisticoCollection() {
        return materiaEstadisticoCollection;
    }

    public void setMateriaEstadisticoCollection(Collection<MateriaEstadistico> materiaEstadisticoCollection) {
        this.materiaEstadisticoCollection = materiaEstadisticoCollection;
    }

    @XmlTransient
    public Collection<Encuesta> getEncuestaCollection() {
        return encuestaCollection;
    }

    public void setEncuestaCollection(Collection<Encuesta> encuestaCollection) {
        this.encuestaCollection = encuestaCollection;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
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
        hash += (periCodigo != null ? periCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.periCodigo == null && other.periCodigo != null) || (this.periCodigo != null && !this.periCodigo.equals(other.periCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Periodo[ periCodigo=" + periCodigo + " ]";
    }
    
}
