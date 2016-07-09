package dao;

import model.Preinscripcion;

public interface PreinscripcionDao {

    public void newPreinscripcion(Preinscripcion preinscripcion);
    public boolean validaPreinscripcion(int estuCodigo, int periCodigo);
    
}
