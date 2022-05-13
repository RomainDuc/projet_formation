package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.Reponse;
import projetFormation.repository.IReponseRepository;

@Service
public class ReponseService implements IService<Reponse> {
	
	@Autowired
	private IReponseRepository responserRepo;

	@Override
	public List<Reponse> findAll() {
		
		return responserRepo.findAll();
	}

	@Override
	public Reponse saveOrUpdate(Reponse obj) {
		
		return responserRepo.save(obj);
	}

	@Override
	public Optional<Reponse> getOne(Long id) {
		
		return responserRepo.findById(id);
	}

	@Override
	public void delete(Long id) {
		responserRepo.deleteById(id);
		
	}
	
	public List<Reponse>  getAllByQuestion(Long id) {
		return responserRepo.getAllByQuestion(id);
	}
	

}
