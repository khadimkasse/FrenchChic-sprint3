
package controleurW;

import controleur.*;
import java.io.Serializable;
import java.util.Map;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import metier.*;
@ManagedBean
@Named(value = "sessionManagedBeanF")
@SessionScoped
public class SessionManagedBeanF implements Serializable {

 @EJB
 private SessionClientInterface gestionClientRemote; 
 private ClientB leClient ;
 
 
 @EJB
 private ProduitSessionBeanLocal gestionProduit;
 private Produit produitDuJour ;
 

 
 // Attribute to retrieve the value of user input
 private int qteAchetee; 
@EJB
 private CommandeSessionBeanLocal gestionCmd;
 private Commande laCommande;

 
 public SessionManagedBeanF() throws NamingException{
     leClient =new ClientB();
     produitDuJour = new Produit();
     laCommande = new Commande();
    Context ctx= (Context) new InitialContext();
    gestionClientRemote=(SessionClientInterface)ctx.lookup("controleur/GCB_JNDI");
    gestionProduit =(ProduitSessionBeanLocal)ctx.lookup("controleur/PDT_JNDI");
    gestionCmd =(CommandeSessionBeanLocal)ctx.lookup("controleur/GCMD_JNDI");
 }
 
 public ClientB getLeClient(){
     return leClient;
 }
 
 public void setLeClient(ClientB clt){
     leClient = clt;
 }
 
 public String rechercherClientParPseudoMdp(){
     leClient = gestionClientRemote.rechercherClientParPseudo(leClient.getPseudo(), leClient.getMotdepasse());
     return "client.trouve";
 }

    public Produit getProduitDuJour() {
        return produitDuJour;
    }

    public void setProduitDuJour(Produit produitDuJour) {
        this.produitDuJour = produitDuJour;
    }

    public int getQteAchetee() {
        return qteAchetee;
    }

    public void setQteAchetee(int qteAchetee) {
        this.qteAchetee = qteAchetee;
    }
    
 public void rechercherProduitDuJour(){
    produitDuJour = gestionProduit.rechercherProduitDuJour(); 
}
 
 public String retirerDuSTock(){
     gestionProduit.retirerDuSTock(qteAchetee, produitDuJour);
     return "quantite.retiree";
 }
 
 
 
 private String getParamId(String nomParam) {
FacesContext context = FacesContext.getCurrentInstance();
Map<String,String> map= context.getExternalContext().getRequestParameterMap();
String result = map.get(nomParam);
//return Long.valueOf(result);
return result;
}
    
}
