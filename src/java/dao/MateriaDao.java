package dao;

import model.Materia;
import java.util.List;

public interface MateriaDao {

    public List<Materia> ListarMateriasPorCarrera(int carrCodigo);
    public Materia materiaPorCodigo(int mateCodigo);
    
}
