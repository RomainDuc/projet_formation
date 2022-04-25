package projetFormation.model;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Lieu {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	
	@Column(name = "adresse", length = 100)
	private String adresse;
	
	@Column(name = "codePostal", length = 10)
	private String codePostal;
	
	@Column(name = "city", length = 100)
	private String ville;
	
	@Column(name = "region", length = 100)
	private String region;
	
	@Column(name = "pays", length = 100)
	private String pays;
	
	@OneToMany(mappedBy = "lieu")
	private List<OffreEmploi> offreEmplois;
	
	public Lieu() {
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}


	public List<OffreEmploi> getOffreEmplois() {
		return offreEmplois;
	}

	public void setOffreEmplois(List<OffreEmploi> offreEmplois) {
		this.offreEmplois = offreEmplois;
	}

	

	

}

