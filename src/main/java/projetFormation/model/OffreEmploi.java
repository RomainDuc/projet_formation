package projetFormation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;


@Entity
public class OffreEmploi {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Version
	private int version;
	
	@Column(length = 150)
	private String categorieOffre;
	
	@Column(length = 250)
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date datePublication;
	
	@Temporal(TemporalType.DATE)
	private Date dateLimite;
	
	@Column(name = "salaire")
	private int salaire;
	
	@Column(name = "experienceSouhaite")
	private int experienceSouhaite;
	
	@Enumerated(EnumType.STRING)
	private NiveauQualification niveauQualification;
	
	
	@Enumerated(EnumType.STRING)
	private TypeContrat typeContrat;
	
	@Enumerated(EnumType.STRING)
	private Statut statue;
	

	@OneToMany(mappedBy = "offre")
	private List<Candidature>  candidatOffres;
	@OneToMany(mappedBy = "offreEmploi")
	private List<CompetenceOffreEmploi> competenceOffres;
	@ManyToOne
	@JoinColumn(name = "recruteur_id")
	private Recruteur recruteur;
	@ManyToOne
	@JoinColumn(name = "lieu_id")
	private Lieu lieu;
	
	
	public OffreEmploi() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public String getCategorieOffre() {
		return categorieOffre;
	}


	public void setCategorieOffre(String categorieOffre) {
		this.categorieOffre = categorieOffre;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDatePublication() {
		return datePublication;
	}


	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}


	public Date getDateLimite() {
		return dateLimite;
	}


	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
	}


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public int getExperienceSouhaite() {
		return experienceSouhaite;
	}


	public void setExperienceSouhaite(int experienceSouhaite) {
		this.experienceSouhaite = experienceSouhaite;
	}


	public NiveauQualification getNiveauQualification() {
		return niveauQualification;
	}


	public void setNiveauQualification(NiveauQualification niveauQualification) {
		this.niveauQualification = niveauQualification;
	}


	public TypeContrat getTypeContrat() {
		return typeContrat;
	}


	public void setTypeContrat(TypeContrat typeContrat) {
		this.typeContrat = typeContrat;
	}


	public Statut getStatue() {
		return statue;
	}


	public void setStatue(Statut statue) {
		this.statue = statue;
	}


	public List<Candidature> getCandidatOffres() {
		return candidatOffres;
	}


	public void setCandidatOffres(List<Candidature> candidatOffres) {
		this.candidatOffres = candidatOffres;
	}


	public List<CompetenceOffreEmploi> getCompetenceOffres() {
		return competenceOffres;
	}


	public void setCompetenceOffres(List<CompetenceOffreEmploi> competenceOffres) {
		this.competenceOffres = competenceOffres;
	}


	public Recruteur getRecruteur() {
		return recruteur;
	}


	public void setRecruteur(Recruteur recruteur) {
		this.recruteur = recruteur;
	}


	public Lieu getLieu() {
		return lieu;
	}


	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	
	
	
	
	
	
}
