package model;
// Generated 01-feb-2016 18:02:31 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Periodo generated by hbm2java
 */
public class Periodo  implements java.io.Serializable {


     private int periCodigo;
     private String periNombre;
     private Integer periVigencia;
     private String periDescripcion;
     private Set<Encuesta> encuestas = new HashSet<Encuesta>(0);
     private Set<Preinscripcion> preinscripcions = new HashSet<Preinscripcion>(0);
     private Set<Curso> cursos = new HashSet<Curso>(0);
     private Set<MateriaEstadistico> materiaEstadisticos = new HashSet<MateriaEstadistico>(0);

    public Periodo() {
    }

	
    public Periodo(int periCodigo) {
        this.periCodigo = periCodigo;
    }
    public Periodo(int periCodigo, String periNombre, Integer periVigencia, String periDescripcion, Set<Encuesta> encuestas, Set<Preinscripcion> preinscripcions, Set<Curso> cursos, Set<MateriaEstadistico> materiaEstadisticos) {
       this.periCodigo = periCodigo;
       this.periNombre = periNombre;
       this.periVigencia = periVigencia;
       this.periDescripcion = periDescripcion;
       this.encuestas = encuestas;
       this.preinscripcions = preinscripcions;
       this.cursos = cursos;
       this.materiaEstadisticos = materiaEstadisticos;
    }
   
    public int getPeriCodigo() {
        return this.periCodigo;
    }
    
    public void setPeriCodigo(int periCodigo) {
        this.periCodigo = periCodigo;
    }
    public String getPeriNombre() {
        return this.periNombre;
    }
    
    public void setPeriNombre(String periNombre) {
        this.periNombre = periNombre;
    }
    public Integer getPeriVigencia() {
        return this.periVigencia;
    }
    
    public void setPeriVigencia(Integer periVigencia) {
        this.periVigencia = periVigencia;
    }
    public String getPeriDescripcion() {
        return this.periDescripcion;
    }
    
    public void setPeriDescripcion(String periDescripcion) {
        this.periDescripcion = periDescripcion;
    }
    public Set<Encuesta> getEncuestas() {
        return this.encuestas;
    }
    
    public void setEncuestas(Set<Encuesta> encuestas) {
        this.encuestas = encuestas;
    }
    public Set<Preinscripcion> getPreinscripcions() {
        return this.preinscripcions;
    }
    
    public void setPreinscripcions(Set<Preinscripcion> preinscripcions) {
        this.preinscripcions = preinscripcions;
    }
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }
    public Set<MateriaEstadistico> getMateriaEstadisticos() {
        return this.materiaEstadisticos;
    }
    
    public void setMateriaEstadisticos(Set<MateriaEstadistico> materiaEstadisticos) {
        this.materiaEstadisticos = materiaEstadisticos;
    }




}


