package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projetFormation.model.Examen;



public interface IExamenRepository extends JpaRepository<Examen, Long>{
	
	
	
	// liste des examen publié par un recruteur 
	@Query("select ex FROM Examen ex "
			+ "INNER JOIN RecruteurExamen re ON re.examen = ex.id "
			+"INNER JOIN Recruteur r ON re.recruteur = ex.id "
			+ "WHERE  ex.id= :idRecruteur")
	public List<Examen> getAllByRecruteur(Long idRecruteur);
	
	
	// affiche l'examen pour chaque offre d'emploi
	@Query("SELECT ex FROM Examen ex WHERE ex.offreEmploi= :idOffreEmploi")
	public Examen getByOffreEmploi(@Param("idOffreEmploi") Long idOffreEmploi) ;

}
