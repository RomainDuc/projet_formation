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

import projetFormation.model.Candidat;
import projetFormation.service.CandidatService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class CandidatController {
	@Autowired
	CandidatService candidatService;

	
	@GetMapping("/candidats")
	public ResponseEntity<List<Candidat>> getCandidats() {
		return new ResponseEntity<>(candidatService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/candidats/{id}")
	public ResponseEntity<Candidat> getOneCandidat(@PathVariable("id") Long id) {
		Candidat cand =candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		return new ResponseEntity<>(cand, HttpStatus.OK);
	}
	
	@PostMapping("/candidats")
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat cand) {
		return new ResponseEntity<>(candidatService.saveOrUpdate(cand), HttpStatus.CREATED);
	}
	
	@PutMapping("/candidats/{id}")
	public ResponseEntity<Candidat> editCandidat(@PathVariable("id") Long id, @RequestBody Candidat candidat) {
		candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		
		candidat.setId(id);
		
		candidatService.saveOrUpdate(candidat);

		return new ResponseEntity<>(candidat, HttpStatus.OK);


	
	}
	
	@DeleteMapping("/candidats/{id}")
	public ResponseEntity<?> deleteCandidat(@PathVariable("id")Long id) {
		candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		
		candidatService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
}
