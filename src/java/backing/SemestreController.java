package backing;

import backing.util.MobilePageController;
import entidades.Semestre;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "semestreController")
@ViewScoped
public class SemestreController extends AbstractController<Semestre> {

    @Inject
    private MobilePageController mobilePageController;

    public SemestreController() {
        // Inform the Abstract parent controller of the concrete Semestre Entity
        super(Semestre.class);
    }

    /**
     * Sets the "items" attribute with a collection of MateriaSemestreCarrera
     * entities that are retrieved from Semestre?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MateriaSemestreCarrera page
     */
    public String navigateMateriaSemestreCarreraCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MateriaSemestreCarrera_items", this.getSelected().getMateriaSemestreCarreraCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/materiaSemestreCarrera/index";
    }

    /**
     * Sets the "items" attribute with a collection of Curso entities that are
     * retrieved from Semestre?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Curso page
     */
    public String navigateCursoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Curso_items", this.getSelected().getCursoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/curso/index";
    }

}
