package backing;

import backing.util.MobilePageController;
import entidades.Periodo;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "periodoController")
@ViewScoped
public class PeriodoController extends AbstractController<Periodo> {

    @Inject
    private MobilePageController mobilePageController;

    public PeriodoController() {
        // Inform the Abstract parent controller of the concrete Periodo Entity
        super(Periodo.class);
    }

    /**
     * Sets the "items" attribute with a collection of MateriaEstadistico
     * entities that are retrieved from Periodo?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for MateriaEstadistico page
     */
    public String navigateMateriaEstadisticoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("MateriaEstadistico_items", this.getSelected().getMateriaEstadisticoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/materiaEstadistico/index";
    }

    /**
     * Sets the "items" attribute with a collection of Encuesta entities that
     * are retrieved from Periodo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Encuesta page
     */
    public String navigateEncuestaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Encuesta_items", this.getSelected().getEncuestaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/encuesta/index";
    }

    /**
     * Sets the "items" attribute with a collection of Curso entities that are
     * retrieved from Periodo?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Curso page
     */
    public String navigateCursoCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Curso_items", this.getSelected().getCursoCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/curso/index";
    }

    /**
     * Sets the "items" attribute with a collection of Preinscripcion entities
     * that are retrieved from Periodo?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Preinscripcion page
     */
    public String navigatePreinscripcionCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Preinscripcion_items", this.getSelected().getPreinscripcionCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/preinscripcion/index";
    }

}
