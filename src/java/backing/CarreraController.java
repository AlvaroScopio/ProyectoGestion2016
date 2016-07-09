package backing;

import backing.util.MobilePageController;
import entidades.Carrera;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "carreraController")
@ViewScoped
public class CarreraController extends AbstractController<Carrera> {

    @Inject
    private MobilePageController mobilePageController;

    public CarreraController() {
        // Inform the Abstract parent controller of the concrete Carrera Entity
        super(Carrera.class);
    }

    /**
     * Sets the "items" attribute with a collection of Estudiante entities that
     * are retrieved from Carrera?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Estudiante page
     */
    public String navigateEstudianteCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Estudiante_items", this.getSelected().getEstudianteCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/estudiante/index";
    }

    /**
     * Sets the "items" attribute with a collection of Aula entities that are
     * retrieved from Carrera?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Aula page
     */
    public String navigateAulaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Aula_items", this.getSelected().getAulaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/aula/index";
    }

    /**
     * Sets the "items" attribute with a collection of MateriaSemestreCarrera
     * entities that are retrieved from Carrera?cap_first and returns the
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
     * retrieved from Carrera?cap_first and returns the navigation outcome.
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
