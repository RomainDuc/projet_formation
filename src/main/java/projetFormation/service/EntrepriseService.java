package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Entreprise;
import projetFormation.repository.IEntrepriseRepository;

@Service(value = "entrepriseService")
public class EntrepriseService implements IService<Entreprise>{

	@Autowired
	private IEntrepriseRepository entrepriseRepository;
	
	@Override
	public List<Entreprise> findAll() {
		return entrepriseRepository.findAll();
	}

	@Override
	public Entreprise saveOrUpdate(Entreprise obj) {
		return entrepriseRepository.save(obj);
	}

	@Override
	public Optional<Entreprise> getOne(Long id) {
		return entrepriseRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		
		entrepriseRepository.deleteById(id);
		
	}


}
