package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Cv;

import projetFormation.repository.ICandidatRepository;
import projetFormation.repository.ICvRepository;

@Service(value = "cvService")
public class CvService implements IService<Cv> {
	
	@Autowired
	private ICvRepository cvRepository;
	
	@Autowired
	ICandidatRepository candidatRepo;
	
	@Override
	public List<Cv> findAll() {
		return cvRepository.findAll();
	}

	@Override
	public Cv saveOrUpdate(Cv obj) {
		// TODO Auto-generated method stub
		return cvRepository.save(obj);
	}

	@Override
	public Optional<Cv> getOne(Long id) {
		// TODO Auto-generated method stub
		return cvRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		cvRepository.deleteById(id);
		
	}
	
	
	public List<Cv> getCvsByCandidat(Long candidatId) {
		return cvRepository.findByCandidatId(candidatId);
	}
	
	public Cv getCvById(Long id) {
		return cvRepository.getById(id);
	}



}
