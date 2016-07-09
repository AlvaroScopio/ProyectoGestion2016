package backing;

import backing.util.MobilePageController;
import entidades.TipoAula;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoAulaController")
@ViewScoped
public class TipoAulaController extends AbstractController<TipoAula> {

    @Inject
    private MobilePageController mobilePageController;

    public TipoAulaController() {
        // Inform the Abstract parent controller of the concrete TipoAula Entity
        super(TipoAula.class);
    }

    /**
     * Sets the "items" attribute with a collection of Aula entities that are
     * retrieved from TipoAula?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Aula page
     */
    public String navigateAulaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Aula_items", this.getSelected().getAulaCollection());
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/aula/index";
    }

}
