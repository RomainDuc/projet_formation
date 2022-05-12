package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Lieu;
import projetFormation.repository.ILieuRepository;

@Service(value = "lieuService")
public class LieuService implements IService<Lieu>{
	
	@Autowired
	private ILieuRepository lieuRepository;

	@Override
	public List<Lieu> findAll() {
		return lieuRepository.findAll();
	}

	@Override
	public Lieu saveOrUpdate(Lieu obj) {
		return lieuRepository.save(obj);
	}

	@Override
	public Optional<Lieu> getOne(Long id) {
		return lieuRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		lieuRepository.deleteById(id);
	}
	
	public List<Lieu> findAllByVille(String ville){
		return lieuRepository.findAllByVille(ville);
	}

}
