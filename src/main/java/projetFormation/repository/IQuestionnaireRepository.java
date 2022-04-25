package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Questionnaire;

public interface IQuestionnaireRepository extends JpaRepository<Questionnaire, Long>{

}
