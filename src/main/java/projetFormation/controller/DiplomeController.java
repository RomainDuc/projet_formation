package projetFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetFormation.model.Cv;
import projetFormation.model.Diplome;
import projetFormation.service.CvService;
import projetFormation.service.DiplomeService;

//@Api(value = "DiplomeRestController", description = "REST APIs related to Diplome Entity !!!!")
@RestController
public class DiplomeController {
	
	@Autowired
	DiplomeService diplomeService;
	
	@Autowired
	CvService cvService;
	
	
	//@ApiOperation(value = "Get list diplomes", response = Diplome.class, tags = "getDiplomes")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/diplomes")
	public ResponseEntity<List<Diplome>> getDiplomes() {
		return new ResponseEntity<>(diplomeService.findAll(), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Get diplomes by id", response = Diplome.class, tags = "getOneDiplome")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/diplomes/{id}")
	public ResponseEntity<Diplome> getOneDiplome(@PathVariable("id") Long id) {
		Diplome diplome =diplomeService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Diplome n'existe pas pour id : " + id));
		return new ResponseEntity<>(diplome, HttpStatus.OK);
	}
	
	@GetMapping("/cv/diplome/{idCv}")
	public ResponseEntity<List<Diplome>> getAllByCvId(@PathVariable Long idCv) {
		return new ResponseEntity<List<Diplome>>(diplomeService.FindAllByCvId(idCv), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "ajouter un Diplome", response = Diplome.class, tags = "createDiplome")
	//@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("cv/{idCv}/diplomes")
	public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome,@PathVariable Long idCv) {
		Cv cv =  cvService.getOne(idCv).get();
		diplome.setCv(cv);
		return new ResponseEntity<Diplome>(diplomeService.saveOrUpdate(diplome), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/diplomes/{id}")
	//@ApiOperation(value = "supprimer un Diplome", response = Diplome.class, tags = "deleteDiplome")
	public ResponseEntity<?> deleteDiplome(@PathVariable("id")Long id) {
		diplomeService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Recruteur n'existe pas pour id : " + id));
		
		diplomeService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
