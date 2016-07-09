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
@Table(name = "docente_materia_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocenteMateriaCurso.findAll", query = "SELECT d FROM DocenteMateriaCurso d"),
    @NamedQuery(name = "DocenteMateriaCurso.findByDomcCodigo", query = "SELECT d FROM DocenteMateriaCurso d WHERE d.domcCodigo = :domcCodigo"),
    @NamedQuery(name = "DocenteMateriaCurso.findByDomcComentario", query = "SELECT d FROM DocenteMateriaCurso d WHERE d.domcComentario = :domcComentario")})
public class DocenteMateriaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "domc_codigo")
    private Integer domcCodigo;
    @Size(max = 100)
    @Column(name = "domc_comentario")
    private String domcComentario;
    @OneToMany(mappedBy = "domcCodigo")
    private Collection<Horario> horarioCollection;
    @JoinColumn(name = "curs_codigo", referencedColumnName = "curs_codigo")
    @ManyToOne
    private Curso cursCodigo;
    @JoinColumn(name = "doce_codigo", referencedColumnName = "doce_codigo")
    @ManyToOne
    private Docente doceCodigo;
    @JoinColumn(name = "mate_codigo", referencedColumnName = "mate_codigo")
    @ManyToOne
    private Materia mateCodigo;

    public DocenteMateriaCurso() {
    }

    public DocenteMateriaCurso(Integer domcCodigo) {
        this.domcCodigo = domcCodigo;
    }

    public Integer getDomcCodigo() {
        return domcCodigo;
    }

    public void setDomcCodigo(Integer domcCodigo) {
        this.domcCodigo = domcCodigo;
    }

    public String getDomcComentario() {
        return domcComentario;
    }

    public void setDomcComentario(String domcComentario) {
        this.domcComentario = domcComentario;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    public Curso getCursCodigo() {
        return cursCodigo;
    }

    public void setCursCodigo(Curso cursCodigo) {
        this.cursCodigo = cursCodigo;
    }

    public Docente getDoceCodigo() {
        return doceCodigo;
    }

    public void setDoceCodigo(Docente doceCodigo) {
        this.doceCodigo = doceCodigo;
    }

    public Materia getMateCodigo() {
        return mateCodigo;
    }

    public void setMateCodigo(Materia mateCodigo) {
        this.mateCodigo = mateCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (domcCodigo != null ? domcCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocenteMateriaCurso)) {
            return false;
        }
        DocenteMateriaCurso other = (DocenteMateriaCurso) object;
        if ((this.domcCodigo == null && other.domcCodigo != null) || (this.domcCodigo != null && !this.domcCodigo.equals(other.domcCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DocenteMateriaCurso[ domcCodigo=" + domcCodigo + " ]";
    }
    
}
