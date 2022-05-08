package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.OffreEmploi;

@Repository
public interface IOffreEmploiRepository extends JpaRepository<OffreEmploi, Long> {
	
	
	@Query("select o FROM OffreEmploi o "
			+ "INNER JOIN CompetenceOffreEmploi co ON co.offreEmploi = o.id "
			+"INNER JOIN Competence c ON co.competence = c.id "
			+ "WHERE  c.id= :idCompetence")
	public List<OffreEmploi> findAllByCompetance(@Param("idCompetence") Long idCompetance);
	

	@Query("select o From OffreEmploi o WHERE o.lieu= idLieu")
	public List<OffreEmploi> findAllByLieu(@Param("idLieu") Long idLieu);
	
	//autre methode de requete
	//liste des offres par lieu 
	//@Query("select o From OffreEmploi o WHERE o.lieu= ?1")
	//public List<OffreEmploi> findAllByLieu( Long idLieu);
	
	// liste des offres publié par recruteur 
	@Query("select o FROM OffreEmploi o WHERE o.recruteur= ?1")
	public List<OffreEmploi> findAllByRecruteur(Long idRecruteur);
	
	
	// liste des Offres par candidat (sans @param)
	@Query("select o FROM OffreEmploi o "
				+ "INNER JOIN CandidatOffreEmploi co ON co.offreEmploi = o.id "
				+"INNER JOIN Candidat c ON co.candidat = c.id "
				+ "WHERE  c.id= ?1")
	public List<OffreEmploi> getAllByCandidat (Long idCandidat);

}
