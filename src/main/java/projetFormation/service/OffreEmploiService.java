package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.OffreEmploi;
import projetFormation.repository.IOffreEmploiRepository;

@Service(value = "offreEmploiService")
public class OffreEmploiService implements IService<OffreEmploi>{

	@Autowired
	IOffreEmploiRepository offreEmploiRepo;
	
	@Override
	public List<OffreEmploi> findAll() {
		
		return offreEmploiRepo.findAll();
	}

	@Override
	public OffreEmploi saveOrUpdate(OffreEmploi obj) {
				
		return offreEmploiRepo.save(obj);
	}

	@Override
	public Optional<OffreEmploi> getOne(Long id) {
		
		return offreEmploiRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		offreEmploiRepo.deleteById(id);
		
		
	}
	public List<OffreEmploi> findAllByCompetence(Long id) {
		return offreEmploiRepo.findAllByCompetence(id);
	}
	

}
