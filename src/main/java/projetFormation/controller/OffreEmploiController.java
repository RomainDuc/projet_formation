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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import projetFormation.model.OffreEmploi;
import projetFormation.service.CandidatService;
import projetFormation.service.CompetenceService;
import projetFormation.service.LieuService;
import projetFormation.service.OffreEmploiService;
import projetFormation.service.RecruteurService;

//@Api(value = "EmployerRestController", description = "REST APIs related to Employee Entity !!!!")
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class OffreEmploiController {

	@Autowired
	private OffreEmploiService offreEmploiService;
	
	@Autowired
	private CompetenceService competenceService;
	
	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private RecruteurService recruteurService;
	
	@Autowired
	private CandidatService candidatService;

	@ApiOperation(value = "Get list Offre Emploi in the System", response = OffreEmploi.class, tags = "getOffreEmplois")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/offreEmplois")
	public ResponseEntity<List<OffreEmploi>> getOffreEmplois() {
		return new ResponseEntity<>(offreEmploiService.findAll(), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Get Offre Emploi by id", response = OffreEmploi.class, tags = "getOneOffreEmploi")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success|OK") })
	@GetMapping("/offreEmplois/{id}")
	public ResponseEntity<OffreEmploi> getOneOffreEmploi(@PathVariable("id") Long id) {
		OffreEmploi offre =offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));
		return new ResponseEntity<>(offre, HttpStatus.OK);
	}

	@ApiOperation(value = "post un offre d'emploie", response = OffreEmploi.class, tags = "post un offre d'emploi")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
	@PostMapping("/offreEmplois")
	public ResponseEntity<OffreEmploi> createOffre(@RequestBody OffreEmploi offre) {
		return new ResponseEntity<>(offreEmploiService.saveOrUpdate(offre), HttpStatus.CREATED);
	}

	@PutMapping("/offreEmplois/{id}")
	public ResponseEntity<OffreEmploi> editOffreEmploi(@PathVariable("id") Long id, @RequestBody OffreEmploi offreEmploi) {
		OffreEmploi offretoUpdate=offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));
		
		offretoUpdate.setDescription(offreEmploi.getDescription());
		offretoUpdate.setCompetenceOffres(offreEmploi.getCompetenceOffres());
		offretoUpdate.setDateLimite(offreEmploi.getDateLimite());
		offretoUpdate.setDatePublication(offreEmploi.getDatePublication());
		offretoUpdate.setCategorieOffre(offreEmploi.getCategorieOffre());
		offretoUpdate.setCandidatOffres(offreEmploi.getCandidatOffres());
		offretoUpdate.setExperienceSouhaite(offreEmploi.getExperienceSouhaite());
		offretoUpdate.setNiveauQualification(offreEmploi.getNiveauQualification());
		offretoUpdate.setRecruteur(offreEmploi.getRecruteur());
		offretoUpdate.setSalaire(offreEmploi.getSalaire());
		offretoUpdate.setStatue(offreEmploi.getStatue());
		offretoUpdate.setTypeContrat(offreEmploi.getTypeContrat());

		offreEmploiService.saveOrUpdate(offretoUpdate);

		return new ResponseEntity<>(offretoUpdate, HttpStatus.OK);


	
	}

	@DeleteMapping("/offreEmplois/{id}")
	public ResponseEntity<?> deleteOffre(@PathVariable("id")Long id) {
		offreEmploiService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Offre n'existe pas pour id : " + id));
		
		offreEmploiService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESSFULLY", HttpStatus.OK);
	}
	
	@GetMapping("/offreEmplois/competence/{id}")
	public ResponseEntity<List<OffreEmploi>> getOffresByCompetences (@PathVariable("id") Long id){
		competenceService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Competence n'existe pas pour id : "+id) );
		
		return new ResponseEntity<>(offreEmploiService.findAllByCompetence(id),HttpStatus.OK);
		
	}
	
	@GetMapping("/offreEmplois/lieu/{id}")
	public ResponseEntity<List<OffreEmploi>> getOffresByLieu(@PathVariable("id") Long id){
		lieuService.getOne(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "pas d'offres pour le Lieu : "+id));
		
		return new ResponseEntity<List<OffreEmploi>>(offreEmploiService.findAllByLieu(id),HttpStatus.OK);
	}
	
	@GetMapping("/offreEmplois/recruteur/{id}")
	public ResponseEntity<List<OffreEmploi>> getOffresByRecruteur(@PathVariable("id") Long id){
		recruteurService.getOne(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"pas d'offre pour le recruteur: "+id));
		
		return new ResponseEntity<List<OffreEmploi>>(offreEmploiService.findAllByRecruteur(id),HttpStatus.OK);
	}
	
	@GetMapping("/offreEmplois/candidat/{id}")
	public ResponseEntity<List<OffreEmploi>> getAllByCandidat(@PathVariable("id") Long id){
		candidatService.getOne(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"pas d'offre pour le candidat: "+id));
		
		return new ResponseEntity<List<OffreEmploi>>(offreEmploiService.getAllByCandidat(id),HttpStatus.OK);
	}
	
}
