package backing;

import backing.util.MobilePageController;
import entidades.Paralelo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "paraleloController")
@ViewScoped
public class ParaleloController extends AbstractController<Paralelo> {

    @Inject
    private MobilePageController mobilePageController;

    public ParaleloController() {
        // Inform the Abstract parent controller of the concrete Paralelo Entity
        super(Paralelo.class);
    }

    /**
     * Sets the "items" attribute with a collection of Curso entities that are
     * retrieved from Paralelo?cap_first and returns the navigation outcome.
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
