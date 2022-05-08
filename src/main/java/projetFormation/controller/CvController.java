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

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import projetFormation.model.Competence;
import projetFormation.model.Cv;
import projetFormation.model.Diplome;
import projetFormation.model.ExperienceProfessionelle;
import projetFormation.model.Formation;
import projetFormation.service.CompetenceService;
import projetFormation.service.CvService;
import projetFormation.service.DiplomeService;
import projetFormation.service.ExperienceProfessionelleService;
import projetFormation.service.FormationService;



@RestController
public class CvController {
	
	
	@Autowired
	private CvService cvService;
	@Autowired
	private DiplomeService diplomeService;
	@Autowired
	private FormationService formationService;
	@Autowired
	private ExperienceProfessionelleService exprProService;
	@Autowired
	CompetenceService competenceService;
	
	@GetMapping("/cvs")
	public ResponseEntity<List<Cv>> getCvs() {
		
		return new ResponseEntity<>(cvService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/cvs/{id}")
	public ResponseEntity<Cv> getOneCv(@PathVariable Long id) {
		
		Cv cv = cvService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cv non trouvée pour id : "+ id));
		
		
		List<Diplome> diplomes = diplomeService.FindAllByCvId(id);
		List<Formation> formations = formationService.findAllByCvId(id);
		List<ExperienceProfessionelle> expPros = exprProService.findAllByCvId(id);
		cv.setDiplomes(diplomes);
		cv.setFormations(formations);
		cv.setExperiencesProfessionelles(expPros);
		
		return new ResponseEntity<>(cv, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/cvs")
	public ResponseEntity<Cv>  saveCv(@RequestBody Cv cv) {
		return new ResponseEntity<>(cvService.saveOrUpdate(cv), HttpStatus.CREATED);
	}
	
	@PutMapping("/cvs/{id}")
	public ResponseEntity<Cv> updateCv(@PathVariable("id") Long id,@RequestBody Cv cv) {
		cvService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cv non trouvée pour id : "+ id));
		
		return new ResponseEntity<>(cvService.saveOrUpdate(cv), HttpStatus.OK);
	}
	
	@DeleteMapping("/cvs/{idCv}")
	public ResponseEntity<?> deleteCvById(@PathVariable Long idCv) {
		cvService.getOne(idCv).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cv non trouvée pour id : "+ idCv));
		cvService.delete(idCv);
		return new ResponseEntity<>("DELETED SUCCESFULLY", HttpStatus.OK);
	}
	@GetMapping("/cv/{idCv}/competence")
	public ResponseEntity<List<Competence>> getALLCompetenceByCv(@PathVariable Long idCv) {
		return new ResponseEntity<>(competenceService.FindAllByCv(idCv), HttpStatus.OK);
	}
	
	
	
	@PostMapping("/cv/{id}/competence")
	public ResponseEntity<Competence>  saveCompetenceForCv(@RequestBody Competence comp,@PathVariable Long id) {
		 Cv cv = cvService.geCvById(id);
		 comp.setCv(cv);
		
		return new ResponseEntity<>(competenceService.saveOrUpdate(comp), HttpStatus.CREATED);
	}
	
	//@ApiOperation(value = "Chercher les ExperienceProfessionelles selon l'id du Cv", response = ExperienceProfessionelle.class, tags = "getAllByCvId")
		@GetMapping("/cv/{idCv}/experienceProfessionelle")
		public ResponseEntity<List<ExperienceProfessionelle>> getAllByCvId(@PathVariable Long idCv) {
			return new ResponseEntity<List<ExperienceProfessionelle>>(exprProService.findAllByCvId(idCv), HttpStatus.OK);
		}
		
		//@ApiOperation(value = "ajouter une ExperienceProfessionelle", response = ExperienceProfessionelle.class, tags = "createExperienceProfessionelle")
		//@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
		@PostMapping("/cv/{idCv}/experienceProfessionelles")
		public ResponseEntity<ExperienceProfessionelle> createExperienceProfessionelle(@RequestBody ExperienceProfessionelle experienceProfessionelle,@PathVariable Long idCv) {
			Cv cv = cvService.geCvById(idCv);
			experienceProfessionelle.setCv(cv);
			return new ResponseEntity<ExperienceProfessionelle>(exprProService.saveOrUpdate(experienceProfessionelle), HttpStatus.CREATED);
		}
		
		//@ApiOperation(value = "Chercher les formations selon l'id du Cv", response = Formation.class, tags = "getAllByCvId")
		@GetMapping("/cv/{idCv}/formation")
		public ResponseEntity<List<Formation>> getAllFormationByCvId(@PathVariable Long idCv) {
			return new ResponseEntity<List<Formation>>(formationService.findAllByCvId(idCv), HttpStatus.OK);
		}
		
		//@ApiOperation(value = "ajouter une Formation", response = Formation.class, tags = "createFormation")
		@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
		@PostMapping("/cv/{idCv}/formations")
		public ResponseEntity<Formation> createFormationForCv(@RequestBody Formation formation,@PathVariable Long idCv) {
			Cv cv = cvService.geCvById(idCv);
			formation.setCv(cv);
			return new ResponseEntity<Formation>(formationService.saveOrUpdate(formation), HttpStatus.CREATED);
		}
		
		@GetMapping("/cv/{idCv}/diplomes")
		public ResponseEntity<List<Diplome>> getAllDiplomeByCvId(@PathVariable Long idCv) {
			return new ResponseEntity<List<Diplome>>(diplomeService.FindAllByCvId(idCv), HttpStatus.OK);
		}
		
		//@ApiOperation(value = "ajouter un Diplome", response = Diplome.class, tags = "createDiplome")
		//@ApiResponses(value = { @ApiResponse(code = 201, message = "CREATED SUCCESSFULLY|OK") })
		@PostMapping("cv/{idCv}/diplomes")
		public ResponseEntity<Diplome> createDiplomeForCv(@RequestBody Diplome diplome,@PathVariable Long idCv) {
			Cv cv =  cvService.getOne(idCv).get();
			diplome.setCv(cv);
			return new ResponseEntity<Diplome>(diplomeService.saveOrUpdate(diplome), HttpStatus.CREATED);
		}
	

}
