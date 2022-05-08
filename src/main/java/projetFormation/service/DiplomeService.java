package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Competence;
import projetFormation.model.Diplome;
import projetFormation.repository.IDiplomeRepository;

@Service(value = "diplomeService")
public class DiplomeService implements IService<Diplome> {

	
	@Autowired
	private IDiplomeRepository diplomeRepository;
	
	@Override
	public List<Diplome> findAll() {
		return diplomeRepository.findAll();
	}

	@Override
	public Diplome saveOrUpdate(Diplome obj) {
		return diplomeRepository.save(obj);
	}

	@Override
	public Optional<Diplome> getOne(Long id) {
		return diplomeRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		diplomeRepository.deleteById(id);
	}
	
	public List<Diplome> FindAllByCvId(Long idCv) {
		return diplomeRepository.getALLByCvId(idCv);
	}

}
