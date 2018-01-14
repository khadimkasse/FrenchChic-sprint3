/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Khadim
 */
@Entity
@Table(name = "COMMANDE")
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
    , @NamedQuery(name = "Commande.findByNumero", query = "SELECT c FROM Commande c WHERE c.numero = :numero")
    , @NamedQuery(name = "Commande.findByLignesdecommande", query = "SELECT c FROM Commande c WHERE c.lignesdecommande = :lignesdecommande")
    , @NamedQuery(name = "Commande.findByClient", query = "SELECT c FROM Commande c WHERE c.client = :client")})
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO")
    private String numero;
    @OneToOne
    @Size(max = 20)
    //@Column(name = "LIGNESDECOMMANDE")
    
    private Lignedecommande lignesdecommande;
    @Size(max = 20)
    //@Column(name = "CLIENT")
    @OneToOne
    private ClientB client;

    public Commande() {
    }

    public Commande(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Lignedecommande getLignesdecommande() {
        return lignesdecommande;
    }

    public void setLignesdecommande(Lignedecommande lignesdecommande) {
        this.lignesdecommande = lignesdecommande;
    }

    public ClientB getClient() {
        return client;
    }

    public void setClient(ClientB client) {
        this.client = client;
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
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Commande[ numero=" + numero + " ]";
    }
    
}
