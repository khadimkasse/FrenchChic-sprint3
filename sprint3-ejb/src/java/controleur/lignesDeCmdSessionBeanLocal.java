/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import javax.ejb.Remote;
import metier.Lignedecommande;

/**
 *
 * @author user
 */
@Remote
public interface lignesDeCmdSessionBeanLocal {
    
    public void modifierLigneDeCommande(Lignedecommande lCmd);
   public  Lignedecommande creerLigneDeCommande(Lignedecommande lCmd);
    
}
