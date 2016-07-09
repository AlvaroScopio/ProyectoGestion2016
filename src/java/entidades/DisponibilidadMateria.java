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
@Table(name = "disponibilidad_materia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadMateria.findAll", query = "SELECT d FROM DisponibilidadMateria d"),
    @NamedQuery(name = "DisponibilidadMateria.findByDimaCodigo", query = "SELECT d FROM DisponibilidadMateria d WHERE d.dimaCodigo = :dimaCodigo")})
public class DisponibilidadMateria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dima_codigo")
    private Integer dimaCodigo;
    @JoinColumn(name = "encu_codigo", referencedColumnName = "encu_codigo")
    @ManyToOne
    private Encuesta encuCodigo;
    @JoinColumn(name = "mate_codigo", referencedColumnName = "mate_codigo")
    @ManyToOne
    private Materia mateCodigo;

    public DisponibilidadMateria() {
    }

    public DisponibilidadMateria(Integer dimaCodigo) {
        this.dimaCodigo = dimaCodigo;
    }

    public Integer getDimaCodigo() {
        return dimaCodigo;
    }

    public void setDimaCodigo(Integer dimaCodigo) {
        this.dimaCodigo = dimaCodigo;
    }

    public Encuesta getEncuCodigo() {
        return encuCodigo;
    }

    public void setEncuCodigo(Encuesta encuCodigo) {
        this.encuCodigo = encuCodigo;
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
        hash += (dimaCodigo != null ? dimaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadMateria)) {
            return false;
        }
        DisponibilidadMateria other = (DisponibilidadMateria) object;
        if ((this.dimaCodigo == null && other.dimaCodigo != null) || (this.dimaCodigo != null && !this.dimaCodigo.equals(other.dimaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DisponibilidadMateria[ dimaCodigo=" + dimaCodigo + " ]";
    }
    
}
