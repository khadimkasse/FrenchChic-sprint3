/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.ejb.Remote;
import metier.ClientB;

/**
 *
 * @author Khadim
 */
@Remote
public interface SessionClientInterface {
    public ClientB RechercherClient(String numero);
    public ClientB rechercherClientParPseudo(String pseudo, String motDePasse); 
    public void modifierClient(ClientB cl);
    public ClientB creerClient(ClientB cl);  
    public ClientB creerClientInfos(String nom,String prenom, String pseudo,String mdp);
    
}
