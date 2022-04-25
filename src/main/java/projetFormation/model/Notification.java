package projetFormation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Notification {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	private String nom;
	@Column(name = "espaceTexte", length = 1000)
	private String espaceTexte;
	@Column(name = "Statut")
	private boolean statue;
	@OneToOne
	@JoinColumn(name="candidature_id")
	private Candidature candidature;
	@ManyToOne
	@JoinColumn(name = "recruteur_id")
	private Recruteur recruteur;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEspaceTexte() {
		return espaceTexte;
	}
	public void setEspaceTexte(String espaceTexte) {
		this.espaceTexte = espaceTexte;
	}
	public boolean isStatue() {
		return statue;
	}
	public void setStatue(boolean statue) {
		this.statue = statue;
	}
	
	public Recruteur getRecruteur() {
		return recruteur;
	}
	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}
	public Candidature getCandidature() {
		return candidature;
	}
	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}
	
	
	
}
