package backing;

import backing.util.MobilePageController;
import entidades.DisponibilidadMateria;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "disponibilidadMateriaController")
@ViewScoped
public class DisponibilidadMateriaController extends AbstractController<DisponibilidadMateria> {

    @Inject
    private EncuestaController encuCodigoController;
    @Inject
    private MateriaController mateCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DisponibilidadMateriaController() {
        // Inform the Abstract parent controller of the concrete DisponibilidadMateria Entity
        super(DisponibilidadMateria.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        encuCodigoController.setSelected(null);
        mateCodigoController.setSelected(null);
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

    /**
     * Sets the "selected" attribute of the Materia controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMateCodigo(ActionEvent event) {
        if (this.getSelected() != null && mateCodigoController.getSelected() == null) {
            mateCodigoController.setSelected(this.getSelected().getMateCodigo());
        }
    }
}
