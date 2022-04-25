package projetFormation.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long>{

}
