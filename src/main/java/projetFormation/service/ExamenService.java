package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Examen;
import projetFormation.repository.IExamenRepository;

@Service(value = "examenService")
public class ExamenService implements IService<Examen>{

	@Autowired
	private IExamenRepository examenRepository;
	
	@Override
	public List<Examen> findAll() {
		return examenRepository.findAll();
	}

	@Override
	public Examen saveOrUpdate(Examen obj) {
		return examenRepository.save(obj);
	}

	@Override
	public Optional<Examen> getOne(Long id) {
		return examenRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		
		examenRepository.deleteById(id);
		
	}

}
