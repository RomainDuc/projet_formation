package projetFormation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Candidat extends Utilisateur{
	
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private boolean disponibilite;
	@OneToMany(mappedBy = "candidat")
	private List<Cv> cvs;
	
	@OneToMany(mappedBy = "candidat")
	private List<Candidature> candidatOffreEmploi;
	
	
	public Candidat() {
		super();
	}
	
	
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public boolean isDisponibilite() {
		return disponibilite;
	}
	public void setDisponibilite(boolean disponibilite) {
		this.disponibilite = disponibilite;
	}


	public List<Cv> getCvs() {
		return cvs;
	}


	public void setCvs(List<Cv> cvs) {
		this.cvs = cvs;
	}


	public List<Candidature> getCandidatOffreEmploi() {
		return candidatOffreEmploi;
	}


	public void setCandidatOffreEmploi(List<Candidature> candidatOffreEmploi) {
		this.candidatOffreEmploi = candidatOffreEmploi;
	}
	
	

}
