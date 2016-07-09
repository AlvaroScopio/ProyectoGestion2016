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
@Table(name = "preinscripcion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preinscripcion.findAll", query = "SELECT p FROM Preinscripcion p"),
    @NamedQuery(name = "Preinscripcion.findByPreiCodigo", query = "SELECT p FROM Preinscripcion p WHERE p.preiCodigo = :preiCodigo")})
public class Preinscripcion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prei_codigo")
    private Integer preiCodigo;
    @JoinColumn(name = "estu_codigo", referencedColumnName = "estu_codigo")
    @ManyToOne
    private Estudiante estuCodigo;
    @JoinColumn(name = "mate_codigo", referencedColumnName = "mate_codigo")
    @ManyToOne
    private Materia mateCodigo;
    @JoinColumn(name = "peri_codigo", referencedColumnName = "peri_codigo")
    @ManyToOne
    private Periodo periCodigo;

    public Preinscripcion() {
    }

    public Preinscripcion(Integer preiCodigo) {
        this.preiCodigo = preiCodigo;
    }

    public Integer getPreiCodigo() {
        return preiCodigo;
    }

    public void setPreiCodigo(Integer preiCodigo) {
        this.preiCodigo = preiCodigo;
    }

    public Estudiante getEstuCodigo() {
        return estuCodigo;
    }

    public void setEstuCodigo(Estudiante estuCodigo) {
        this.estuCodigo = estuCodigo;
    }

    public Materia getMateCodigo() {
        return mateCodigo;
    }

    public void setMateCodigo(Materia mateCodigo) {
        this.mateCodigo = mateCodigo;
    }

    public Periodo getPeriCodigo() {
        return periCodigo;
    }

    public void setPeriCodigo(Periodo periCodigo) {
        this.periCodigo = periCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (preiCodigo != null ? preiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preinscripcion)) {
            return false;
        }
        Preinscripcion other = (Preinscripcion) object;
        if ((this.preiCodigo == null && other.preiCodigo != null) || (this.preiCodigo != null && !this.preiCodigo.equals(other.preiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Preinscripcion[ preiCodigo=" + preiCodigo + " ]";
    }
    
}
