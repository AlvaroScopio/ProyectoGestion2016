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
@Table(name = "tipo_trabajo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoTrabajo.findAll", query = "SELECT t FROM TipoTrabajo t"),
    @NamedQuery(name = "TipoTrabajo.findByTitrCodigo", query = "SELECT t FROM TipoTrabajo t WHERE t.titrCodigo = :titrCodigo"),
    @NamedQuery(name = "TipoTrabajo.findByTitrNombre", query = "SELECT t FROM TipoTrabajo t WHERE t.titrNombre = :titrNombre"),
    @NamedQuery(name = "TipoTrabajo.findByTitrDescripcion", query = "SELECT t FROM TipoTrabajo t WHERE t.titrDescripcion = :titrDescripcion")})
public class TipoTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "titr_codigo")
    private Integer titrCodigo;
    @Size(max = 20)
    @Column(name = "titr_nombre")
    private String titrNombre;
    @Size(max = 100)
    @Column(name = "titr_descripcion")
    private String titrDescripcion;
    @OneToMany(mappedBy = "titrCodigo")
    private Collection<Docente> docenteCollection;

    public TipoTrabajo() {
    }

    public TipoTrabajo(Integer titrCodigo) {
        this.titrCodigo = titrCodigo;
    }

    public Integer getTitrCodigo() {
        return titrCodigo;
    }

    public void setTitrCodigo(Integer titrCodigo) {
        this.titrCodigo = titrCodigo;
    }

    public String getTitrNombre() {
        return titrNombre;
    }

    public void setTitrNombre(String titrNombre) {
        this.titrNombre = titrNombre;
    }

    public String getTitrDescripcion() {
        return titrDescripcion;
    }

    public void setTitrDescripcion(String titrDescripcion) {
        this.titrDescripcion = titrDescripcion;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titrCodigo != null ? titrCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoTrabajo)) {
            return false;
        }
        TipoTrabajo other = (TipoTrabajo) object;
        if ((this.titrCodigo == null && other.titrCodigo != null) || (this.titrCodigo != null && !this.titrCodigo.equals(other.titrCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TipoTrabajo[ titrCodigo=" + titrCodigo + " ]";
    }
    
}
