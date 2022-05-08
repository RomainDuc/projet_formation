package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Formation;
import projetFormation.repository.IFormationRepository;

@Service(value = "formationService")
public class FormationService implements IService<Formation>{
	
	@Autowired
	private IFormationRepository formationRepository;

	@Override
	public List<Formation> findAll() {
		return formationRepository.findAll();
	}

	@Override
	public Formation saveOrUpdate(Formation obj) {
		return formationRepository.save(obj);
	}

	@Override
	public Optional<Formation> getOne(Long id) {
		return formationRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		formationRepository.deleteById(id);
		
	}
	
	public List<Formation> findAllByCvId(Long idCv) {
		return formationRepository.getALLByCv(idCv);
	}

}
