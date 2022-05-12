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


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import projetFormation.model.Candidat;
import projetFormation.service.CandidatService;

@Api(value = "CandidatRestController", description = "REST APIs related to Candidat Entity !!!!")
@RestController
@CrossOrigin(origins = "*")
public class CandidatController {

	@Autowired
	private CandidatService candidatService;
	

	
	//@ApiOperation(value = "Get list candidats", response = Candidat.class, tags = "getCandidats")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/candidats")
	public ResponseEntity<List<Candidat>> getCandidats() {
		return new ResponseEntity<>(candidatService.findAll(), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Get Offre Emploi by id", response = Candidat.class, tags = "getCandidat")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/candidats/{id}")
	public ResponseEntity<Candidat> getOneCandidat(@PathVariable("id") Long id) {
		Candidat candidat =candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		return new ResponseEntity<>(candidat, HttpStatus.OK);
	}
	
	//@ApiOperation(value = "ajouter un candidat", response = Candidat.class, tags = "add Candidat")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("/candidats")
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {
		
		return new ResponseEntity<Candidat>(candidatService.saveOrUpdate(candidat), HttpStatus.CREATED);
	}
	
	@PutMapping("/candidats/{id}")
	public ResponseEntity<Candidat> editOffreEmploi(@PathVariable("id") Long id, @RequestBody Candidat candidat) {
		Candidat candidatUpdate=candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		
		candidatUpdate.setCandidatOffreEmploi(candidat.getCandidatOffreEmploi());
		candidatUpdate.setCvs(candidat.getCvs());
		candidatUpdate.setDateNaissance(candidat.getDateNaissance());
		candidatUpdate.setDisponibilite(candidat.isDisponibilite());
		candidatUpdate.setEmail(candidat.getEmail());
		candidatUpdate.setLogin(candidat.getLogin());
		candidatUpdate.setNom(candidat.getNom());
		candidatUpdate.setPrenom(candidat.getPrenom());
		
		candidatService.saveOrUpdate(candidatUpdate);

		return new ResponseEntity<>(candidatUpdate, HttpStatus.OK);
	}
	
	@DeleteMapping("/candidats/{id}")
	public ResponseEntity<?> deleteCandidat(@PathVariable("id")Long id) {
		candidatService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Candidat n'existe pas pour id : " + id));
		
		candidatService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
}
