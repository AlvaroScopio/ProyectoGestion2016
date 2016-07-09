package backing;

import backing.util.MobilePageController;
import entidades.DocenteMateriaCurso;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "docenteMateriaCursoController")
@ViewScoped
public class DocenteMateriaCursoController extends AbstractController<DocenteMateriaCurso> {

    @Inject
    private CursoController cursCodigoController;
    @Inject
    private DocenteController doceCodigoController;
    @Inject
    private MateriaController mateCodigoController;
    @Inject
    private MobilePageController mobilePageController;

    public DocenteMateriaCursoController() {
        // Inform the Abstract parent controller of the concrete DocenteMateriaCurso Entity
        super(DocenteMateriaCurso.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cursCodigoController.setSelected(null);
        doceCodigoController.setSelected(null);
        mateCodigoController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of Horario entities that are
     * retrieved from DocenteMateriaCurso?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Horario page
     */
    public String navigateHorarioCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Horario_items", this.getSelected().getHorarioCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/horario/index";
    }

    /**
     * Sets the "selected" attribute of the Curso controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCursCodigo(ActionEvent event) {
        if (this.getSelected() != null && cursCodigoController.getSelected() == null) {
            cursCodigoController.setSelected(this.getSelected().getCursCodigo());
        }
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
