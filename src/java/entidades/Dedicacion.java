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
@Table(name = "dedicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dedicacion.findAll", query = "SELECT d FROM Dedicacion d"),
    @NamedQuery(name = "Dedicacion.findByDediCodigo", query = "SELECT d FROM Dedicacion d WHERE d.dediCodigo = :dediCodigo"),
    @NamedQuery(name = "Dedicacion.findByDediNombre", query = "SELECT d FROM Dedicacion d WHERE d.dediNombre = :dediNombre"),
    @NamedQuery(name = "Dedicacion.findByDediDescripcion", query = "SELECT d FROM Dedicacion d WHERE d.dediDescripcion = :dediDescripcion")})
public class Dedicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dedi_codigo")
    private Integer dediCodigo;
    @Size(max = 50)
    @Column(name = "dedi_nombre")
    private String dediNombre;
    @Size(max = 100)
    @Column(name = "dedi_descripcion")
    private String dediDescripcion;
    @OneToMany(mappedBy = "dediCodigo")
    private Collection<Docente> docenteCollection;

    public Dedicacion() {
    }

    public Dedicacion(Integer dediCodigo) {
        this.dediCodigo = dediCodigo;
    }

    public Integer getDediCodigo() {
        return dediCodigo;
    }

    public void setDediCodigo(Integer dediCodigo) {
        this.dediCodigo = dediCodigo;
    }

    public String getDediNombre() {
        return dediNombre;
    }

    public void setDediNombre(String dediNombre) {
        this.dediNombre = dediNombre;
    }

    public String getDediDescripcion() {
        return dediDescripcion;
    }

    public void setDediDescripcion(String dediDescripcion) {
        this.dediDescripcion = dediDescripcion;
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
        hash += (dediCodigo != null ? dediCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dedicacion)) {
            return false;
        }
        Dedicacion other = (Dedicacion) object;
        if ((this.dediCodigo == null && other.dediCodigo != null) || (this.dediCodigo != null && !this.dediCodigo.equals(other.dediCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Dedicacion[ dediCodigo=" + dediCodigo + " ]";
    }
    
}
