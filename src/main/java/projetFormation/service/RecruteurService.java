package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Recruteur;
import projetFormation.repository.IRecruteurRepository;

@Service(value = "recruteurService")
public class RecruteurService implements IService<Recruteur>{

	@Autowired
	IRecruteurRepository recruteurRepo;
	
	@Override
	public List<Recruteur> findAll() {
		
		return recruteurRepo.findAll();
	}

	@Override
	public Recruteur saveOrUpdate(Recruteur obj) {
		
		return recruteurRepo.save(obj);
	}

	@Override
	public Optional<Recruteur> getOne(Long id) {
		
		return recruteurRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		recruteurRepo.deleteById(id);
		
	}

}
