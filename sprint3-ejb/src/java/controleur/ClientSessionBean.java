/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.PersistenceContext;
import metier.ClientB;

/**
 *
 * @author Khadim
 */
@Stateless(name="clientBnamed", mappedName="controleur/GCB_JNDI")

public class ClientSessionBean implements SessionClientInterface{
    
    @PersistenceContext(unitName="SessionBean")
    private EntityManager emC;
    

    @Override
    public ClientB RechercherClient(String numero) {
        ClientB cl;
        cl=emC.find(ClientB.class,numero);
        
        return cl;
    }

    @Override
   public  ClientB rechercherClientParPseudo(String pseudo, String motDePasse){
      
       javax.persistence.Query query =emC.createNamedQuery(ClientB.NamedQueries.RECHERCHER_CLIENT_PAR_PSEUDO);
       query.setParameter("pseudo",pseudo);
       query.setParameter("motDePasse", motDePasse);
       ClientB clientResult = (ClientB)query.getSingleResult();
        
       return clientResult;
    }
   
    @Override
    public void modifierClient(ClientB cl) {
        emC.merge(cl);
        
    }

    @Override
    public ClientB creerClient(ClientB cl) {
      emC.persist(cl);
      return cl;
    }
    @Override
   public ClientB creerClientInfos(String nom,String prenom,String pseudo,String mdp){
      ClientB clt= new ClientB();
      clt.setNom(nom);
      clt.setPrenom(prenom);
      clt.setPseudo(pseudo);
      clt.setMotdepasse(mdp);
      emC.persist(clt);
      return clt;
   }
  
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
