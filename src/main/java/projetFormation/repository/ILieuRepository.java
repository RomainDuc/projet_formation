package projetFormation.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.model.Lieu;

public interface ILieuRepository extends JpaRepository<Lieu,Long>{
	
	// affiche le lieu de l'offre d'emploi avec l'idOffreEmploi 
	@Query("SELECT l FROM Lieu l "
			+ "INNER JOIN OffreEmploi oe ON oe.lieu =l.id "
			+ "WHERE oe.id= :idOffreEmploi")
	public Lieu getByOffreEmploi(@Param("idOffreEmploi") Long idOffreEmploi);
	
	
	public List<Lieu> findAllByVille(String ville);
	
	

}
