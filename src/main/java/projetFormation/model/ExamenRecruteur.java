package projetFormation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ExamenRecruteur {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JsonIgnoreProperties("examenRecruteurs")
	@JoinColumn(name = "examen_id")
	private Examen examen;
	@JsonIgnoreProperties("examenRecruteurs")
	@ManyToOne
	@JoinColumn(name = "recruteur_id")
	private Recruteur recruteur;
	
	public ExamenRecruteur() {
		super();
	}

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

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public Recruteur getRecruteur() {
		return recruteur;
	}

	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}
	
	

}
