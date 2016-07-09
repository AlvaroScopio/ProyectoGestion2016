package backing;

import backing.util.MobilePageController;
import entidades.MateriaSemestreCarrera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "materiaSemestreCarreraController")
@ViewScoped
public class MateriaSemestreCarreraController extends AbstractController<MateriaSemestreCarrera> {

    @Inject
    private CarreraController carrCodigoController;
    @Inject
    private MateriaController mateCodigoController;
    @Inject
    private SemestreController semeCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public MateriaSemestreCarreraController() {
        // Inform the Abstract parent controller of the concrete MateriaSemestreCarrera Entity
        super(MateriaSemestreCarrera.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carrCodigoController.setSelected(null);
        mateCodigoController.setSelected(null);
        semeCodigoController.setSelected(null);
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
     * Sets the "selected" attribute of the Semestre controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareSemeCodigo(ActionEvent event) {
        if (this.getSelected() != null && semeCodigoController.getSelected() == null) {
            semeCodigoController.setSelected(this.getSelected().getSemeCodigo());
        }
    }
}
