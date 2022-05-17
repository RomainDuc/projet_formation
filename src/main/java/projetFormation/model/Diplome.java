package projetFormation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
public class Diplome {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String nom;
	@Temporal(TemporalType.DATE)
	private Date anneeObtention;
	@Enumerated(EnumType.STRING)
	private NiveauQualification niveauQualification;
	@ManyToOne
	@JsonIgnoreProperties("diplomes")
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	
	public Diplome() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cv getCv() {
		return cv;
	}

	public void setCv(Cv cv) {
		this.cv = cv;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Date getAnneeObtention() {
		return anneeObtention;
	}
	public void setAnneeObtention(Date anneeObtention) {
		this.anneeObtention = anneeObtention;
	}
	public NiveauQualification getNiveauQualification() {
		return niveauQualification;
	}
	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	
	
}
