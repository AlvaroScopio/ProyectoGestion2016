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
@Table(name = "tipo_aula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoAula.findAll", query = "SELECT t FROM TipoAula t"),
    @NamedQuery(name = "TipoAula.findByTiauCodigo", query = "SELECT t FROM TipoAula t WHERE t.tiauCodigo = :tiauCodigo"),
    @NamedQuery(name = "TipoAula.findByTiauNombre", query = "SELECT t FROM TipoAula t WHERE t.tiauNombre = :tiauNombre"),
    @NamedQuery(name = "TipoAula.findByTiauDescripcion", query = "SELECT t FROM TipoAula t WHERE t.tiauDescripcion = :tiauDescripcion")})
public class TipoAula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tiau_codigo")
    private Integer tiauCodigo;
    @Size(max = 20)
    @Column(name = "tiau_nombre")
    private String tiauNombre;
    @Size(max = 50)
    @Column(name = "tiau_descripcion")
    private String tiauDescripcion;
    @OneToMany(mappedBy = "tiauCodigo")
    private Collection<Aula> aulaCollection;

    public TipoAula() {
    }

    public TipoAula(Integer tiauCodigo) {
        this.tiauCodigo = tiauCodigo;
    }

    public Integer getTiauCodigo() {
        return tiauCodigo;
    }

    public void setTiauCodigo(Integer tiauCodigo) {
        this.tiauCodigo = tiauCodigo;
    }

    public String getTiauNombre() {
        return tiauNombre;
    }

    public void setTiauNombre(String tiauNombre) {
        this.tiauNombre = tiauNombre;
    }

    public String getTiauDescripcion() {
        return tiauDescripcion;
    }

    public void setTiauDescripcion(String tiauDescripcion) {
        this.tiauDescripcion = tiauDescripcion;
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
        hash += (tiauCodigo != null ? tiauCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAula)) {
            return false;
        }
        TipoAula other = (TipoAula) object;
        if ((this.tiauCodigo == null && other.tiauCodigo != null) || (this.tiauCodigo != null && !this.tiauCodigo.equals(other.tiauCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoAula[ tiauCodigo=" + tiauCodigo + " ]";
    }
    
}
