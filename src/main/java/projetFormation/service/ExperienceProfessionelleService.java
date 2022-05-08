package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.ExperienceProfessionelle;
import projetFormation.model.Formation;
import projetFormation.repository.IExperienceProfessionelleRepository;


@Service(value = "experienceProfessionelleService")
public class ExperienceProfessionelleService implements IService<ExperienceProfessionelle>{

	@Autowired
	private IExperienceProfessionelleRepository experienceProfessionelleRepository;
	
	@Override
	public List<ExperienceProfessionelle> findAll() {
		return experienceProfessionelleRepository.findAll();
	}

	@Override
	public ExperienceProfessionelle saveOrUpdate(ExperienceProfessionelle obj) {
		return experienceProfessionelleRepository.save(obj);
	}

	@Override
	public Optional<ExperienceProfessionelle> getOne(Long id) {
		return experienceProfessionelleRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	public List<ExperienceProfessionelle> findAllByCvId(Long idCv) {
		return experienceProfessionelleRepository.getALLByCv(idCv);
	}


}
