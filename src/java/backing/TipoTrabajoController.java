package backing;

import backing.util.MobilePageController;
import entidades.TipoTrabajo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoTrabajoController")
@ViewScoped
public class TipoTrabajoController extends AbstractController<TipoTrabajo> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoTrabajoController() {
        // Inform the Abstract parent controller of the concrete TipoTrabajo Entity
        super(TipoTrabajo.class);
    }

    /**
     * Sets the "items" attribute with a collection of Docente entities that are
     * retrieved from TipoTrabajo?cap_first and returns the navigation outcome.
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
