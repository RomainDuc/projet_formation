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


import projetFormation.model.Diplome;

import projetFormation.service.DiplomeService;

@RestController
@CrossOrigin("*")
public class DiplomeController {

	@Autowired
	private DiplomeService diplomeService;
	
	@GetMapping("/diplomes")
	public ResponseEntity<List<Diplome>> getDiplomes(){
		return new ResponseEntity<>(diplomeService.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/diplomes/{id}")
	public ResponseEntity<Diplome> getOneCompetence(@PathVariable("id") Long id) {
		Diplome diplome = diplomeService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		return new ResponseEntity<>(diplome, HttpStatus.OK);
	}
	
	@PostMapping("/diplome")
	public ResponseEntity<Diplome> saveDiplome(@RequestBody Diplome diplome){
		return new ResponseEntity<>(diplomeService.saveOrUpdate(diplome), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/diplome/{id}")
	public ResponseEntity<Diplome> editDiplome(@PathVariable("id") Long id, @RequestBody Diplome diplome) {
		Diplome diplomeUpDate = diplomeService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		diplomeUpDate.setNom(diplome.getNom());
		diplomeUpDate.setAnneeObtention(diplome.getAnneeObtention());
		diplomeUpDate.setNiveauQualification(diplome.getNiveauQualification());
		diplomeUpDate.setCv(diplome.getCv());
		diplomeUpDate.setVersion(diplome.getVersion());
		
		diplomeService.saveOrUpdate(diplomeUpDate);
		
		return new ResponseEntity<>(diplomeUpDate, HttpStatus.OK);

	
	}
	
	@DeleteMapping("/diplome/{id}")
	public ResponseEntity<?> deleteDiplome(@PathVariable("id")Long id) {
		diplomeService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		diplomeService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
}
