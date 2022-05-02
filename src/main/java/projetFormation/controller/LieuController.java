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
	LieuService lieuService;
	
	@GetMapping("/lieux")
	public ResponseEntity<List<Lieu>> findAllLieux() {
		return new ResponseEntity<>(lieuService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/lieux/{id}")
	public ResponseEntity<Lieu> getOneLieu(@PathVariable Long id) {
		Lieu lieu =lieuService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Ce lieu n'existe pas pour id : " + id));
		return new ResponseEntity<>(lieu, HttpStatus.OK);
	}
	
	@PostMapping("/lieux")
	public ResponseEntity<Lieu> createLieu(@RequestBody Lieu lieu) {
		return new ResponseEntity<>(lieuService.saveOrUpdate(lieu), HttpStatus.CREATED);
	}
	
	@PutMapping("/lieux/{id}") 
	public ResponseEntity<Lieu> updateLieu(@PathVariable Long id, @RequestBody Lieu lieu) {
		lieuService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Ce lieu n'existe pas pour id : " + id));
		return new ResponseEntity<>(lieuService.saveOrUpdate(lieu), HttpStatus.OK);
	}
	
	@DeleteMapping("/lieux/{id}")
	public ResponseEntity<?> deleteLieu(@PathVariable Long id) {
		lieuService.getOne(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Ce lieu n'existe pas pour id : " + id));
		lieuService.delete(id);
		return new ResponseEntity<>("DELETED SUCCESFULLY", HttpStatus.OK);
	}

}
