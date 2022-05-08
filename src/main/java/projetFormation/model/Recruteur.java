package projetFormation.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Recruteur extends Utilisateur{
	
	
	private int matriculeRecruteur;
	
	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	@OneToMany(mappedBy = "recruteur")
	private List<OffreEmploi> offres;
	@OneToMany(mappedBy = "recruteur")
	private List<Notification> notifications;
	@OneToMany(mappedBy = "recruteur")
	private List<ExamenRecruteur> examenRecruteurs;
	

	
	
	
	public Recruteur() {
		super();

	}


	public int getMatriculeRecruteur() {
		return matriculeRecruteur;
	}


	public void setMatriculeRecruteur(int matriculeRecruteur) {
		this.matriculeRecruteur = matriculeRecruteur;
	}


	public List<Notification> getNotifications() {
		return notifications;
}


	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}


	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	public List<OffreEmploi> getOffres() {
		return offres;
	}


	public void setOffres(List<OffreEmploi> offres) {
		this.offres = offres;
	}


	public List<ExamenRecruteur> getExamenRecruteurs() {
		return examenRecruteurs;
	}


	public void setExamenRecruteurs(List<ExamenRecruteur> examenRecruteurs) {
		this.examenRecruteurs = examenRecruteurs;
	}


	@Override
	public String toString() {
		return "Recruteur [matriculeRecruteur=" + matriculeRecruteur + ", entreprise=" + entreprise + ", offres="
				+ offres + ", notifications=" + notifications + ", examenRecruteurs=" + examenRecruteurs + "]";
	}
	
	
	

}
