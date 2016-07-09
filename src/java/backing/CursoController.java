package backing;

import backing.util.MobilePageController;
import entidades.Curso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "cursoController")
@ViewScoped
public class CursoController extends AbstractController<Curso> {

    @Inject
    private CarreraController carrCodigoController;
    @Inject
    private ParaleloController paraCodigoController;
    @Inject
    private PeriodoController periCodigoController;
    @Inject
    private SemestreController semeCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public CursoController() {
        // Inform the Abstract parent controller of the concrete Curso Entity
        super(Curso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        carrCodigoController.setSelected(null);
        paraCodigoController.setSelected(null);
        periCodigoController.setSelected(null);
        semeCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of DocenteMateriaCurso
     * entities that are retrieved from Curso?cap_first and returns the
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
     * Sets the "selected" attribute of the Paralelo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareParaCodigo(ActionEvent event) {
        if (this.getSelected() != null && paraCodigoController.getSelected() == null) {
            paraCodigoController.setSelected(this.getSelected().getParaCodigo());
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
