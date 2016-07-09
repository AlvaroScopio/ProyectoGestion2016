/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entidades.Edificio;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Darwin
 */
@Stateless
public class EdificioFacade extends AbstractFacade<Edificio> {

    @PersistenceContext(unitName = "HorariosWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EdificioFacade() {
        super(Edificio.class);
    }
    
}
