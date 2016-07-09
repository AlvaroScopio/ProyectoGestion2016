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
@Table(name = "encuesta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encuesta.findAll", query = "SELECT e FROM Encuesta e"),
    @NamedQuery(name = "Encuesta.findByEncuCodigo", query = "SELECT e FROM Encuesta e WHERE e.encuCodigo = :encuCodigo"),
    @NamedQuery(name = "Encuesta.findByEncuComentario", query = "SELECT e FROM Encuesta e WHERE e.encuComentario = :encuComentario")})
public class Encuesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "encu_codigo")
    private Integer encuCodigo;
    @Size(max = 200)
    @Column(name = "encu_comentario")
    private String encuComentario;
    @OneToMany(mappedBy = "encuCodigo")
    private Collection<DisponibilidadMateria> disponibilidadMateriaCollection;
    @OneToMany(mappedBy = "encuCodigo")
    private Collection<DisponibilidadHoras> disponibilidadHorasCollection;
    @JoinColumn(name = "doce_codigo", referencedColumnName = "doce_codigo")
    @ManyToOne
    private Docente doceCodigo;
    @JoinColumn(name = "peri_codigo", referencedColumnName = "peri_codigo")
    @ManyToOne
    private Periodo periCodigo;

    public Encuesta() {
    }

    public Encuesta(Integer encuCodigo) {
        this.encuCodigo = encuCodigo;
    }

    public Integer getEncuCodigo() {
        return encuCodigo;
    }

    public void setEncuCodigo(Integer encuCodigo) {
        this.encuCodigo = encuCodigo;
    }

    public String getEncuComentario() {
        return encuComentario;
    }

    public void setEncuComentario(String encuComentario) {
        this.encuComentario = encuComentario;
    }

    @XmlTransient
    public Collection<DisponibilidadMateria> getDisponibilidadMateriaCollection() {
        return disponibilidadMateriaCollection;
    }

    public void setDisponibilidadMateriaCollection(Collection<DisponibilidadMateria> disponibilidadMateriaCollection) {
        this.disponibilidadMateriaCollection = disponibilidadMateriaCollection;
    }

    @XmlTransient
    public Collection<DisponibilidadHoras> getDisponibilidadHorasCollection() {
        return disponibilidadHorasCollection;
    }

    public void setDisponibilidadHorasCollection(Collection<DisponibilidadHoras> disponibilidadHorasCollection) {
        this.disponibilidadHorasCollection = disponibilidadHorasCollection;
    }

    public Docente getDoceCodigo() {
        return doceCodigo;
    }

    public void setDoceCodigo(Docente doceCodigo) {
        this.doceCodigo = doceCodigo;
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
        hash += (encuCodigo != null ? encuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encuesta)) {
            return false;
        }
        Encuesta other = (Encuesta) object;
        if ((this.encuCodigo == null && other.encuCodigo != null) || (this.encuCodigo != null && !this.encuCodigo.equals(other.encuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Encuesta[ encuCodigo=" + encuCodigo + " ]";
    }
    
}
