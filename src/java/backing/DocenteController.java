package backing;

import backing.util.MobilePageController;
import entidades.Docente;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "docenteController")
@ViewScoped
public class DocenteController extends AbstractController<Docente> {

    @Inject
    private DedicacionController dediCodigoController;
    @Inject
    private TipoTrabajoController titrCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DocenteController() {
        // Inform the Abstract parent controller of the concrete Docente Entity
        super(Docente.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        dediCodigoController.setSelected(null);
        titrCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DocenteMateriaCurso
     * entities that are retrieved from Docente?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DocenteMateriaCurso page
     */
    public String navigateDocenteMateriaCursoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DocenteMateriaCurso_items", this.getSelected().getDocenteMateriaCursoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/docenteMateriaCurso/index";
    }

    /**
     * Sets the "items" attribute with a collection of Encuesta entities that
     * are retrieved from Docente?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Encuesta page
     */
    public String navigateEncuestaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Encuesta_items", this.getSelected().getEncuestaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/encuesta/index";
    }

    /**
     * Sets the "selected" attribute of the Dedicacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDediCodigo(ActionEvent event) {
        if (this.getSelected() != null && dediCodigoController.getSelected() == null) {
            dediCodigoController.setSelected(this.getSelected().getDediCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoTrabajo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTitrCodigo(ActionEvent event) {
        if (this.getSelected() != null && titrCodigoController.getSelected() == null) {
            titrCodigoController.setSelected(this.getSelected().getTitrCodigo());
        }
    }
}
