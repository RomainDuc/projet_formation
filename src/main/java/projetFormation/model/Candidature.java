package projetFormation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Candidature {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "candidat_id")
	private Candidat candidat;
	@ManyToOne
	@JoinColumn(name = "Offre_id")
	private OffreEmploi offre;
	
	
	
	
	public Candidature() {
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


	public Candidat getCandidat() {
		return candidat;
	}


	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}


	public OffreEmploi getOffre() {
		return offre;
	}


	public void setOffre(OffreEmploi offre) {
		this.offre = offre;
	}

	
	
}
