package backing;

import backing.util.MobilePageController;
import entidades.Preinscripcion;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "preinscripcionController")
@ViewScoped
public class PreinscripcionController extends AbstractController<Preinscripcion> {

    @Inject
    private EstudianteController estuCodigoController;
    @Inject
    private MateriaController mateCodigoController;
    @Inject
    private PeriodoController periCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public PreinscripcionController() {
        // Inform the Abstract parent controller of the concrete Preinscripcion Entity
        super(Preinscripcion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        estuCodigoController.setSelected(null);
        mateCodigoController.setSelected(null);
        periCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Estudiante controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareEstuCodigo(ActionEvent event) {
        if (this.getSelected() != null && estuCodigoController.getSelected() == null) {
            estuCodigoController.setSelected(this.getSelected().getEstuCodigo());
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
