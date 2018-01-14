/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Commande;

/**
 *
 * @author user
 */
@Stateless(name = "commandeNamed", mappedName="controleur/GCMD_JNDI")
public class CommandeSessionBean implements CommandeSessionBeanLocal {

    
     @PersistenceContext(unitName="SessionBean")
    private EntityManager emCmd;
    
    @Override
    public void modifierCommande(Commande cmd) {
        emCmd.merge(cmd);
    }

    @Override
    public Commande creerCommande(Commande cmd) {
        emCmd.persist(cmd);
        return cmd;
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
