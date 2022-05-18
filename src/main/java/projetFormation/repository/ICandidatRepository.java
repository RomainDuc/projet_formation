package projetFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.model.Candidat;



public interface ICandidatRepository extends JpaRepository<Candidat, Long>{
	
	
	
	// liste des caniddat par offre
	@Query("select c FROM Candidat c "
			+ "INNER JOIN CandidatOffreEmploi co ON co.candidat = c.id "
			+"INNER JOIN OffreEmploi oe ON co.offreEmploi = oe.id "
			+ "WHERE  oe.id= :idOffreEmploi")
	public List<Candidat> getAllByOffresEmploi (@Param("idOffreEmploi") Long idOffreEmploi);
	
	public Optional<Candidat>  findByLoginAndPassword(String login, String password);


}
