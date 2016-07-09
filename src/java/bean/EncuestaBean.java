package bean;

import dao.DocenteDao;
import dao.EstudianteDao;
import dao.MateriaDao;
import dao.PeriodoDao;
import dao.PreinscripcionDao;
import imp.DocenteDaoImp;
import model.Periodo;
import model.Materia;
import imp.EstudianteDaoImp;
import imp.MateriaDaoImp;
import imp.PeriodoDaoImp;
import imp.PreinscripcionDaoImp;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Docente;
import model.Estudiante;
import model.Preinscripcion;

@Named(value = "encuestaBean")
@SessionScoped
public class EncuestaBean implements Serializable{
    
    private Docente docente;
    private List<Materia> listaMaterias;
    private Integer[] materiasSeleccionadas;
    private String cedula;

    public EncuestaBean() {
        //listaMaterias = new ArrayList<>();
        //estudiante = estudiantePorCedula();
    }

     public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
    

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

//    public List<Materia> getListaMaterias() {
//        //estudiantePorCedula();
//        MateriaDao materiaDao = new MateriaDaoImp();
//        int carrCodigo = estudiante.getCarrera().getCarrCodigo();
//        listaMaterias = materiaDao.ListarMateriasPorCarrera(carrCodigo);
//        return listaMaterias;
//    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
    
    public Docente docentePorCedula(){
        DocenteDao docenteDao =  new DocenteDaoImp();
        docente = docenteDao.docentePorCedula(cedula);
        return docente;
    }
    
    public String encuesta(){
        DocenteDao docenteDao =  new DocenteDaoImp();
        docente = docenteDao.docentePorCedula(cedula);
        if(docente != null){
            return "/encuesta/encuesta2?faces-redirect=true";
        }
        docente = new Docente();
        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe un Docente con ese número de cedula"));
        return "/encuesta/encuesta";
    }

    public Integer[] getMateriasSeleccionadas() {
        return materiasSeleccionadas;
    }

    public void setMateriasSeleccionadas(Integer[] materiasSeleccionadas) {
        this.materiasSeleccionadas = materiasSeleccionadas;
    }
       
    public String realizarEncuesta(){
        
       
        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Realizado", "Preinscripcion realizada corectamente"));
        return "/encuesta/encuesta?faces-redirect=true";
        
    }

   
}
