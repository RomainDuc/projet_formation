package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import projetFormation.model.ExperienceProfessionelle;

@Repository
public interface IExperienceProfessionelleRepository extends JpaRepository<ExperienceProfessionelle, Long>{

	//affiche la liste des experience pro pour chaque cv
	@Query("select exp FROM ExperienceProfessionelle exp "
			+ "INNER JOIN Cv c  ON exp.cv =c.id "
			+ "WHERE  c.id= :idCv")
    public List<ExperienceProfessionelle> getALLByCv(@Param("idCv")Long idCv);
}
