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

import projetFormation.service.ExperienceProfessionelleService;

import projetFormation.model.ExperienceProfessionelle;

@RestController
@CrossOrigin("*")
public class ExperienceProfessionelleController {
	@Autowired
	private ExperienceProfessionelleService experienceProfessionelleService;
	
	@GetMapping("/experienceProfessionelles")
	public ResponseEntity<List<ExperienceProfessionelle>> getExperienceProfessionelles(){
		return new ResponseEntity<>(experienceProfessionelleService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/experienceProfessionelle/{id}")
	public ResponseEntity<ExperienceProfessionelle> getOneExperence(@PathVariable("id") Long id) {
		ExperienceProfessionelle experienceProfessionelle = experienceProfessionelleService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		return new ResponseEntity<>(experienceProfessionelle, HttpStatus.OK);
	}
	
	@PostMapping("/experienceProfessionelle")
	public ResponseEntity<ExperienceProfessionelle> saveExperiencePro(@RequestBody ExperienceProfessionelle exp){
		return new ResponseEntity<>(experienceProfessionelleService.saveOrUpdate(exp), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/experienceProfessionelle/{id}")
	public ResponseEntity<ExperienceProfessionelle> editExperience(@PathVariable("id") Long id, @RequestBody ExperienceProfessionelle exp) {
		ExperienceProfessionelle expUpDate = experienceProfessionelleService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		expUpDate.setNumero(exp.getNumero());
		expUpDate.setDescription(exp.getDescription());
		expUpDate.setAnneeExperience(exp.getAnneeExperience());
		expUpDate.setEntreprise(exp.getEntreprise());
		expUpDate.setCv(exp.getCv());
		
		
		experienceProfessionelleService.saveOrUpdate(expUpDate);
		
		return new ResponseEntity<>(expUpDate, HttpStatus.OK);

	
	}
	
	@DeleteMapping("/experienceProfessionelle/{id}")
	public ResponseEntity<?> deleteDiplome(@PathVariable("id")Long id) {
		experienceProfessionelleService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		experienceProfessionelleService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
}
