package backing;

import backing.util.MobilePageController;
import entidades.Materia;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "materiaController")
@ViewScoped
public class MateriaController extends AbstractController<Materia> {

    @Inject
    private MobilePageController mobilePageController;

    public MateriaController() {
        // Inform the Abstract parent controller of the concrete Materia Entity
        super(Materia.class);
    }

    /**
     * Sets the "items" attribute with a collection of DocenteMateriaCurso
     * entities that are retrieved from Materia?cap_first and returns the
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
     * Sets the "items" attribute with a collection of MateriaSemestreCarrera
     * entities that are retrieved from Materia?cap_first and returns the
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
     * Sets the "items" attribute with a collection of MateriaEstadistico
     * entities that are retrieved from Materia?cap_first and returns the
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
     * Sets the "items" attribute with a collection of DisponibilidadMateria
     * entities that are retrieved from Materia?cap_first and returns the
     * navigation outcome.
     *
     * @return navigation outcome for DisponibilidadMateria page
     */
    public String navigateDisponibilidadMateriaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("DisponibilidadMateria_items", this.getSelected().getDisponibilidadMateriaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/disponibilidadMateria/index";
    }

    /**
     * Sets the "items" attribute with a collection of Preinscripcion entities
     * that are retrieved from Materia?cap_first and returns the navigation
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
