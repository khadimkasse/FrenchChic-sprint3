
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
import metier.ClientB;
@ManagedBean
@Named(value = "sessionManagedBeanF")
@SessionScoped
public class SessionManagedBeanF implements Serializable {

 @EJB
 //private SessionClientInterface gestionClientRemote;
 private SessionClientInterface gestionClientRemote; 
 private ClientB leClient =new ClientB();
 
 private int testVal =0;
 
 public int getTestVal(){
     return this.testVal;
 }
 
 public void setTestVal(int v){
     this.testVal=v;
 }
 public SessionManagedBeanF() throws NamingException{
   // ClientB leClient = new ClientB();
   
    
    Context ctx= (Context) new InitialContext();
    gestionClientRemote=(SessionClientInterface)ctx.lookup("controleur/GCB_JNDI");
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
 
 
 
 private String getParamId(String nomParam) {
FacesContext context = FacesContext.getCurrentInstance();
Map<String,String> map= context.getExternalContext().getRequestParameterMap();
String result = map.get(nomParam);
//return Long.valueOf(result);
return result;
}
    
}
