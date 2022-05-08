package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Competence;
import projetFormation.repository.ICompetenceRepository;

@Service(value = "competenceService")
public class CompetenceService implements IService<Competence>{
	
	@Autowired
	private ICompetenceRepository competenceRepository;

	@Override
	public List<Competence> findAll() {
		return competenceRepository.findAll();
	}

	@Override
	public Competence saveOrUpdate(Competence obj) {
		return competenceRepository.save(obj);
	}

	@Override
	public Optional<Competence> getOne(Long id) {
		return competenceRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		competenceRepository.deleteById(id);
	}

}
