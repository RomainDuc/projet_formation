package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.Formation;


@Repository
public interface IFormationRepository extends JpaRepository<Formation, Long>{

	
	//select tt les Formations par Cv
	@Query("select f FROM Formation f "
			+ "INNER JOIN Cv c  ON f.cv =c.id "
			+ "WHERE  c.id= :idCv")
    public List<Formation> getAllByCv(Long idCv);
	
}
