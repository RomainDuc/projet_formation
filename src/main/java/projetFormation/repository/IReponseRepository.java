package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.model.Reponse;

public interface IReponseRepository extends JpaRepository<Reponse, Long> {
	
	
	// liste des reponses pour chaque question 
	@Query("SELECT r FROM Reponse r "
			+ "INNER JOIN Question q ON r.question= q.id "
			+ "WHERE q.id= :idQuestion")
	public List<Reponse> getAllByQuestion (@Param("idQuestion") Long idQuestion);

}
