package projetFormation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Cv;
import projetFormation.repository.ICandidatRepository;
import projetFormation.repository.ICvRepository;

@Service(value = "cvService")
public class CvService  {
	
	@Autowired
	private ICvRepository cvRepository;
	
	@Autowired
	ICandidatRepository candidatRepo;
	
	public List<Cv> getCvsByCandidat(Long candidatId) {
		return cvRepository.findByCandidatId(candidatId);
	}
	
	public Cv geCvById(Long id) {
		return cvRepository.getById(id);
	}



}
