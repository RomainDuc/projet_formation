package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Questionnaire;
import projetFormation.repository.IQuestionnaireRepository;

@Service(value = "questionnaireService")
public class QuestionnaireService implements IService<Questionnaire>{

	@Autowired
	private IQuestionnaireRepository questionnaireRepository;
	
	@Override
	public List<Questionnaire> findAll() {
		return questionnaireRepository.findAll();
	}

	@Override
	public Questionnaire saveOrUpdate(Questionnaire obj) {
		return questionnaireRepository.save(obj);
	}

	@Override
	public Optional<Questionnaire> getOne(Long id) {
		return questionnaireRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		questionnaireRepository.deleteById(id);
	}

}
