package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.Competence;



@Repository
public interface ICompetenceRepository extends JpaRepository<Competence, Long>{

	//select tt les competences par Cv
	@Query("select comp FROM Competence comp "
			+ "INNER JOIN Cv c  ON comp.cv =c.id "
			+ "WHERE  c.id= :idCv")
    public List<Competence> getALLByCv(@Param("idCv")Long idCv);
	
}