package backing;

import backing.util.MobilePageController;
import entidades.Menu;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "menuController")
@ViewScoped
public class MenuController extends AbstractController<Menu> {

    @Inject
    private MobilePageController mobilePageController;

    public MenuController() {
        // Inform the Abstract parent controller of the concrete Menu Entity
        super(Menu.class);
    }

    /**
     * Sets the "items" attribute with a collection of RolMenu entities that are
     * retrieved from Menu?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for RolMenu page
     */
    public String navigateRolMenuCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("RolMenu_items", this.getSelected().getRolMenuCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/rolMenu/index";
    }

}
