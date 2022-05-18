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

import projetFormation.model.Cv;
import projetFormation.model.Formation;
import projetFormation.service.CvService;
import projetFormation.service.FormationService;

@RestController
@CrossOrigin("*")
public class CvController {
	
	@Autowired
	private CvService cvService;
	
	//RETOURNE TOUS LES CVS DU CANDIDAT
	@GetMapping("/cvs")
	public ResponseEntity<List<Cv>> getCvs(){
		return new ResponseEntity<>(cvService.findAll(), HttpStatus.OK);
	}
	
	//RETOURNE TOUS UN CV D'UN CANDIDAT
	@GetMapping("/cv/{id}")
	public ResponseEntity<Cv> getOneFormation(@PathVariable("id") Long id) {
		Cv cv = cvService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"le cv n'existe pas pour id : " + id));
		return new ResponseEntity<>(cv, HttpStatus.OK);
	}
	
	//RETOURNE TOUS LES CVS D'UN CANDIDAT
	@GetMapping("/cvs/candidat/{id}")
	public ResponseEntity<List<Cv>> getCvsByCandidat(@PathVariable("id") Long id){
		return new ResponseEntity<>(cvService.getCvsByCandidat(id), HttpStatus.OK);
	}
	
	// CREATION D'UNE FORMATION
	@PostMapping("/cv")
	public ResponseEntity<Cv> saveFormation(@RequestBody Cv cv){
		return new ResponseEntity<>(cvService.saveOrUpdate(cv), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/cv/{id}")
	public ResponseEntity<Cv> editFormation(@PathVariable("id") Long id, @RequestBody Cv cv) {
		Cv cvUpDate = cvService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		cvUpDate.setCompetences(cv.getCompetences());
		cvUpDate.setDiplomes(cv.getDiplomes());
		cvUpDate.setExperiencesProfessionelles(cv.getExperiencesProfessionelles());
		cvUpDate.setFormations(cv.getFormations());
		
		
		
		cvService.saveOrUpdate(cvUpDate);
		
		return new ResponseEntity<>(cvUpDate, HttpStatus.OK);

	
	}
	
	@DeleteMapping("/cv/{id}")
	public ResponseEntity<?> deleteFormation(@PathVariable("id")Long id) {
		cvService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"le cv n'existe pas pour id : " + id));
		
		cvService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
