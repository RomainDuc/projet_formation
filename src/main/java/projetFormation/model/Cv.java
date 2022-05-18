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
public class Cv {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JsonIgnoreProperties("cvs")
	@JoinColumn(name = "candidat_id")
	private Candidat candidat;
	
	@OneToMany(mappedBy = "cv")
	@JsonIgnoreProperties("cv")
	private List<Formation> formations;
	@OneToMany(mappedBy = "cv")
	@JsonIgnoreProperties("cv")
	private List<ExperienceProfessionelle> experiencesProfessionelles;
	@OneToMany(mappedBy = "cv")
	private List<Diplome> diplomes;
	@OneToMany(mappedBy = "cv")
	private List<Competence> competences;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public List<ExperienceProfessionelle> getExperiencesProfessionelles() {
		return experiencesProfessionelles;
	}

	public void setExperiencesProfessionelles(List<ExperienceProfessionelle> experiencesProfessionelles) {
		this.experiencesProfessionelles = experiencesProfessionelles;
	}

	public List<Diplome> getDiplomes() {
		return diplomes;
	}

	public void setDiplomes(List<Diplome> diplomes) {
		this.diplomes = diplomes;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	

}
