/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Lignedecommande;

/**
 *
 * @author user
 */
@Stateless(name="ligneDeCmdnamed", mappedName="controleur/LCMD_JNDI")
public class lignesDeCmdSessionBean implements lignesDeCmdSessionBeanLocal {

     @PersistenceContext(unitName="SessionBean")
    private EntityManager emLcmd;
    
    @Override
    public void modifierLigneDeCommande(Lignedecommande lCmd) {
        emLcmd.merge(lCmd);
    }

    @Override
    public Lignedecommande creerLigneDeCommande(Lignedecommande lCmd) {
        //emLcmd.persist(lCmd);
        return lCmd;
    }
   
   
}
