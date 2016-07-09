package backing;

import backing.util.MobilePageController;
import entidades.RolMenu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "rolMenuController")
@ViewScoped
public class RolMenuController extends AbstractController<RolMenu> {

    @Inject
    private MenuController menuCodigoController;
    @Inject
    private RolController rolCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public RolMenuController() {
        // Inform the Abstract parent controller of the concrete RolMenu Entity
        super(RolMenu.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        menuCodigoController.setSelected(null);
        rolCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Menu controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMenuCodigo(ActionEvent event) {
        if (this.getSelected() != null && menuCodigoController.getSelected() == null) {
            menuCodigoController.setSelected(this.getSelected().getMenuCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Rol controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareRolCodigo(ActionEvent event) {
        if (this.getSelected() != null && rolCodigoController.getSelected() == null) {
            rolCodigoController.setSelected(this.getSelected().getRolCodigo());
        }
    }
}
