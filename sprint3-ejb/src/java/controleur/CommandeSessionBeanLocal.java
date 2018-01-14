/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.ejb.Remote;
import metier.Commande;

/**
 *
 * @author user
 */
@Remote
public interface CommandeSessionBeanLocal {
    
   
    
     public void modifierCommande(Commande cmd);
    public Commande creerCommande(Commande cmd);
    
}
