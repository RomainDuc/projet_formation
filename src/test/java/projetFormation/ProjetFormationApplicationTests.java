package projetFormation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import projetFormation.model.Candidat;
import projetFormation.model.Diplome;
import projetFormation.model.NiveauQualification;
import projetFormation.repository.ICandidatRepository;
import projetFormation.repository.IDiplomeRepository;
import projetFormation.repository.IRecruteurRepository;

@SpringBootTest
class ProjetFormationApplicationTests {
	
	@Autowired
	IRecruteurRepository recruteurRepo;
	@Autowired
	ICandidatRepository candidatRepo;
	@Autowired
	IDiplomeRepository diplomeRepo;

	@Test
	void candidat() {
		int start = candidatRepo.findAll().size();
		
		Candidat candidat = new Candidat();
		candidat.setLogin("paulB");
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		try {
			candidat.setDateNaissance(simpleDateFormat.parse("1990-05-25"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		candidat.setDisponibilite(true);
		candidat.setNom("Francois");
		candidat.setPrenom("Claude");
		candidat.setEmail("jlpoirede@gkal.li");
		
		candidat= candidatRepo.save(candidat);
		System.out.println(candidat.getNom());
		
		Optional<Candidat>  optcandidatFind = candidatRepo.findById(candidat.getId());
		
		Candidat candidatFind = null;
		if(optcandidatFind.isPresent()) {
			candidatFind =optcandidatFind.get();
		}
		assertEquals("paulB", candidatFind.getLogin());
		assertEquals("1990-05-25", simpleDateFormat.format(candidatFind.getDateNaissance()));
		assertEquals("Francois", candidatFind.getNom());
		assertEquals("Claude", candidatFind.getPrenom());
		assertEquals("jlpoirede@gkal.li", candidatFind.getEmail());
		assertEquals(true, candidatFind.isDisponibilite());
		
		
		candidatFind.setLogin("ArthurH");
		candidatFind.setDisponibilite(false);
		candidatFind.setNom("Hivernal");
		candidatFind.setPrenom("Trevor");
		candidatFind.setEmail("sélété@ici.fr");
		try {
			candidatFind.setDateNaissance(simpleDateFormat.parse("1955-12-05"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		candidat = candidatRepo.save(candidatFind);
		
		candidat = candidatRepo.findById(candidat.getId()).get();
		
		assertEquals("ArthurH", candidat.getLogin());
		assertEquals("1955-12-05", simpleDateFormat.format(candidat.getDateNaissance()));
		assertEquals("Hivernal", candidat.getNom());
		assertEquals("Trevor", candidat.getPrenom());
		assertEquals("sélété@ici.fr", candidat.getEmail());
		assertEquals(false, candidat.isDisponibilite());
		
		int end = candidatRepo.findAll().size();
		assertEquals(1, end-start);
		
//		candidatRepo.delete(candidat);
//		
//		Optional<Candidat> perdu = candidatRepo.findById(candidat.getId());
//		
//		if(perdu.isPresent()) {
//			fail("Supression Candidat ne supprime pas");
//		}
	}
	
	@Test
	void diplome() {
		int start = diplomeRepo.findAll().size();
		
		Diplome diplome = new Diplome();
		String pattern = "yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		try {
			diplome.setAnneeObtention(simpleDateFormat.parse("2006"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		diplome.setNiveauQualification(NiveauQualification.BAC_PLUS_3);
		diplome.setNom("License Proffessionnelle En Boichimie");
		
		diplome = diplomeRepo.save(diplome);
	//	System.out.println("Annee obtention "+ simpleDateFormat.format(diplome.getAnneeObtention()));
		
		Diplome diplomeFind = diplomeRepo.findById(diplome.getId()).get();
		
		assertEquals("2006", simpleDateFormat.format(diplomeFind.getAnneeObtention()));
		assertEquals(NiveauQualification.BAC_PLUS_3, diplomeFind.getNiveauQualification());
		assertEquals("License Proffessionnelle En Boichimie", diplomeFind.getNom());
		
		try {
			diplomeFind.setAnneeObtention(simpleDateFormat.parse("2018"));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		diplomeFind.setNiveauQualification(NiveauQualification.BAC);
		diplomeFind.setNom("Baccalaureat");
		
		diplome = diplomeRepo.save(diplomeFind);
		
		assertEquals("2018", simpleDateFormat.format(diplome.getAnneeObtention()));
		assertEquals(NiveauQualification.BAC, diplome.getNiveauQualification());
		assertEquals("Baccalaureat", diplome.getNom());
		
		int end = diplomeRepo.findAll().size();
		
		assertEquals(1, end- start);
		
//		diplomeRepo.delete(diplome);
//		
//		Optional<Diplome> optdip = diplomeRepo.findById(diplome.getId());
//		
//		if(optdip.isPresent()) {
//			fail("Supression Diplome ne supprime pas");
//		}
		
		
	}
	
	
	

}
