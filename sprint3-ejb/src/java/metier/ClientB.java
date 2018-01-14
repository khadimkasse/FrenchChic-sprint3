/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Khadim
 */
@Entity
@Table(name = "CLIENTB")

@NamedQueries({
    @NamedQuery(name = ClientB.NamedQueries.RECHERCHER_CLIENT_PAR_PSEUDO , 
            query = "SELECT clt FROM ClientB clt WHERE clt.pseudo=:pseudo AND clt.motdepasse=:motDePasse")
})
public class ClientB implements Serializable {
    
    public final class NamedQueries{
        public static final String RECHERCHER_CLIENT_PAR_PSEUDO = "ClientB.rechercherClientParPseudoMdp";
    }

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO")
    private String numero;
    @Size(max = 32700)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 32700)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32700)
    @Column(name = "PSEUDO")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32700)
    @Column(name = "MOTDEPASSE")
    private String motdepasse;

    public ClientB() {
        this.motdepasse="bidule";
        this.nom="test";
    }

    public ClientB(String numero) {
        this.numero = numero;
    }

    public ClientB(String numero,String prenom,String pseudo, String motdepasse) {
        this.numero = numero;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
        this.prenom=prenom;
    }
    
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientB)) {
            return false;
        }
        ClientB other = (ClientB) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Client[ numero=" + numero + " ]";
    }
    
}
