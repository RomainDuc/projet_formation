package projetFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projetFormation.model.Competence;
import projetFormation.service.CompetenceService;

@RestController
public class CompetenceController {

	
	@Autowired
	private CompetenceService competenceService;
	
	@PostMapping("/competences")
	public ResponseEntity<Competence> saveCompetence(@RequestBody Competence competence){
		return new ResponseEntity<>(competenceService.saveOrUpdate(competence), HttpStatus.CREATED);
		
	}
	
}
