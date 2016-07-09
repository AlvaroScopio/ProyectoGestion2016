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
@Table(name = "aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aula.findAll", query = "SELECT a FROM Aula a"),
    @NamedQuery(name = "Aula.findByAulaCodigo", query = "SELECT a FROM Aula a WHERE a.aulaCodigo = :aulaCodigo"),
    @NamedQuery(name = "Aula.findByAulaNombre", query = "SELECT a FROM Aula a WHERE a.aulaNombre = :aulaNombre"),
    @NamedQuery(name = "Aula.findByAulaCapacidad", query = "SELECT a FROM Aula a WHERE a.aulaCapacidad = :aulaCapacidad"),
    @NamedQuery(name = "Aula.findByAulaDescripcion", query = "SELECT a FROM Aula a WHERE a.aulaDescripcion = :aulaDescripcion")})
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aula_codigo")
    private Integer aulaCodigo;
    @Size(max = 20)
    @Column(name = "aula_nombre")
    private String aulaNombre;
    @Column(name = "aula_capacidad")
    private Integer aulaCapacidad;
    @Size(max = 100)
    @Column(name = "aula_descripcion")
    private String aulaDescripcion;
    @JoinColumn(name = "carr_codigo", referencedColumnName = "carr_codigo")
    @ManyToOne
    private Carrera carrCodigo;
    @JoinColumn(name = "edif_codigo", referencedColumnName = "edif_codigo")
    @ManyToOne
    private Edificio edifCodigo;
    @JoinColumn(name = "tiau_codigo", referencedColumnName = "tiau_codigo")
    @ManyToOne
    private TipoAula tiauCodigo;
    @OneToMany(mappedBy = "aulaCodigo")
    private Collection<Horario> horarioCollection;

    public Aula() {
    }

    public Aula(Integer aulaCodigo) {
        this.aulaCodigo = aulaCodigo;
    }

    public Integer getAulaCodigo() {
        return aulaCodigo;
    }

    public void setAulaCodigo(Integer aulaCodigo) {
        this.aulaCodigo = aulaCodigo;
    }

    public String getAulaNombre() {
        return aulaNombre;
    }

    public void setAulaNombre(String aulaNombre) {
        this.aulaNombre = aulaNombre;
    }

    public Integer getAulaCapacidad() {
        return aulaCapacidad;
    }

    public void setAulaCapacidad(Integer aulaCapacidad) {
        this.aulaCapacidad = aulaCapacidad;
    }

    public String getAulaDescripcion() {
        return aulaDescripcion;
    }

    public void setAulaDescripcion(String aulaDescripcion) {
        this.aulaDescripcion = aulaDescripcion;
    }

    public Carrera getCarrCodigo() {
        return carrCodigo;
    }

    public void setCarrCodigo(Carrera carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    public Edificio getEdifCodigo() {
        return edifCodigo;
    }

    public void setEdifCodigo(Edificio edifCodigo) {
        this.edifCodigo = edifCodigo;
    }

    public TipoAula getTiauCodigo() {
        return tiauCodigo;
    }

    public void setTiauCodigo(TipoAula tiauCodigo) {
        this.tiauCodigo = tiauCodigo;
    }

    @XmlTransient
    public Collection<Horario> getHorarioCollection() {
        return horarioCollection;
    }

    public void setHorarioCollection(Collection<Horario> horarioCollection) {
        this.horarioCollection = horarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aulaCodigo != null ? aulaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aula)) {
            return false;
        }
        Aula other = (Aula) object;
        if ((this.aulaCodigo == null && other.aulaCodigo != null) || (this.aulaCodigo != null && !this.aulaCodigo.equals(other.aulaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Aula[ aulaCodigo=" + aulaCodigo + " ]";
    }
    
}
