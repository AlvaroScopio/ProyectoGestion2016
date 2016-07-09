package dao;

import java.util.List;
import model.Carrera;

public interface CarreraDao {
    
    public List<Carrera> listarCarreras();
    public void newCarrera(Carrera carrera);
    public void updateCarrera(Carrera carrera);
    public void deleteCarrera(Carrera carrera);
    
}
