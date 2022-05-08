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
import projetFormation.model.Entreprise;
import projetFormation.service.EntrepriseService;


@Api(value = "EntrepriseRestController", description = "REST APIs related to Entreprise Entity !!!!")
@RestController
@CrossOrigin(origins = "*")
public class EntrepriseController {
	
	@Autowired
	private EntrepriseService entrepriseService;
	
	@ApiOperation(value = "Get list entreprises", response = Entreprise.class, tags = "getEntreprises")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/entreprises")
	public ResponseEntity<List<Entreprise>> getEntreprises() {
		return new ResponseEntity<>(entrepriseService.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Offre Emploi by id", response = Entreprise.class, tags = "getEntreprise")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/entreprises/{id}")
	public ResponseEntity<Entreprise> getOneEntreprise(@PathVariable("id") Long id) {
		Entreprise entreprise =entrepriseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Entreprise n'existe pas pour id : " + id));
		return new ResponseEntity<>(entreprise, HttpStatus.OK);
	}
	
	@ApiOperation(value = "ajouter une entreprise", response = Entreprise.class, tags = "add Entreprise")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("/entreprises")
	public ResponseEntity<Entreprise> createEntreprise(@RequestBody Entreprise entreprise) {
		
		return new ResponseEntity<>(entrepriseService.saveOrUpdate(entreprise), HttpStatus.CREATED);
	}
	
	@PutMapping("/entreprises/{id}")
	public ResponseEntity<Entreprise> editOffreEmploi(@PathVariable("id") Long id, @RequestBody Entreprise entreprise) {
		entrepriseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Entreprise n'existe pas pour id : " + id));

		return new ResponseEntity<>(entrepriseService.saveOrUpdate(entreprise), HttpStatus.OK);
	}
	
	@DeleteMapping("/entreprises/{id}")
	public ResponseEntity<?> deleteEntreprise(@PathVariable("id")Long id) {
		entrepriseService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Entreprise n'existe pas pour id : " + id));
		
		entrepriseService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
