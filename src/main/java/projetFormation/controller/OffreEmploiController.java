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

import projetFormation.model.OffreEmploi;
import projetFormation.service.CompetenceService;
import projetFormation.service.OffreEmploiService;

@RestController
public class OffreEmploiController {

	@Autowired
	private OffreEmploiService offreEmploiService;
	@Autowired
	private CompetenceService competenceService;

	@GetMapping("/offreEmplois")
	public ResponseEntity<List<OffreEmploi>> getOffreEmplois() {
		return new ResponseEntity<>(offreEmploiService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/offreEmplois/{id}")
	public ResponseEntity<OffreEmploi> getOneOffreEmploi(@PathVariable("id") Long id) {
		OffreEmploi offre =offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));
		return new ResponseEntity<>(offre, HttpStatus.OK);
	}

	@PostMapping("/offreEmplois")
	public ResponseEntity<OffreEmploi> createOffre(@RequestBody OffreEmploi offre) {
		return new ResponseEntity<>(offreEmploiService.saveOrUpdate(offre), HttpStatus.CREATED);
	}

	@PutMapping("/offreEmplois/{id}")
	public ResponseEntity<OffreEmploi> editOffreEmploi(@PathVariable("id") Long id, @RequestBody OffreEmploi offre) {
		offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));

		return new ResponseEntity<>(offreEmploiService.saveOrUpdate(offre), HttpStatus.OK);
	}

	@DeleteMapping("/offreEmplois/{id}")
	public ResponseEntity<?> deleteOffre(@PathVariable("id")Long id) {
		offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));
		
		offreEmploiService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
	@GetMapping("/offreEmplois/competence/{id}")
	public ResponseEntity<List<OffreEmploi>> getOffresByCompetence(@PathVariable Long id) {
		competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : " + id));
		
		return new ResponseEntity<>(offreEmploiService.findAllByCompetence(id), HttpStatus.OK);
		
	}
	
}
