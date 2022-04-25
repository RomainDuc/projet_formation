package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Competence;
import projetFormation.repository.ICompetenceRepository;

@Service
public class CompetenceService implements IService<Competence>{

	@Autowired
	ICompetenceRepository competenceRepo;
	
	@Override
	public List<Competence> findAll() {
		
		return competenceRepo.findAll();
	}

	@Override
	public Competence saveOrUpdate(Competence obj) {
		
		return competenceRepo.save(obj);
	}

	@Override
	public Optional<Competence> getOne(Long id) {
		
		return competenceRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		competenceRepo.deleteById(id);
		
	}

}
