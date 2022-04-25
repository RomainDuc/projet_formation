package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.OffreEmploi;

@Repository
public interface IOffreEmploiRepository extends JpaRepository<OffreEmploi, Long> {
	
	@Query("select o from OffreEmploi o "
			+ "INNER JOIN CompetenceOffreEmploi co ON co.offreEmploi= o.id "
			+ "INNER JOIN Competence c ON co.competence = c.id  WHERE c.id= :idCompetence")
	public List<OffreEmploi> findAllByCompetence(@Param("idCompetence") Long idCompetence);

	
}
