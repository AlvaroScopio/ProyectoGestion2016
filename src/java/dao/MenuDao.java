package dao;

import java.util.List;
import model.Menu;

public interface MenuDao {

    public List<Menu> ListarMenus();
    public List<Menu> ListarMenusPorUsuario(int rolCodigo);
    
}
