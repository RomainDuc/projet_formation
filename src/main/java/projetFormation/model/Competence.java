package projetFormation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Competence {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String nom;
	private String description;
	private String niveauAptitudes;
	@ManyToOne
	@JsonIgnoreProperties("competences")
	@JoinColumn(name = "cv_id")
	private Cv cv;
	@OneToMany(mappedBy = "competence")
	private List<CompetenceOffreEmploi>  competenceOffres;
	
	public Competence() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getNiveauAptitudes() {
		return niveauAptitudes;
	}


	public void setNiveauAptitudes(String niveauAptitudes) {
		this.niveauAptitudes = niveauAptitudes;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Cv getCv() {
		return cv;
	}


	public void setCv(Cv cv) {
		this.cv = cv;
	}


	public List<CompetenceOffreEmploi> getCompetenceOffres() {
		return competenceOffres;
	}


	public void setCompetenceOffres(List<CompetenceOffreEmploi> competenceOffres) {
		this.competenceOffres = competenceOffres;
	}

	
	
}
