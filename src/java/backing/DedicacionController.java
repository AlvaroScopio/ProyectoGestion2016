package backing;

import backing.util.MobilePageController;
import entidades.Dedicacion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "dedicacionController")
@ViewScoped
public class DedicacionController extends AbstractController<Dedicacion> {

    @Inject
    private MobilePageController mobilePageController;

    public DedicacionController() {
        // Inform the Abstract parent controller of the concrete Dedicacion Entity
        super(Dedicacion.class);
    }

    /**
     * Sets the "items" attribute with a collection of Docente entities that are
     * retrieved from Dedicacion?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Docente page
     */
    public String navigateDocenteCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Docente_items", this.getSelected().getDocenteCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/docente/index";
    }

}
