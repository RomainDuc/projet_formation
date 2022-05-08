package projetFormation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import projetFormation.model.Recruteur;

public interface IRecruteurRepository extends JpaRepository<Recruteur, Long>{
	
	
	//select les recruteur qui sont publié un examen avec id= id.examen 
	@Query("select r FROM Recruteur r "
			+ "INNER JOIN RecruteurExamen re ON re.recruteur = r.id "
			+"INNER JOIN Examen ex ON re.examen = r.id "
			+ "WHERE  r.id= :idExamen")
	public List<Recruteur> getAllByExamen(Long idExamen);
	
	

}
