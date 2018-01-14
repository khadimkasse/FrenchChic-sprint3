package controleur;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Produit;

/**
 *
 * @author user
 */
@Stateless(name="produitnamed", mappedName="controleur/PDT_JNDI")
public class ProduitSessionBean implements ProduitSessionBeanLocal {

    @PersistenceContext(unitName="SessionBean")
    private EntityManager emP;
    
    @Override
    public Produit rechercherProduitDuJour() {
       javax.persistence.Query query = emP.createNamedQuery(Produit.NamedQueries.TROUVER_PRODUIT_DU_JOUR);
       Produit leProduitDuJour = (Produit)query.getSingleResult();
       
       return leProduitDuJour;
    }
    
    @Override
    public void retirerDuSTock(int qte,Produit pdt) {
        pdt.retirerDuStock(qte);
        emP.merge(pdt);
    }

    @Override
    public Produit RechercherProduit(long cId) {
        Produit pdt;
        pdt=emP.find(Produit.class,cId);
        
        return pdt;
    }

    @Override
    public void modifierProduit(Produit pdt) {
        emP.merge(pdt);
    }

    @Override
    public Produit creerProduit(Produit pdt) {
        emP.persist(pdt);
      return pdt;
    }

    
}
