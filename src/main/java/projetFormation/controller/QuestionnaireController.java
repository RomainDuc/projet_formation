package projetFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetFormation.model.Question;
import projetFormation.model.Questionnaire;
import projetFormation.service.QuestionService;
import projetFormation.service.QuestionnaireService;

@RestController
@CrossOrigin(origins = "*")
public class QuestionnaireController {
	
	@Autowired
	QuestionnaireService questionnaireService;
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/questionnaires")
	public ResponseEntity<List<Questionnaire>> getQuestionnaires() {
		return new ResponseEntity<>(questionnaireService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/questionnaires/{id}")
	public ResponseEntity<Questionnaire> getOneQuestionnaire(@PathVariable("id") Long id) {
		Questionnaire quest =questionnaireService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Questionnaire n'existe pas pour id : " + id));
		return new ResponseEntity<>(quest, HttpStatus.OK);
	}
	
	@PostMapping("/questionnaires")
	public ResponseEntity<Questionnaire> createQuestionnaire(@RequestBody Questionnaire quest) {
		return new ResponseEntity<>(questionnaireService.saveOrUpdate(quest), HttpStatus.CREATED);
	}
	
	@PutMapping("/questionnaires/{id}")
	public ResponseEntity<Questionnaire> editQuestionnaire(@PathVariable("id") Long id, @RequestBody Questionnaire Questionnaire) {
		Questionnaire questUpdate=questionnaireService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Questionnaire n'existe pas pour id : " + id));
		
		

		questionnaireService.saveOrUpdate(questUpdate);

		return new ResponseEntity<>(questUpdate, HttpStatus.OK);


	
	}

	@DeleteMapping("/questionnaires/{id}")
	public ResponseEntity<?> deleteQuestionnaire(@PathVariable("id")Long id) {
		questionnaireService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Questionnaire n'existe pas pour id : " + id));
		
		questionnaireService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
	//******************************************************************************************
	
	@GetMapping("/questions")
	public ResponseEntity<List<Question>> getQuestions() {
		return new ResponseEntity<>(questionService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/questions/{id}")
	public ResponseEntity<Question> getOneQuestions(@PathVariable("id") Long id) {
		Question quest =questionService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Question n'existe pas pour id : " + id));
		return new ResponseEntity<>(quest, HttpStatus.OK);
	}
	
	@PostMapping("/questions")
	public ResponseEntity<Question> createQuestions(@RequestBody Question quest) {
		return new ResponseEntity<>(questionService.saveOrUpdate(quest), HttpStatus.CREATED);
	}
	
	@PutMapping("/questions/{id}")
	public ResponseEntity<Question> editQuestions(@PathVariable("id") Long id, @RequestBody Question Questionnaire) {
		Question questUpdate=questionService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Question n'existe pas pour id : " + id));
		
		
		
		questionService.saveOrUpdate(questUpdate);

		return new ResponseEntity<>(questUpdate, HttpStatus.OK);


	
	}

	@DeleteMapping("/questions/{id}")
	public ResponseEntity<?> deleteQuestions(@PathVariable("id")Long id) {
		questionService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Question n'existe pas pour id : " + id));
		
		questionService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
