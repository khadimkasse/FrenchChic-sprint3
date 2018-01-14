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
@Table(name = "PRODUIT")
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
    , @NamedQuery(name = "Produit.findByNom", query = "SELECT p FROM Produit p WHERE p.nom = :nom")
    , @NamedQuery(name = "Produit.findByPrix", query = "SELECT p FROM Produit p WHERE p.prix = :prix")
    , @NamedQuery(name = "Produit.findByQuantitestock", query = "SELECT p FROM Produit p WHERE p.quantitestock = :quantitestock")
    , @NamedQuery(name = "Produit.findByEstdujour", query = "SELECT p FROM Produit p WHERE p.estdujour = :estdujour"),
            @NamedQuery(name = Produit.NamedQueries.TROUVER_PRODUIT_DU_JOUR, 
                    query = "SELECT pdt FROM Produit pdt WHERE pdt.estdujour=1")
})
public class Produit implements Serializable {

    public final class NamedQueries{
        public static final String TROUVER_PRODUIT_DU_JOUR= "Produit.trouverProduitDuJour";
    }
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NOM")
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRIX")
    private Float prix;
    @Column(name = "QUANTITESTOCK")
    private Integer quantitestock;
    @Column(name = "ESTDUJOUR")
    private Boolean estdujour;

    public Produit() {
    }

    public Produit(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getQuantitestock() {
        return quantitestock;
    }

    public void setQuantitestock(Integer quantitestock) {
        this.quantitestock = quantitestock;
    }

    public Boolean getEstdujour() {
        return estdujour;
    }

    public void setEstdujour(Boolean estdujour) {
        this.estdujour = estdujour;
    }
    
    public void retirerDuStock(int qte){
        this.quantitestock = this.quantitestock-qte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nom != null ? nom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.nom == null && other.nom != null) || (this.nom != null && !this.nom.equals(other.nom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "metier.Produit[ nom=" + nom + " ]";
    }
    
}
