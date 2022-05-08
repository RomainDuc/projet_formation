package projetFormation.config.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import projetFormation.model.NiveauQualification;
import projetFormation.model.Statut;
import projetFormation.model.TypeContrat;

public class OffreEmploiDto {
	



		@NotEmpty
		@Size(min=2,max =16 , message="first Name must be between 2 and 16 caracters")
		private String categorieOffre;
		@NotEmpty
		@Size(min=2,max =16 , message="Last Name must be between 2 and 16 caracters")
		private String description;
		@NotNull
		@Range(min=1 , max=10000, message="salaire shoud be not null or negatif and less than 10000")
		private Integer salaire;
		
		
		

		
		@Temporal(TemporalType.DATE)
		private Date datePublication;
		
		@Temporal(TemporalType.DATE)
		private Date dateLimite;
		

		
		@Column(name = "experienceSouhaite")
		private int experienceSouhaite;
		
		@Enumerated(EnumType.STRING)
		private NiveauQualification niveauQualification;
		
		
		@Enumerated(EnumType.STRING)
		private TypeContrat typeContrat;
		
		@Enumerated(EnumType.STRING)
		private Statut statue;

}
