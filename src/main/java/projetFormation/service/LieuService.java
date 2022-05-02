package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Lieu;
import projetFormation.repository.ILieuRepository;

@Service
public class LieuService implements IService<Lieu> {
	
	@Autowired
	ILieuRepository lieuRepo;

	@Override
	public List<Lieu> findAll() {
		
		return lieuRepo.findAll();
	}

	@Override
	public Lieu saveOrUpdate(Lieu obj) {
		
		return lieuRepo.save(obj);
	}

	@Override
	public Optional<Lieu> getOne(Long id) {
		
		return lieuRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		lieuRepo.deleteById(id);
		
	}

}
