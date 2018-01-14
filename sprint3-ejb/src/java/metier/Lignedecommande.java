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
@Table(name = "LIGNEDECOMMANDE")
@NamedQueries({
    @NamedQuery(name = "Lignedecommande.findAll", query = "SELECT l FROM Lignedecommande l")
    , @NamedQuery(name = "Lignedecommande.findByProduit", query = "SELECT l FROM Lignedecommande l WHERE l.produit = :produit")
    , @NamedQuery(name = "Lignedecommande.findByQuantite", query = "SELECT l FROM Lignedecommande l WHERE l.quantite = :quantite")
    , @NamedQuery(name = "Lignedecommande.findByMontant", query = "SELECT l FROM Lignedecommande l WHERE l.montant = :montant")})
public class Lignedecommande implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    
    @Size(min = 1, max = 20)
    @Column(name = "NUMERO")
    private String numero;
    
    
    //@Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    //@Column(name = "PRODUIT")
    @OneToOne
    @JoinColumn(name="NOM", referencedColumnName="NUMERO")
    private Produit produit;
   
    @Column(name = "QUANTITE")
    private Integer quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Float montant;

    public Lignedecommande() {
    }
    
    public Lignedecommande(Produit leProduit,int quantite,String s){
		this.produit = leProduit;
		this.quantite = quantite;
                this.montant = quantite * leProduit.getPrix();
                numero =s;
	}

    public Lignedecommande(Produit produit) {
        this.produit = produit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getMontant() {
        return montant;
    }

    public void setMontant(Float montant) {
        this.montant = montant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produit != null ? produit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignedecommande)) {
            return false;
        }
        Lignedecommande other = (Lignedecommande) object;
        if ((this.produit == null && other.produit != null) || (this.produit != null && !this.produit.equals(other.produit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Lignedecommande[ produit=" + produit + " ]";
    }
    
}
