package backing;

import backing.util.MobilePageController;
import entidades.Estudiante;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "estudianteController")
@ViewScoped
public class EstudianteController extends AbstractController<Estudiante> {

    @Inject
    private CarreraController carrCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public EstudianteController() {
        // Inform the Abstract parent controller of the concrete Estudiante Entity
        super(Estudiante.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carrCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Carrera controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCarrCodigo(ActionEvent event) {
        if (this.getSelected() != null && carrCodigoController.getSelected() == null) {
            carrCodigoController.setSelected(this.getSelected().getCarrCodigo());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Preinscripcion entities
     * that are retrieved from Estudiante?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Preinscripcion page
     */
    public String navigatePreinscripcionCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Preinscripcion_items", this.getSelected().getPreinscripcionCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/preinscripcion/index";
    }

}
