package projetFormation.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import projetFormation.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long>{
	
	
	//affiche la liste des tout les question pour chaque questionnaire
	@Query("SELECT q FROM Question q "
			+ "INNER JOIN Questionnaire qr ON q.questionnaire = qr.id "
			+ "WHERE qr.id= :idQuestionnaire")
	public List<Question> getAllbyQuestionnaire(@Param("idQuestionnaire")Long idQuestionnaire);
	

}
