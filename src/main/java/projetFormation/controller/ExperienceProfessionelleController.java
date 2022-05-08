package projetFormation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import projetFormation.model.ExperienceProfessionelle;
import projetFormation.service.CvService;
import projetFormation.service.ExperienceProfessionelleService;

@RestController
public class ExperienceProfessionelleController {
	
	@Autowired
	private ExperienceProfessionelleService experienceProfessionelleService;
	
	//@ApiOperation(value = "Get list ExperienceProfessionelles", response = ExperienceProfessionelle.class, tags = "getExperienceProfessionelles")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/experienceProfessionelles")
	public ResponseEntity<List<ExperienceProfessionelle>> getExperienceProfessionelles() {
		return new ResponseEntity<>(experienceProfessionelleService.findAll(), HttpStatus.OK);
	}
	
	//@ApiOperation(value = "Get ExperienceProfessionelles by id", response = ExperienceProfessionelle.class, tags = "getOneExperienceProfessionelle")
	//@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/experienceProfessionelles/{id}")
	public ResponseEntity<ExperienceProfessionelle> getOneExperienceProfessionelle(@PathVariable("id") Long id) {
		ExperienceProfessionelle experienceProfessionelle =experienceProfessionelleService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"ExperienceProfessionelle n'existe pas pour id : " + id));
		return new ResponseEntity<>(experienceProfessionelle, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/experienceProfessionelles/{id}")
	//@ApiOperation(value = "supprimer un ExperienceProfessionelle", response = ExperienceProfessionelle.class, tags = "deleteExperienceProfessionelle")
	public ResponseEntity<?> deleteExperienceProfessionelle(@PathVariable("id")Long id) {
		experienceProfessionelleService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"ExperienceProfessionelle n'existe pas pour id : " + id));
		
		experienceProfessionelleService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}

}
