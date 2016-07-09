package backing;

import backing.util.MobilePageController;
import entidades.Aula;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "aulaController")
@ViewScoped
public class AulaController extends AbstractController<Aula> {

    @Inject
    private CarreraController carrCodigoController;
    @Inject
    private EdificioController edifCodigoController;
    @Inject
    private TipoAulaController tiauCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public AulaController() {
        // Inform the Abstract parent controller of the concrete Aula Entity
        super(Aula.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carrCodigoController.setSelected(null);
        edifCodigoController.setSelected(null);
        tiauCodigoController.setSelected(null);
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
     * Sets the "selected" attribute of the Edificio controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEdifCodigo(ActionEvent event) {
        if (this.getSelected() != null && edifCodigoController.getSelected() == null) {
            edifCodigoController.setSelected(this.getSelected().getEdifCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the TipoAula controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTiauCodigo(ActionEvent event) {
        if (this.getSelected() != null && tiauCodigoController.getSelected() == null) {
            tiauCodigoController.setSelected(this.getSelected().getTiauCodigo());
        }
    }

    /**
     * Sets the "items" attribute with a collection of Horario entities that are
     * retrieved from Aula?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Horario page
     */
    public String navigateHorarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Horario_items", this.getSelected().getHorarioCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/horario/index";
    }

}
