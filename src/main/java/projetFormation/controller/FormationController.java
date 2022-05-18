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

import projetFormation.model.Formation;
import projetFormation.service.FormationService;

@RestController
@CrossOrigin("*")
public class FormationController {
	@Autowired
	private FormationService formationService;
	
	@GetMapping("/formations")
	public ResponseEntity<List<Formation>> getFormations(){
		return new ResponseEntity<>(formationService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/formations/cv/{id}")
	public ResponseEntity<List<Formation>> getAllByCv(@PathVariable("id") Long id){
		return new ResponseEntity<>(formationService.getAllByCv(id), HttpStatus.OK);
	}
	
	@GetMapping("/formation/{id}")
	public ResponseEntity<Formation> getOneFormation(@PathVariable("id") Long id) {
		Formation formation = formationService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"la formation n'existe pas pour id : " + id));
		return new ResponseEntity<>(formation, HttpStatus.OK);
	}
	
	// CREATION D'UNE FORMATION
	@PostMapping("/formation")
	public ResponseEntity<Formation> saveFormation(@RequestBody Formation formation){
		return new ResponseEntity<>(formationService.saveOrUpdate(formation), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/formation/{id}")
	public ResponseEntity<Formation> editFormation(@PathVariable("id") Long id, @RequestBody Formation formation) {
		Formation formationUpDate = formationService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		formationUpDate.setNumero(formation.getNumero());
		formationUpDate.setAnneeFormation(formation.getAnneeFormation());
		formationUpDate.setDureeFormation(formation.getDureeFormation());
		formationUpDate.setOrganismeFormateur(formation.getOrganismeFormateur());
		
		
		
		formationService.saveOrUpdate(formationUpDate);
		
		return new ResponseEntity<>(formationUpDate, HttpStatus.OK);

	
	}
	
	@DeleteMapping("/formation/{id}")
	public ResponseEntity<?> deleteFormation(@PathVariable("id")Long id) {
		formationService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		formationService.delete(id);
		
		
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
}
