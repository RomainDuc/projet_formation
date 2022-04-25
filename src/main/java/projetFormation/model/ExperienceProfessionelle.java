package projetFormation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class ExperienceProfessionelle {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private int numero;
	private String description;
	private int anneeExperience;
	private String entreprise;
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	public ExperienceProfessionelle() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAnneeExperience() {
		return anneeExperience;
	}
	public void setAnneeExperience(int anneeExperience) {
		this.anneeExperience = anneeExperience;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
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

	
}
