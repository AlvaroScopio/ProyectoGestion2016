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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByDoceCodigo", query = "SELECT d FROM Docente d WHERE d.doceCodigo = :doceCodigo"),
    @NamedQuery(name = "Docente.findByDoceNombres", query = "SELECT d FROM Docente d WHERE d.doceNombres = :doceNombres"),
    @NamedQuery(name = "Docente.findByDoceApellidos", query = "SELECT d FROM Docente d WHERE d.doceApellidos = :doceApellidos"),
    @NamedQuery(name = "Docente.findByDoceCedula", query = "SELECT d FROM Docente d WHERE d.doceCedula = :doceCedula"),
    @NamedQuery(name = "Docente.findByDoceEmailUce", query = "SELECT d FROM Docente d WHERE d.doceEmailUce = :doceEmailUce"),
    @NamedQuery(name = "Docente.findByDoceEmailPersonal", query = "SELECT d FROM Docente d WHERE d.doceEmailPersonal = :doceEmailPersonal"),
    @NamedQuery(name = "Docente.findByDoceFechaNacimiento", query = "SELECT d FROM Docente d WHERE d.doceFechaNacimiento = :doceFechaNacimiento"),
    @NamedQuery(name = "Docente.findByDoceGenero", query = "SELECT d FROM Docente d WHERE d.doceGenero = :doceGenero"),
    @NamedQuery(name = "Docente.findByDoceTelefono", query = "SELECT d FROM Docente d WHERE d.doceTelefono = :doceTelefono"),
    @NamedQuery(name = "Docente.findByDoceCelular", query = "SELECT d FROM Docente d WHERE d.doceCelular = :doceCelular"),
    @NamedQuery(name = "Docente.findByDoceDireccion", query = "SELECT d FROM Docente d WHERE d.doceDireccion = :doceDireccion")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doce_codigo")
    private Integer doceCodigo;
    @Size(max = 50)
    @Column(name = "doce_nombres")
    private String doceNombres;
    @Size(max = 50)
    @Column(name = "doce_apellidos")
    private String doceApellidos;
    @Size(max = 10)
    @Column(name = "doce_cedula")
    private String doceCedula;
    @Size(max = 50)
    @Column(name = "doce_email_uce")
    private String doceEmailUce;
    @Size(max = 50)
    @Column(name = "doce_email_personal")
    private String doceEmailPersonal;
    @Column(name = "doce_fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date doceFechaNacimiento;
    @Size(max = 10)
    @Column(name = "doce_genero")
    private String doceGenero;
    @Size(max = 10)
    @Column(name = "doce_telefono")
    private String doceTelefono;
    @Size(max = 10)
    @Column(name = "doce_celular")
    private String doceCelular;
    @Size(max = 50)
    @Column(name = "doce_direccion")
    private String doceDireccion;
    @OneToMany(mappedBy = "doceCodigo")
    private Collection<DocenteMateriaCurso> docenteMateriaCursoCollection;
    @OneToMany(mappedBy = "doceCodigo")
    private Collection<Encuesta> encuestaCollection;
    @JoinColumn(name = "dedi_codigo", referencedColumnName = "dedi_codigo")
    @ManyToOne
    private Dedicacion dediCodigo;
    @JoinColumn(name = "titr_codigo", referencedColumnName = "titr_codigo")
    @ManyToOne
    private TipoTrabajo titrCodigo;

    public Docente() {
    }

    public Docente(Integer doceCodigo) {
        this.doceCodigo = doceCodigo;
    }

    public Integer getDoceCodigo() {
        return doceCodigo;
    }

    public void setDoceCodigo(Integer doceCodigo) {
        this.doceCodigo = doceCodigo;
    }

    public String getDoceNombres() {
        return doceNombres;
    }

    public void setDoceNombres(String doceNombres) {
        this.doceNombres = doceNombres;
    }

    public String getDoceApellidos() {
        return doceApellidos;
    }

    public void setDoceApellidos(String doceApellidos) {
        this.doceApellidos = doceApellidos;
    }

    public String getDoceCedula() {
        return doceCedula;
    }

    public void setDoceCedula(String doceCedula) {
        this.doceCedula = doceCedula;
    }

    public String getDoceEmailUce() {
        return doceEmailUce;
    }

    public void setDoceEmailUce(String doceEmailUce) {
        this.doceEmailUce = doceEmailUce;
    }

    public String getDoceEmailPersonal() {
        return doceEmailPersonal;
    }

    public void setDoceEmailPersonal(String doceEmailPersonal) {
        this.doceEmailPersonal = doceEmailPersonal;
    }

    public Date getDoceFechaNacimiento() {
        return doceFechaNacimiento;
    }

    public void setDoceFechaNacimiento(Date doceFechaNacimiento) {
        this.doceFechaNacimiento = doceFechaNacimiento;
    }

    public String getDoceGenero() {
        return doceGenero;
    }

    public void setDoceGenero(String doceGenero) {
        this.doceGenero = doceGenero;
    }

    public String getDoceTelefono() {
        return doceTelefono;
    }

    public void setDoceTelefono(String doceTelefono) {
        this.doceTelefono = doceTelefono;
    }

    public String getDoceCelular() {
        return doceCelular;
    }

    public void setDoceCelular(String doceCelular) {
        this.doceCelular = doceCelular;
    }

    public String getDoceDireccion() {
        return doceDireccion;
    }

    public void setDoceDireccion(String doceDireccion) {
        this.doceDireccion = doceDireccion;
    }

    @XmlTransient
    public Collection<DocenteMateriaCurso> getDocenteMateriaCursoCollection() {
        return docenteMateriaCursoCollection;
    }

    public void setDocenteMateriaCursoCollection(Collection<DocenteMateriaCurso> docenteMateriaCursoCollection) {
        this.docenteMateriaCursoCollection = docenteMateriaCursoCollection;
    }

    @XmlTransient
    public Collection<Encuesta> getEncuestaCollection() {
        return encuestaCollection;
    }

    public void setEncuestaCollection(Collection<Encuesta> encuestaCollection) {
        this.encuestaCollection = encuestaCollection;
    }

    public Dedicacion getDediCodigo() {
        return dediCodigo;
    }

    public void setDediCodigo(Dedicacion dediCodigo) {
        this.dediCodigo = dediCodigo;
    }

    public TipoTrabajo getTitrCodigo() {
        return titrCodigo;
    }

    public void setTitrCodigo(TipoTrabajo titrCodigo) {
        this.titrCodigo = titrCodigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doceCodigo != null ? doceCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.doceCodigo == null && other.doceCodigo != null) || (this.doceCodigo != null && !this.doceCodigo.equals(other.doceCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Docente[ doceCodigo=" + doceCodigo + " ]";
    }
    
}
