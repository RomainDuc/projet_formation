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

import projetFormation.model.Lieu;
import projetFormation.service.LieuService;

@RestController
public class LieuController {
	
	
	@Autowired
	private LieuService lieuService;
	
	
	@GetMapping("/lieux")
	public ResponseEntity<List<Lieu>> getLieux(){
		return new ResponseEntity<>(lieuService.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/lieux/{id}")
	public ResponseEntity<Lieu> getOneLieu(@PathVariable Long id){
		
		Lieu lieu=lieuService.getOne(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu introuvable pour l'id: "+id));
		
		return new ResponseEntity<Lieu>(lieu,HttpStatus.OK);
	}
	
	@PostMapping("/lieux")
	public ResponseEntity<Lieu> saveLieu(@RequestBody Lieu lieu){
		return new ResponseEntity<Lieu>(lieuService.saveOrUpdate(lieu), HttpStatus.CREATED);
	}
	
	
	
	@PutMapping("/lieux/{id}")
	public ResponseEntity<Lieu> updateLieu(@PathVariable("id") Long id, @RequestBody Lieu lieu){
		Lieu lieuUpdate=lieuService.getOne(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lieu introuvable pour update avec id: "+id));
		
		lieuUpdate.setAdresse(lieu.getAdresse());
		lieuUpdate.setCodePostal(lieu.getCodePostal());
		lieuUpdate.setOffreEmplois(lieu.getOffreEmplois());
		lieuUpdate.setPays(lieu.getPays());
		lieuUpdate.setRegion(lieu.getRegion());
		lieuUpdate.setVille(lieu.getVille());
		
		lieuService.saveOrUpdate(lieuUpdate);
		
		return new ResponseEntity<Lieu>(lieuUpdate,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/lieux/{id}")
	public ResponseEntity<?> deleteLieu(@PathVariable("id") Long id){
		lieuService.getOne(id).orElseThrow(
				()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu introuvable pour delete avec l'id: "+id));
		
		return new ResponseEntity<>("Delete SUCCESSFULLY", HttpStatus.OK);
	}

}
