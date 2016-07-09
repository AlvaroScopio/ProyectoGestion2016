/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByHoraCodigo", query = "SELECT h FROM Horario h WHERE h.horaCodigo = :horaCodigo"),
    @NamedQuery(name = "Horario.findByHoraDia", query = "SELECT h FROM Horario h WHERE h.horaDia = :horaDia"),
    @NamedQuery(name = "Horario.findByHoraInicio", query = "SELECT h FROM Horario h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "Horario.findByHoraFin", query = "SELECT h FROM Horario h WHERE h.horaFin = :horaFin")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hora_codigo")
    private Integer horaCodigo;
    @Size(max = 10)
    @Column(name = "hora_dia")
    private String horaDia;
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    @JoinColumn(name = "aula_codigo", referencedColumnName = "aula_codigo")
    @ManyToOne
    private Aula aulaCodigo;
    @JoinColumn(name = "domc_codigo", referencedColumnName = "domc_codigo")
    @ManyToOne
    private DocenteMateriaCurso domcCodigo;

    public Horario() {
    }

    public Horario(Integer horaCodigo) {
        this.horaCodigo = horaCodigo;
    }

    public Integer getHoraCodigo() {
        return horaCodigo;
    }

    public void setHoraCodigo(Integer horaCodigo) {
        this.horaCodigo = horaCodigo;
    }

    public String getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(String horaDia) {
        this.horaDia = horaDia;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Aula getAulaCodigo() {
        return aulaCodigo;
    }

    public void setAulaCodigo(Aula aulaCodigo) {
        this.aulaCodigo = aulaCodigo;
    }

    public DocenteMateriaCurso getDomcCodigo() {
        return domcCodigo;
    }

    public void setDomcCodigo(DocenteMateriaCurso domcCodigo) {
        this.domcCodigo = domcCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horaCodigo != null ? horaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horaCodigo == null && other.horaCodigo != null) || (this.horaCodigo != null && !this.horaCodigo.equals(other.horaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Horario[ horaCodigo=" + horaCodigo + " ]";
    }
    
}
