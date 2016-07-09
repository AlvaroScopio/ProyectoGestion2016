package dao;

import java.util.List;
import model.Usuario;

public interface UsuarioDao {

    public Usuario getByUserNombre(String userNombre);
    public List<Usuario> findAll();
    public void newUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
}
