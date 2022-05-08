package projetFormation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
public class Formation {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private int numero;
	@Temporal(TemporalType.DATE)
	private Date anneeFormation;
	private int dureeFormation;
	private String organismeFormateur;
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	public Formation() {
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


	public Date getAnneeFormation() {
		return anneeFormation;
	}


	public void setAnneeFormation(Date anneeFormation) {
		this.anneeFormation = anneeFormation;
	}


	public int getDureeFormation() {
		return dureeFormation;
	}


	public void setDureeFormation(int dureeFormation) {
		this.dureeFormation = dureeFormation;
	}


	public String getOrganismeFormateur() {
		return organismeFormateur;
	}


	public void setOrganismeFormateur(String organismeFormateur) {
		this.organismeFormateur = organismeFormateur;
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
