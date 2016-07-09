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
@Table(name = "edificio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Edificio.findAll", query = "SELECT e FROM Edificio e"),
    @NamedQuery(name = "Edificio.findByEdifCodigo", query = "SELECT e FROM Edificio e WHERE e.edifCodigo = :edifCodigo"),
    @NamedQuery(name = "Edificio.findByEdifNombre", query = "SELECT e FROM Edificio e WHERE e.edifNombre = :edifNombre"),
    @NamedQuery(name = "Edificio.findByEdifDescripcion", query = "SELECT e FROM Edificio e WHERE e.edifDescripcion = :edifDescripcion")})
public class Edificio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "edif_codigo")
    private Integer edifCodigo;
    @Size(max = 30)
    @Column(name = "edif_nombre")
    private String edifNombre;
    @Size(max = 100)
    @Column(name = "edif_descripcion")
    private String edifDescripcion;
    @OneToMany(mappedBy = "edifCodigo")
    private Collection<Aula> aulaCollection;

    public Edificio() {
    }

    public Edificio(Integer edifCodigo) {
        this.edifCodigo = edifCodigo;
    }

    public Integer getEdifCodigo() {
        return edifCodigo;
    }

    public void setEdifCodigo(Integer edifCodigo) {
        this.edifCodigo = edifCodigo;
    }

    public String getEdifNombre() {
        return edifNombre;
    }

    public void setEdifNombre(String edifNombre) {
        this.edifNombre = edifNombre;
    }

    public String getEdifDescripcion() {
        return edifDescripcion;
    }

    public void setEdifDescripcion(String edifDescripcion) {
        this.edifDescripcion = edifDescripcion;
    }

    @XmlTransient
    public Collection<Aula> getAulaCollection() {
        return aulaCollection;
    }

    public void setAulaCollection(Collection<Aula> aulaCollection) {
        this.aulaCollection = aulaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (edifCodigo != null ? edifCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Edificio)) {
            return false;
        }
        Edificio other = (Edificio) object;
        if ((this.edifCodigo == null && other.edifCodigo != null) || (this.edifCodigo != null && !this.edifCodigo.equals(other.edifCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Edificio[ edifCodigo=" + edifCodigo + " ]";
    }
    
}
