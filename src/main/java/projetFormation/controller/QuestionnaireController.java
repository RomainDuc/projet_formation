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
import projetFormation.model.Reponse;
import projetFormation.service.QuestionService;
import projetFormation.service.QuestionnaireService;
import projetFormation.service.ReponseService;

@RestController
@CrossOrigin(origins = "*")
public class QuestionnaireController {
	
	@Autowired
	private QuestionnaireService questionnaireService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private ReponseService reponseService;
	
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
	
	
	//**************************************************************************************************
	
	@GetMapping("/reponses")
	public ResponseEntity<List<Reponse>> getReponses() {
		return new ResponseEntity<>(reponseService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/reponses/{id}")
	public ResponseEntity<Reponse> getOneReponse(@PathVariable("id") Long id) {
		Reponse quest =reponseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Reponse n'existe pas pour id : " + id));
		return new ResponseEntity<>(quest, HttpStatus.OK);
	}
	
	@GetMapping("/questions/{idQuestion}/reponses")
	public ResponseEntity<List<Reponse>> getAllByQuestion(@PathVariable Long idQuestion) {
		questionService.getOne(idQuestion).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Question n'existe pas pour id : " + idQuestion));
		return new ResponseEntity<>(reponseService.getAllByQuestion(idQuestion), HttpStatus.OK);
	}
	
	
	@PostMapping("/reponses")
	public ResponseEntity<Reponse> createReponse(@RequestBody Reponse reponse) {
		return new ResponseEntity<>(reponseService.saveOrUpdate(reponse), HttpStatus.CREATED);
	}
	
	@PutMapping("/reponses/{id}")
	public ResponseEntity<Reponse> editReponse(@PathVariable("id") Long id, @RequestBody Reponse reponse) {
		Reponse respUpdate=reponseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Reponse n'existe pas pour id : " + id));
		
		
		
		reponseService.saveOrUpdate(respUpdate);

		return new ResponseEntity<>(respUpdate, HttpStatus.OK);


	
	}

	@DeleteMapping("/reponses/{id}")
	public ResponseEntity<?> deleteReponse(@PathVariable("id")Long id) {
		reponseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Reponse n'existe pas pour id : " + id));
		
		reponseService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
