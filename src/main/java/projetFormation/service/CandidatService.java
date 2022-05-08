package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Candidat;
import projetFormation.repository.ICandidatRepository;

@Service(value = "candidatService")
public class CandidatService implements IService<Candidat>{

	@Autowired
	private ICandidatRepository candidatRepo;
	
	@Override
	public List<Candidat> findAll() {
		
		return candidatRepo.findAll();
	}

	@Override
	public Candidat saveOrUpdate(Candidat obj) {
		
		return candidatRepo.save(obj);
	}

	@Override
	public Optional<Candidat> getOne(Long id) {
		
		return candidatRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		candidatRepo.deleteById(id);
		
	}
	

}
