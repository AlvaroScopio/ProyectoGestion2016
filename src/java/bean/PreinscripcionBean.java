package bean;

import dao.EstudianteDao;
import dao.MateriaDao;
import dao.PeriodoDao;
import dao.PreinscripcionDao;
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
import model.Estudiante;
import model.Preinscripcion;

@Named(value = "preinscripcionBean")
@SessionScoped
public class PreinscripcionBean implements Serializable {

    private Estudiante estudiante;
    private List<Materia> listaMaterias;
    private Integer[] materiasSeleccionadas;
    private String cedula;

    public PreinscripcionBean() {
        //listaMaterias = new ArrayList<>();
        //estudiante = estudiantePorCedula();
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<Materia> getListaMaterias() {
        //estudiantePorCedula();
        MateriaDao materiaDao = new MateriaDaoImp();
        int carrCodigo = estudiante.getCarrera().getCarrCodigo();
        listaMaterias = materiaDao.ListarMateriasPorCarrera(carrCodigo);
        return listaMaterias;
    }

    public void setListaMaterias(List<Materia> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public Estudiante estudiantePorCedula() {
        EstudianteDao estudianteDao = new EstudianteDaoImp();
        estudiante = estudianteDao.estudiantePorCedula(cedula);
        return estudiante;
    }

    public String preinscripcion() {
        
        Periodo periodo;
        boolean p;

        EstudianteDao estudianteDao = new EstudianteDaoImp();
        PreinscripcionDao preinscripcionDao = new PreinscripcionDaoImp();
        PeriodoDao periodoDao = new PeriodoDaoImp();

        estudiante = estudianteDao.estudiantePorCedula(cedula);

        if (estudiante != null) {

            periodo = periodoDao.periodoVigente();
            int periCodigo = periodo.getPeriCodigo();
            int estuCodigo = estudiante.getEstuCodigo();
            p = preinscripcionDao.validaPreinscripcion(estuCodigo, periCodigo);

            if (p == true) {
                return "/preinscripcion/preinscripcion2?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ya tiene registrado una preinscripcion en este periodo"));
                return "/preinscripcion/preinscripcion";
            }
        }
        estudiante = new Estudiante();
        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe un estudiante con ese número de cedula"));
        return "/preinscripcion/preinscripcion";

    }
    
    public String preinscripcion2() {
        
        Periodo periodo;
        boolean p;

        EstudianteDao estudianteDao = new EstudianteDaoImp();
        PreinscripcionDao preinscripcionDao = new PreinscripcionDaoImp();
        PeriodoDao periodoDao = new PeriodoDaoImp();

        estudiante = estudianteDao.estudiantePorCedula(cedula);

        if (estudiante != null) {

            periodo = periodoDao.periodoVigente();
            int periCodigo = periodo.getPeriCodigo();
            int estuCodigo = estudiante.getEstuCodigo();
            p = preinscripcionDao.validaPreinscripcion(estuCodigo, periCodigo);

            if (p == true) {
                return "/preinscripcion/preinscripcion4?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Ya tiene registrado una preinscripcion en este periodo"));
                return "/preinscripcion/preinscripcion3";
            }
        }
        estudiante = new Estudiante();
        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No existe un estudiante con ese número de cedula"));
        return "/preinscripcion/preinscripcion3";

    }

    public Integer[] getMateriasSeleccionadas() {
        return materiasSeleccionadas;
    }

    public void setMateriasSeleccionadas(Integer[] materiasSeleccionadas) {
        this.materiasSeleccionadas = materiasSeleccionadas;
    }

    public String realizarPreinscripcion() {

        Preinscripcion preinscripcion = new Preinscripcion();
        Materia materia;
        Periodo periodo;

        PreinscripcionDao preinscripcionDao = new PreinscripcionDaoImp();
        MateriaDao materiaDao = new MateriaDaoImp();
        PeriodoDao periodoDao = new PeriodoDaoImp();

        periodo = periodoDao.periodoVigente();

        preinscripcion.setEstudiante(estudiante);
        preinscripcion.setPeriodo(periodo);

        int n = materiasSeleccionadas.length;

        if (n == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Seleccione por lo menos una materia"));
            return "/preinscripcion/preinscripcion2";
        }

        for (int i = 0; i < n; i++) {

            int mateCodigo = materiasSeleccionadas[i];
            materia = materiaDao.materiaPorCodigo(mateCodigo);
            preinscripcion.setMateria(materia);
            preinscripcionDao.newPreinscripcion(preinscripcion);

        }

        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Realizado", "Preinscripcion realizada corectamente"));
        return "/preinscripcion/preinscripcion?faces-redirect=true";

    }
    
    public String realizarPreinscripcion2() {

        Preinscripcion preinscripcion = new Preinscripcion();
        Materia materia;
        Periodo periodo;

        PreinscripcionDao preinscripcionDao = new PreinscripcionDaoImp();
        MateriaDao materiaDao = new MateriaDaoImp();
        PeriodoDao periodoDao = new PeriodoDaoImp();

        periodo = periodoDao.periodoVigente();

        preinscripcion.setEstudiante(estudiante);
        preinscripcion.setPeriodo(periodo);

        int n = materiasSeleccionadas.length;

        if (n == 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Seleccione por lo menos una materia"));
            return "/preinscripcion/preinscripcion4";
        }

        for (int i = 0; i < n; i++) {

            int mateCodigo = materiasSeleccionadas[i];
            materia = materiaDao.materiaPorCodigo(mateCodigo);
            preinscripcion.setMateria(materia);
            preinscripcionDao.newPreinscripcion(preinscripcion);

        }

        cedula = "";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Realizado", "Preinscripcion realizada corectamente"));
        return "/preinscripcion/preinscripcion3?faces-redirect=true";

    }

}
