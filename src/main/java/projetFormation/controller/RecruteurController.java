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
import projetFormation.model.Recruteur;
import projetFormation.service.RecruteurService;

@Api(value = "RecruteurRestController", description = "REST APIs related to Recruteur Entity !!!!")
@RestController
@CrossOrigin(origins = "*")
public class RecruteurController {

	@Autowired
	private RecruteurService recruteurService;
	

	
	@ApiOperation(value = "Get list recruteurs", response = Recruteur.class, tags = "getRecruteurs")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/recruteurs")
	public ResponseEntity<List<Recruteur>> getRecruteurs() {
		return new ResponseEntity<>(recruteurService.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get Offre Emploi by id", response = Recruteur.class, tags = "getRecruteur")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/recruteurs/{id}")
	public ResponseEntity<Recruteur> getOneRecruteur(@PathVariable("id") Long id) {
		Recruteur recruteur =recruteurService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Recruteur n'existe pas pour id : " + id));
		return new ResponseEntity<>(recruteur, HttpStatus.OK);
	}
	
	@ApiOperation(value = "ajouter un recruteur", response = Recruteur.class, tags = "add Recruteur")
	//@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("/recruteurs")
	public ResponseEntity<Recruteur> createRecruteur(@RequestBody Recruteur recruteur) {
		
		return new ResponseEntity<Recruteur>(recruteurService.saveOrUpdate(recruteur), HttpStatus.CREATED);
	}
	
	@PutMapping("/recruteurs/{id}")
	public ResponseEntity<Recruteur> editOffreEmploi(@PathVariable("id") Long id, @RequestBody Recruteur recruteur) {
		Recruteur recruteurUpdate=recruteurService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Recruteur n'existe pas pour id : " + id));
		
		recruteurUpdate.setEmail(recruteur.getEmail());
		recruteurUpdate.setEntreprise(recruteur.getEntreprise());
		recruteurUpdate.setExamenRecruteurs(recruteur.getExamenRecruteurs());
		recruteurUpdate.setLogin(recruteur.getLogin());
		recruteurUpdate.setMatriculeRecruteur(recruteur.getMatriculeRecruteur());
		recruteurUpdate.setNom(recruteur.getNom());
		recruteurUpdate.setNotifications(recruteur.getNotifications());
		recruteurUpdate.setOffres(recruteur.getOffres());
		recruteurUpdate.setPrenom(recruteur.getPrenom());
		
		recruteurService.saveOrUpdate(recruteurUpdate);

		return new ResponseEntity<>(recruteurUpdate, HttpStatus.OK);
	}
	
	@DeleteMapping("/recruteurs/{id}")
	public ResponseEntity<?> deleteRecruteur(@PathVariable("id")Long id) {
		recruteurService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Recruteur n'existe pas pour id : " + id));
		
		recruteurService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
}
