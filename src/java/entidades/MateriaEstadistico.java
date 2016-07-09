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
@Table(name = "materia_estadistico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaEstadistico.findAll", query = "SELECT m FROM MateriaEstadistico m"),
    @NamedQuery(name = "MateriaEstadistico.findByMaesCodigo", query = "SELECT m FROM MateriaEstadistico m WHERE m.maesCodigo = :maesCodigo"),
    @NamedQuery(name = "MateriaEstadistico.findByMaesDescripcion", query = "SELECT m FROM MateriaEstadistico m WHERE m.maesDescripcion = :maesDescripcion")})
public class MateriaEstadistico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maes_codigo")
    private Integer maesCodigo;
    @Size(max = 100)
    @Column(name = "maes_descripcion")
    private String maesDescripcion;
    @JoinColumn(name = "mate_codigo", referencedColumnName = "mate_codigo")
    @ManyToOne
    private Materia mateCodigo;
    @JoinColumn(name = "peri_codigo", referencedColumnName = "peri_codigo")
    @ManyToOne
    private Periodo periCodigo;

    public MateriaEstadistico() {
    }

    public MateriaEstadistico(Integer maesCodigo) {
        this.maesCodigo = maesCodigo;
    }

    public Integer getMaesCodigo() {
        return maesCodigo;
    }

    public void setMaesCodigo(Integer maesCodigo) {
        this.maesCodigo = maesCodigo;
    }

    public String getMaesDescripcion() {
        return maesDescripcion;
    }

    public void setMaesDescripcion(String maesDescripcion) {
        this.maesDescripcion = maesDescripcion;
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
        hash += (maesCodigo != null ? maesCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaEstadistico)) {
            return false;
        }
        MateriaEstadistico other = (MateriaEstadistico) object;
        if ((this.maesCodigo == null && other.maesCodigo != null) || (this.maesCodigo != null && !this.maesCodigo.equals(other.maesCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MateriaEstadistico[ maesCodigo=" + maesCodigo + " ]";
    }
    
}
