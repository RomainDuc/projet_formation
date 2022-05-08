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

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import projetFormation.model.Cv;
import projetFormation.model.Formation;
import projetFormation.service.CvService;
import projetFormation.service.FormationService;

//@Api(value = "FormationRestController", description = "REST APIs related to Formation Entity !!!!")
@RestController
public class FormationController {
	
	@Autowired
	private FormationService formationService;
	@Autowired
	private CvService cvService;
	//@ApiOperation(value = "Get list formations", response = Formation.class, tags = "getFormations")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/formations")
	public ResponseEntity<List<Formation>> getFormations() {
		return new ResponseEntity<>(formationService.findAll(), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Get formations by id", response = Formation.class, tags = "getOneFormation")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/formations/{id}")
	public ResponseEntity<Formation> getOneFormation(@PathVariable("id") Long id) {
		Formation formation =formationService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Formation n'existe pas pour id : " + id));
		return new ResponseEntity<>(formation, HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Chercher les formations selon l'id du Cv", response = Formation.class, tags = "getAllByCvId")
	@GetMapping("/cv/formation/{id}")
	public ResponseEntity<List<Formation>> getAllByCvId(@PathVariable Long idCv) {
		return new ResponseEntity<List<Formation>>(formationService.findAllByCvId(idCv), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "ajouter une Formation", response = Formation.class, tags = "createFormation")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("/cv/{id}/formations")
	public ResponseEntity<Formation> createFormation(@RequestBody Formation formation,@PathVariable Long id) {
		Cv cv = cvService.geCvById(id);
		formation.setCv(cv);
		return new ResponseEntity<Formation>(formationService.saveOrUpdate(formation), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/formations/{id}")
	//@ApiOperation(value = "supprimer un Formation", response = Formation.class, tags = "deleteFormation")
	public ResponseEntity<?> deleteFormation(@PathVariable("id")Long id) {
		formationService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Formation n'existe pas pour id : " + id));
		
		formationService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}


}
