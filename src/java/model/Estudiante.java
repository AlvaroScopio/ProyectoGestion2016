package model;
// Generated 01-feb-2016 18:02:31 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Estudiante generated by hbm2java
 */
public class Estudiante  implements java.io.Serializable {


     private int estuCodigo;
     private Carrera carrera;
     private String estuNombres;
     private String estuApellidos;
     private String estuCedula;
     private String estuEmailUce;
     private String estuEmailPersonal;
     private Date estuFechaNacimiento;
     private String estuGenereo;
     private String estuTelefono;
     private String estuCelular;
     private String estuDireccion;
     private Set<Preinscripcion> preinscripcions = new HashSet<Preinscripcion>(0);

    public Estudiante() {
    }

	
    public Estudiante(int estuCodigo) {
        this.estuCodigo = estuCodigo;
    }
    public Estudiante(int estuCodigo, Carrera carrera, String estuNombres, String estuApellidos, String estuCedula, String estuEmailUce, String estuEmailPersonal, Date estuFechaNacimiento, String estuGenereo, String estuTelefono, String estuCelular, String estuDireccion, Set<Preinscripcion> preinscripcions) {
       this.estuCodigo = estuCodigo;
       this.carrera = carrera;
       this.estuNombres = estuNombres;
       this.estuApellidos = estuApellidos;
       this.estuCedula = estuCedula;
       this.estuEmailUce = estuEmailUce;
       this.estuEmailPersonal = estuEmailPersonal;
       this.estuFechaNacimiento = estuFechaNacimiento;
       this.estuGenereo = estuGenereo;
       this.estuTelefono = estuTelefono;
       this.estuCelular = estuCelular;
       this.estuDireccion = estuDireccion;
       this.preinscripcions = preinscripcions;
    }
   
    public int getEstuCodigo() {
        return this.estuCodigo;
    }
    
    public void setEstuCodigo(int estuCodigo) {
        this.estuCodigo = estuCodigo;
    }
    public Carrera getCarrera() {
        return this.carrera;
    }
    
    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    public String getEstuNombres() {
        return this.estuNombres;
    }
    
    public void setEstuNombres(String estuNombres) {
        this.estuNombres = estuNombres;
    }
    public String getEstuApellidos() {
        return this.estuApellidos;
    }
    
    public void setEstuApellidos(String estuApellidos) {
        this.estuApellidos = estuApellidos;
    }
    public String getEstuCedula() {
        return this.estuCedula;
    }
    
    public void setEstuCedula(String estuCedula) {
        this.estuCedula = estuCedula;
    }
    public String getEstuEmailUce() {
        return this.estuEmailUce;
    }
    
    public void setEstuEmailUce(String estuEmailUce) {
        this.estuEmailUce = estuEmailUce;
    }
    public String getEstuEmailPersonal() {
        return this.estuEmailPersonal;
    }
    
    public void setEstuEmailPersonal(String estuEmailPersonal) {
        this.estuEmailPersonal = estuEmailPersonal;
    }
    public Date getEstuFechaNacimiento() {
        return this.estuFechaNacimiento;
    }
    
    public void setEstuFechaNacimiento(Date estuFechaNacimiento) {
        this.estuFechaNacimiento = estuFechaNacimiento;
    }
    public String getEstuGenereo() {
        return this.estuGenereo;
    }
    
    public void setEstuGenereo(String estuGenereo) {
        this.estuGenereo = estuGenereo;
    }
    public String getEstuTelefono() {
        return this.estuTelefono;
    }
    
    public void setEstuTelefono(String estuTelefono) {
        this.estuTelefono = estuTelefono;
    }
    public String getEstuCelular() {
        return this.estuCelular;
    }
    
    public void setEstuCelular(String estuCelular) {
        this.estuCelular = estuCelular;
    }
    public String getEstuDireccion() {
        return this.estuDireccion;
    }
    
    public void setEstuDireccion(String estuDireccion) {
        this.estuDireccion = estuDireccion;
    }
    public Set<Preinscripcion> getPreinscripcions() {
        return this.preinscripcions;
    }
    
    public void setPreinscripcions(Set<Preinscripcion> preinscripcions) {
        this.preinscripcions = preinscripcions;
    }




}

