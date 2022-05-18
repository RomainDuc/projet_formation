package projetFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import projetFormation.model.Cv;

@Repository
public interface ICvRepository extends JpaRepository<Cv, Long>{
	
	
	//liste des CV par candidat 
	@Query("select c FROM Cv c WHERE c.id= :idCandidat ")
	List<Cv> findByCandidatId(Long idCandidat);
	
	
	//trouver le cv avec idcv pour un candidat
	@Query("select c FROM Cv c  INNER JOIN Candidat cd WHERE c.id= ?1 AND cd.id= ?2")
	Optional<Cv> findByIdAndCandidatId(Long cvId, Long candidatId);
	
	
	
	
}
