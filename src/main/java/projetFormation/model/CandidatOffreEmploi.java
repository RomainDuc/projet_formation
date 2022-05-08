package projetFormation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class CandidatOffreEmploi {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "candidat_id")
	private Candidat candidat;
	@ManyToOne
	@JoinColumn(name = "offre_id")
	private OffreEmploi offreEmploi;
	
	public CandidatOffreEmploi() {
		
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

	public OffreEmploi getOffreEmploi() {
		return offreEmploi;
	}

	public void setOffreEmploi(OffreEmploi offreEmploi) {
		this.offreEmploi = offreEmploi;
	}

	@Override
	public String toString() {
		return "CandidatOffreEmploi [version=" + version + ", candidat=" + candidat + ", offreEmploi=" + offreEmploi
				+ "]";
	}
	
	
	
	
	

}
