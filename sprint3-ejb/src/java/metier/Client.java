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
@Table(name = "CLIENT")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
    , @NamedQuery(name = "Client.findByNumero", query = "SELECT c FROM Client c WHERE c.numero = :numero")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO")
    private String numero;
    @Lob
    @Size(max = 32700)
    @Column(name = "NOM")
    private String nom;
    @Lob
    @Size(max = 32700)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "PSEUDO")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 32700)
    @Column(name = "MOTDEPASSE")
    private String motdepasse;

    public Client() {
    }

    public Client(String numero) {
        this.numero = numero;
    }

    public Client(String numero, String pseudo, String motdepasse) {
        this.numero = numero;
        this.pseudo = pseudo;
        this.motdepasse = motdepasse;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
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
