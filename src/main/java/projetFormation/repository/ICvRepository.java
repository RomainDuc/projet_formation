package projetFormation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetFormation.model.Cv;

@Repository
public interface ICvRepository extends JpaRepository<Cv, Long>{

	List<Cv> findByCandidatId(Long id);
	
	Optional<Cv> findByIdAndCandidatId(Long cvId, Long candidatId);
}
