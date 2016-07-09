package backing;

import backing.util.MobilePageController;
import entidades.Horario;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "horarioController")
@ViewScoped
public class HorarioController extends AbstractController<Horario> {

    @Inject
    private AulaController aulaCodigoController;
    @Inject
    private DocenteMateriaCursoController domcCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public HorarioController() {
        // Inform the Abstract parent controller of the concrete Horario Entity
        super(Horario.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        aulaCodigoController.setSelected(null);
        domcCodigoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Aula controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareAulaCodigo(ActionEvent event) {
        if (this.getSelected() != null && aulaCodigoController.getSelected() == null) {
            aulaCodigoController.setSelected(this.getSelected().getAulaCodigo());
        }
    }

    /**
     * Sets the "selected" attribute of the DocenteMateriaCurso controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDomcCodigo(ActionEvent event) {
        if (this.getSelected() != null && domcCodigoController.getSelected() == null) {
            domcCodigoController.setSelected(this.getSelected().getDomcCodigo());
        }
    }
}
