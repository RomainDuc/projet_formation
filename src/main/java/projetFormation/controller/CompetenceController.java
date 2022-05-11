package projetFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetFormation.model.Competence;
import projetFormation.model.Cv;
import projetFormation.service.CompetenceService;
import projetFormation.service.CvService;

@RestController
public class CompetenceController {

	
	@Autowired
	private CompetenceService competenceService;
	@Autowired
	private CvService cvService;
	
	
	@GetMapping("/competences")
	public ResponseEntity<List<Competence>> getCompetences() {
		return new ResponseEntity<>(competenceService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/competences/{id}")
	public ResponseEntity<Competence> getOneCompetence(@PathVariable Long id) {
		Competence comp = competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competence non trouvée pour id : "+ id));
		return new ResponseEntity<>(comp, HttpStatus.OK);
	}
	
	@GetMapping("/cv/{id}/competence")
	public ResponseEntity<List<Competence>> getALLByCv(@PathVariable Long idCv) {
		return new ResponseEntity<>(competenceService.FindAllByCv(idCv), HttpStatus.OK);
	}
	
	
	
//	@PostMapping("/cv/{id}/competence")
//	public ResponseEntity<Competence>  saveCompetence(@RequestBody Competence comp,@PathVariable Long id) {
//		 Cv cv = cvService.geCvById(id);
//		 comp.setCv(cv);
//		
//		return new ResponseEntity<>(competenceService.saveOrUpdate(comp), HttpStatus.CREATED);
//	}
	
	@PutMapping("/competences/{id}")
	public ResponseEntity<Competence> updateCompetence(@PathVariable("id") Long id,@RequestBody Competence competence) {
		competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competence non trouvée pour id : "+ id));
		
		return new ResponseEntity<>(competenceService.saveOrUpdate(competence), HttpStatus.OK);
	}
	
	@DeleteMapping("/competences/{id}")
	public ResponseEntity<?> deleteCompetenceById(@PathVariable Long id) {
		competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competence non trouvée pour id : "+ id));
		competenceService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESFULLY", HttpStatus.OK);
	}
	
	
	
}
