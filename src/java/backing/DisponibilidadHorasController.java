package backing;

import backing.util.MobilePageController;
import entidades.DisponibilidadHoras;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "disponibilidadHorasController")
@ViewScoped
public class DisponibilidadHorasController extends AbstractController<DisponibilidadHoras> {

    @Inject
    private EncuestaController encuCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DisponibilidadHorasController() {
        // Inform the Abstract parent controller of the concrete DisponibilidadHoras Entity
        super(DisponibilidadHoras.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        encuCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Encuesta controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEncuCodigo(ActionEvent event) {
        if (this.getSelected() != null && encuCodigoController.getSelected() == null) {
            encuCodigoController.setSelected(this.getSelected().getEncuCodigo());
        }
    }
}
