package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Question;
import projetFormation.repository.IQuestionRepository;

@Service(value = "questionService")
public class QuestionService implements IService<Question>{
	
	@Autowired
	private IQuestionRepository questionRepository;

	@Override
	public List<Question> findAll() {
		return questionRepository.findAll();
	}

	@Override
	public Question saveOrUpdate(Question obj) {
		return questionRepository.save(obj);
	}

	@Override
	public Optional<Question> getOne(Long id) {
		return questionRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		questionRepository.deleteById(id);
	}

}
