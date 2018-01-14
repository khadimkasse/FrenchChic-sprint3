/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;


import javax.ejb.Remote;

import metier.Produit;

/**
 *
 * @author user
 */
@Remote
public interface ProduitSessionBeanLocal {
    Produit rechercherProduitDuJour();
    void retirerDuSTock(int qte, Produit pdt);
    public Produit RechercherProduit(long cId);
    public void modifierProduit(Produit pdt);
    public Produit creerProduit(Produit pdt); 
    
}
