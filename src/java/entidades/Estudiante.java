/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Darwin
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e"),
    @NamedQuery(name = "Estudiante.findByEstuCodigo", query = "SELECT e FROM Estudiante e WHERE e.estuCodigo = :estuCodigo"),
    @NamedQuery(name = "Estudiante.findByEstuNombres", query = "SELECT e FROM Estudiante e WHERE e.estuNombres = :estuNombres"),
    @NamedQuery(name = "Estudiante.findByEstuApellidos", query = "SELECT e FROM Estudiante e WHERE e.estuApellidos = :estuApellidos"),
    @NamedQuery(name = "Estudiante.findByEstuCedula", query = "SELECT e FROM Estudiante e WHERE e.estuCedula = :estuCedula"),
    @NamedQuery(name = "Estudiante.findByEstuEmailUce", query = "SELECT e FROM Estudiante e WHERE e.estuEmailUce = :estuEmailUce"),
    @NamedQuery(name = "Estudiante.findByEstuEmailPersonal", query = "SELECT e FROM Estudiante e WHERE e.estuEmailPersonal = :estuEmailPersonal"),
    @NamedQuery(name = "Estudiante.findByEstuFechaNacimiento", query = "SELECT e FROM Estudiante e WHERE e.estuFechaNacimiento = :estuFechaNacimiento"),
    @NamedQuery(name = "Estudiante.findByEstuGenereo", query = "SELECT e FROM Estudiante e WHERE e.estuGenereo = :estuGenereo"),
    @NamedQuery(name = "Estudiante.findByEstuTelefono", query = "SELECT e FROM Estudiante e WHERE e.estuTelefono = :estuTelefono"),
    @NamedQuery(name = "Estudiante.findByEstuCelular", query = "SELECT e FROM Estudiante e WHERE e.estuCelular = :estuCelular"),
    @NamedQuery(name = "Estudiante.findByEstuDireccion", query = "SELECT e FROM Estudiante e WHERE e.estuDireccion = :estuDireccion")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "estu_codigo")
    private Integer estuCodigo;
    @Size(max = 50)
    @Column(name = "estu_nombres")
    private String estuNombres;
    @Size(max = 50)
    @Column(name = "estu_apellidos")
    private String estuApellidos;
    @Size(max = 10)
    @Column(name = "estu_cedula")
    private String estuCedula;
    @Size(max = 50)
    @Column(name = "estu_email_uce")
    private String estuEmailUce;
    @Size(max = 50)
    @Column(name = "estu_email_personal")
    private String estuEmailPersonal;
    @Column(name = "estu_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date estuFechaNacimiento;
    @Size(max = 10)
    @Column(name = "estu_genereo")
    private String estuGenereo;
    @Size(max = 10)
    @Column(name = "estu_telefono")
    private String estuTelefono;
    @Size(max = 10)
    @Column(name = "estu_celular")
    private String estuCelular;
    @Size(max = 50)
    @Column(name = "estu_direccion")
    private String estuDireccion;
    @JoinColumn(name = "carr_codigo", referencedColumnName = "carr_codigo")
    @ManyToOne
    private Carrera carrCodigo;
    @OneToMany(mappedBy = "estuCodigo")
    private Collection<Preinscripcion> preinscripcionCollection;

    public Estudiante() {
    }

    public Estudiante(Integer estuCodigo) {
        this.estuCodigo = estuCodigo;
    }

    public Integer getEstuCodigo() {
        return estuCodigo;
    }

    public void setEstuCodigo(Integer estuCodigo) {
        this.estuCodigo = estuCodigo;
    }

    public String getEstuNombres() {
        return estuNombres;
    }

    public void setEstuNombres(String estuNombres) {
        this.estuNombres = estuNombres;
    }

    public String getEstuApellidos() {
        return estuApellidos;
    }

    public void setEstuApellidos(String estuApellidos) {
        this.estuApellidos = estuApellidos;
    }

    public String getEstuCedula() {
        return estuCedula;
    }

    public void setEstuCedula(String estuCedula) {
        this.estuCedula = estuCedula;
    }

    public String getEstuEmailUce() {
        return estuEmailUce;
    }

    public void setEstuEmailUce(String estuEmailUce) {
        this.estuEmailUce = estuEmailUce;
    }

    public String getEstuEmailPersonal() {
        return estuEmailPersonal;
    }

    public void setEstuEmailPersonal(String estuEmailPersonal) {
        this.estuEmailPersonal = estuEmailPersonal;
    }

    public Date getEstuFechaNacimiento() {
        return estuFechaNacimiento;
    }

    public void setEstuFechaNacimiento(Date estuFechaNacimiento) {
        this.estuFechaNacimiento = estuFechaNacimiento;
    }

    public String getEstuGenereo() {
        return estuGenereo;
    }

    public void setEstuGenereo(String estuGenereo) {
        this.estuGenereo = estuGenereo;
    }

    public String getEstuTelefono() {
        return estuTelefono;
    }

    public void setEstuTelefono(String estuTelefono) {
        this.estuTelefono = estuTelefono;
    }

    public String getEstuCelular() {
        return estuCelular;
    }

    public void setEstuCelular(String estuCelular) {
        this.estuCelular = estuCelular;
    }

    public String getEstuDireccion() {
        return estuDireccion;
    }

    public void setEstuDireccion(String estuDireccion) {
        this.estuDireccion = estuDireccion;
    }

    public Carrera getCarrCodigo() {
        return carrCodigo;
    }

    public void setCarrCodigo(Carrera carrCodigo) {
        this.carrCodigo = carrCodigo;
    }

    @XmlTransient
    public Collection<Preinscripcion> getPreinscripcionCollection() {
        return preinscripcionCollection;
    }

    public void setPreinscripcionCollection(Collection<Preinscripcion> preinscripcionCollection) {
        this.preinscripcionCollection = preinscripcionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estuCodigo != null ? estuCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.estuCodigo == null && other.estuCodigo != null) || (this.estuCodigo != null && !this.estuCodigo.equals(other.estuCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Estudiante[ estuCodigo=" + estuCodigo + " ]";
    }
    
}
