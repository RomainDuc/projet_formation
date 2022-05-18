package projetFormation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetFormation.model.Candidat;
import projetFormation.service.CandidatService;

@RestController
@CrossOrigin(origins ="*" )
public class LoginController {
	
	@Autowired
	CandidatService candidatService;
	
	
	@GetMapping("/login/{login}/{password}")
	public ResponseEntity<Candidat> loginCandidat(@PathVariable String login, @PathVariable String password) {
		Candidat mecLogin = candidatService.loginCandidat(login, password).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Aucun compte retrouvé pour ce login ou ce password"));
		
		
		return new ResponseEntity<>(mecLogin, HttpStatus.OK);
	}
	
	

}
