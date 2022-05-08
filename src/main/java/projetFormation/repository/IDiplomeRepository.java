package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.Diplome;

@Repository
public interface IDiplomeRepository extends JpaRepository<Diplome, Long>{

	
	//select tt les Diplomes par Cv
	@Query("select d FROM Diplome d "
			+ "INNER JOIN Cv c  ON d.cv =c.id "
			+ "WHERE  c.id= :idCv")
    public List<Diplome> getALLByCvId(@Param("idCv")Long idCv);
	
	
}
