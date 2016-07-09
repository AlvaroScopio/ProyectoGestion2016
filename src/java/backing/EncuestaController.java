package backing;

import backing.util.MobilePageController;
import entidades.Encuesta;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "encuestaController")
@ViewScoped
public class EncuestaController extends AbstractController<Encuesta> {

    @Inject
    private DocenteController doceCodigoController;
    @Inject
    private PeriodoController periCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public EncuestaController() {
        // Inform the Abstract parent controller of the concrete Encuesta Entity
        super(Encuesta.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        doceCodigoController.setSelected(null);
        periCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DisponibilidadMateria
     * entities that are retrieved from Encuesta?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DisponibilidadMateria page
     */
    public String navigateDisponibilidadMateriaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisponibilidadMateria_items", this.getSelected().getDisponibilidadMateriaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/disponibilidadMateria/index";
    }

    /**
     * Sets the "items" attribute with a collection of DisponibilidadHoras
     * entities that are retrieved from Encuesta?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DisponibilidadHoras page
     */
    public String navigateDisponibilidadHorasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisponibilidadHoras_items", this.getSelected().getDisponibilidadHorasCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/disponibilidadHoras/index";
    }

    /**
     * Sets the "selected" attribute of the Docente controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDoceCodigo(ActionEvent event) {
        if (this.getSelected() != null && doceCodigoController.getSelected() == null) {
            doceCodigoController.setSelected(this.getSelected().getDoceCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the Periodo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePeriCodigo(ActionEvent event) {
        if (this.getSelected() != null && periCodigoController.getSelected() == null) {
            periCodigoController.setSelected(this.getSelected().getPeriCodigo());
        }
    }
}
