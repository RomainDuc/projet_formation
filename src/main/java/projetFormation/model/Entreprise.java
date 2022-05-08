package projetFormation.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Entreprise {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private String description;
	private String urlEntreprise;
	private int nbreSalaries;
	@OneToMany(mappedBy = "entreprise")
	private List<Recruteur> recruteurs;
	
	
	
	public Entreprise() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getUrlEntreprise() {
		return urlEntreprise;
	}


	public void setUrlEntreprise(String urlEntreprise) {
		this.urlEntreprise = urlEntreprise;
	}


	public int getNbreSalaries() {
		return nbreSalaries;
	}


	public void setNbreSalaries(int nbreSalaries) {
		this.nbreSalaries = nbreSalaries;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public List<Recruteur> getRecruteurs() {
		return recruteurs;
	}


	public void setRecruteurs(List<Recruteur> recruteurs) {
		this.recruteurs = recruteurs;
	}
	
}
