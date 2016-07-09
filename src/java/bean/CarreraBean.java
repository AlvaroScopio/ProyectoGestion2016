package bean;

import dao.CarreraDao;
import imp.CarreraDaoImp;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Carrera;

@ManagedBean
@ViewScoped
public class CarreraBean implements Serializable{

    private List<Carrera> listaCarreras;
    private Carrera carrera;
    
    public CarreraBean() {
        carrera = new Carrera();
    }

    public void setListaCarrera(List<Carrera> listaCarrera) {
        this.listaCarreras = listaCarrera;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    public List<Carrera> getListaCarrera() {
        CarreraDao carreraDao = new CarreraDaoImp();
        listaCarreras = carreraDao.listarCarreras();
        return listaCarreras;
    }
    
    public void prepararNuevaCarrera(){
        carrera = new Carrera();
    }
    
    public void nuevaCarrera(){
        CarreraDao carreraDao = new CarreraDaoImp();
        carrera.setCarrCodigo(1000);
        carreraDao.newCarrera(carrera);
    }
    
    public void modificarCarrera(){
        CarreraDao carreraDao = new CarreraDaoImp();
        carreraDao.updateCarrera(carrera);
        carrera = new Carrera();
    }
    
    public void eliminarCarrera(){
        CarreraDao carreraDao = new CarreraDaoImp();
        carreraDao.deleteCarrera(carrera);
        carrera = new Carrera();
    }
    
}
