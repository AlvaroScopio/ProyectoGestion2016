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
@Table(name = "disponibilidad_horas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisponibilidadHoras.findAll", query = "SELECT d FROM DisponibilidadHoras d"),
    @NamedQuery(name = "DisponibilidadHoras.findByDihoCodigo", query = "SELECT d FROM DisponibilidadHoras d WHERE d.dihoCodigo = :dihoCodigo"),
    @NamedQuery(name = "DisponibilidadHoras.findByDihoDia", query = "SELECT d FROM DisponibilidadHoras d WHERE d.dihoDia = :dihoDia"),
    @NamedQuery(name = "DisponibilidadHoras.findByDihoHoraInicio", query = "SELECT d FROM DisponibilidadHoras d WHERE d.dihoHoraInicio = :dihoHoraInicio"),
    @NamedQuery(name = "DisponibilidadHoras.findByDihoHoraFin", query = "SELECT d FROM DisponibilidadHoras d WHERE d.dihoHoraFin = :dihoHoraFin")})
public class DisponibilidadHoras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diho_codigo")
    private Integer dihoCodigo;
    @Size(max = 10)
    @Column(name = "diho_dia")
    private String dihoDia;
    @Column(name = "diho_hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date dihoHoraInicio;
    @Column(name = "diho_hora_fin")
    @Temporal(TemporalType.TIME)
    private Date dihoHoraFin;
    @JoinColumn(name = "encu_codigo", referencedColumnName = "encu_codigo")
    @ManyToOne
    private Encuesta encuCodigo;

    public DisponibilidadHoras() {
    }

    public DisponibilidadHoras(Integer dihoCodigo) {
        this.dihoCodigo = dihoCodigo;
    }

    public Integer getDihoCodigo() {
        return dihoCodigo;
    }

    public void setDihoCodigo(Integer dihoCodigo) {
        this.dihoCodigo = dihoCodigo;
    }

    public String getDihoDia() {
        return dihoDia;
    }

    public void setDihoDia(String dihoDia) {
        this.dihoDia = dihoDia;
    }

    public Date getDihoHoraInicio() {
        return dihoHoraInicio;
    }

    public void setDihoHoraInicio(Date dihoHoraInicio) {
        this.dihoHoraInicio = dihoHoraInicio;
    }

    public Date getDihoHoraFin() {
        return dihoHoraFin;
    }

    public void setDihoHoraFin(Date dihoHoraFin) {
        this.dihoHoraFin = dihoHoraFin;
    }

    public Encuesta getEncuCodigo() {
        return encuCodigo;
    }

    public void setEncuCodigo(Encuesta encuCodigo) {
        this.encuCodigo = encuCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dihoCodigo != null ? dihoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisponibilidadHoras)) {
            return false;
        }
        DisponibilidadHoras other = (DisponibilidadHoras) object;
        if ((this.dihoCodigo == null && other.dihoCodigo != null) || (this.dihoCodigo != null && !this.dihoCodigo.equals(other.dihoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.DisponibilidadHoras[ dihoCodigo=" + dihoCodigo + " ]";
    }
    
}
