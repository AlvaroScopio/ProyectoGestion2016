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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCursCodigo", query = "SELECT c FROM Curso c WHERE c.cursCodigo = :cursCodigo"),
    @NamedQuery(name = "Curso.findByCursComentario", query = "SELECT c FROM Curso c WHERE c.cursComentario = :cursComentario")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "curs_codigo")
    private Integer cursCodigo;
    @Size(max = 100)
    @Column(name = "curs_comentario")
    private String cursComentario;
    @OneToMany(mappedBy = "cursCodigo")
    private Collection<DocenteMateriaCurso> docenteMateriaCursoCollection;
    @JoinColumn(name = "carr_codigo", referencedColumnName = "carr_codigo")
    @ManyToOne
    private Carrera carrCodigo;
    @JoinColumn(name = "para_codigo", referencedColumnName = "para_codigo")
    @ManyToOne
    private Paralelo paraCodigo;
    @JoinColumn(name = "peri_codigo", referencedColumnName = "peri_codigo")
    @ManyToOne
    private Periodo periCodigo;
    @JoinColumn(name = "seme_codigo", referencedColumnName = "seme_codigo")
    @ManyToOne
    private Semestre semeCodigo;

    public Curso() {
    }

    public Curso(Integer cursCodigo) {
        this.cursCodigo = cursCodigo;
    }

    public Integer getCursCodigo() {
        return cursCodigo;
    }

    public void setCursCodigo(Integer cursCodigo) {
        this.cursCodigo = cursCodigo;
    }

    public String getCursComentario() {
        return cursComentario;
    }

    public void setCursComentario(String cursComentario) {
        this.cursComentario = cursComentario;
    }

    @XmlTransient
    public Collection<DocenteMateriaCurso> getDocenteMateriaCursoCollection() {
        return docenteMateriaCursoCollection;
    }

    public void setDocenteMateriaCursoCollection(Collection<DocenteMateriaCurso> docenteMateriaCursoCollection) {
        this.docenteMateriaCursoCollection = docenteMateriaCursoCollection;
    }

    public Carrera getCarrCodigo() {
        return carrCodigo;
    }

    public void setCarrCodigo(Carrera carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    public Paralelo getParaCodigo() {
        return paraCodigo;
    }

    public void setParaCodigo(Paralelo paraCodigo) {
        this.paraCodigo = paraCodigo;
    }

    public Periodo getPeriCodigo() {
        return periCodigo;
    }

    public void setPeriCodigo(Periodo periCodigo) {
        this.periCodigo = periCodigo;
    }

    public Semestre getSemeCodigo() {
        return semeCodigo;
    }

    public void setSemeCodigo(Semestre semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursCodigo != null ? cursCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.cursCodigo == null && other.cursCodigo != null) || (this.cursCodigo != null && !this.cursCodigo.equals(other.cursCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Curso[ cursCodigo=" + cursCodigo + " ]";
    }
    
}
