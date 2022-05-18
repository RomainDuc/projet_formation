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

import projetFormation.model.Competence;

import projetFormation.service.CompetenceService;

@RestController
@CrossOrigin("*")

public class CompetenceController {

	
	@Autowired
	private CompetenceService competenceService;
	
	@GetMapping("/competences")
	public ResponseEntity<List<Competence>> getCompetences(){
		return new ResponseEntity<>(competenceService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/competence/{id}")
	public ResponseEntity<Competence> getOneCompetence(@PathVariable("id") Long id) {
		Competence quest = competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		return new ResponseEntity<>(quest, HttpStatus.OK);
	}
	
	@PutMapping("/competence/{id}")
	public ResponseEntity<Competence> editCompetence(@PathVariable("id") Long id, @RequestBody Competence competence) {
		Competence competenceUpdate=competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		competenceUpdate.setNom(competence.getNom());
		competenceUpdate.setDescription(competence.getDescription());
		competenceUpdate.setNiveauAptitudes(competence.getNiveauAptitudes());
		competenceUpdate.setCompetenceOffres(competence.getCompetenceOffres());
		competenceUpdate.setCv(competence.getCv());
		competenceUpdate.setVersion(competence.getVersion());
		
		competenceService.saveOrUpdate(competenceUpdate);
		
		return new ResponseEntity<>(competenceUpdate, HttpStatus.OK);

	
	}
	
	@PostMapping("/competences")
	public ResponseEntity<Competence> saveCompetence(@RequestBody Competence competence){
		return new ResponseEntity<>(competenceService.saveOrUpdate(competence), HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/competences/{id}")
	public ResponseEntity<?> deleteCompetence(@PathVariable("id")Long id) {
		competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		competenceService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
}
