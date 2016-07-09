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
@Table(name = "materia_semestre_carrera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MateriaSemestreCarrera.findAll", query = "SELECT m FROM MateriaSemestreCarrera m"),
    @NamedQuery(name = "MateriaSemestreCarrera.findByMascCodigo", query = "SELECT m FROM MateriaSemestreCarrera m WHERE m.mascCodigo = :mascCodigo"),
    @NamedQuery(name = "MateriaSemestreCarrera.findByMascDescripcion", query = "SELECT m FROM MateriaSemestreCarrera m WHERE m.mascDescripcion = :mascDescripcion")})
public class MateriaSemestreCarrera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "masc_codigo")
    private Integer mascCodigo;
    @Size(max = 100)
    @Column(name = "masc_descripcion")
    private String mascDescripcion;
    @JoinColumn(name = "carr_codigo", referencedColumnName = "carr_codigo")
    @ManyToOne
    private Carrera carrCodigo;
    @JoinColumn(name = "mate_codigo", referencedColumnName = "mate_codigo")
    @ManyToOne
    private Materia mateCodigo;
    @JoinColumn(name = "seme_codigo", referencedColumnName = "seme_codigo")
    @ManyToOne
    private Semestre semeCodigo;

    public MateriaSemestreCarrera() {
    }

    public MateriaSemestreCarrera(Integer mascCodigo) {
        this.mascCodigo = mascCodigo;
    }

    public Integer getMascCodigo() {
        return mascCodigo;
    }

    public void setMascCodigo(Integer mascCodigo) {
        this.mascCodigo = mascCodigo;
    }

    public String getMascDescripcion() {
        return mascDescripcion;
    }

    public void setMascDescripcion(String mascDescripcion) {
        this.mascDescripcion = mascDescripcion;
    }

    public Carrera getCarrCodigo() {
        return carrCodigo;
    }

    public void setCarrCodigo(Carrera carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    public Materia getMateCodigo() {
        return mateCodigo;
    }

    public void setMateCodigo(Materia mateCodigo) {
        this.mateCodigo = mateCodigo;
    }

    public Semestre getSemeCodigo() {
        return semeCodigo;
    }

    public void setSemeCodigo(Semestre semeCodigo) {
        this.semeCodigo = semeCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mascCodigo != null ? mascCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MateriaSemestreCarrera)) {
            return false;
        }
        MateriaSemestreCarrera other = (MateriaSemestreCarrera) object;
        if ((this.mascCodigo == null && other.mascCodigo != null) || (this.mascCodigo != null && !this.mascCodigo.equals(other.mascCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MateriaSemestreCarrera[ mascCodigo=" + mascCodigo + " ]";
    }
    
}
