package backing;

import backing.util.MobilePageController;
import entidades.Edificio;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "edificioController")
@ViewScoped
public class EdificioController extends AbstractController<Edificio> {

    @Inject
    private MobilePageController mobilePageController;

    public EdificioController() {
        // Inform the Abstract parent controller of the concrete Edificio Entity
        super(Edificio.class);
    }

    /**
     * Sets the "items" attribute with a collection of Aula entities that are
     * retrieved from Edificio?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Aula page
     */
    public String navigateAulaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Aula_items", this.getSelected().getAulaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/aula/index";
    }

}
