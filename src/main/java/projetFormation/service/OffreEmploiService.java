package projetFormation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetFormation.model.OffreEmploi;
import projetFormation.repository.IOffreEmploiRepository;

@Service(value = "offreEmploiService")
public class OffreEmploiService implements IService<OffreEmploi>{

	@Autowired
	IOffreEmploiRepository offreEmploiRepository;
	
	@Override
	public List<OffreEmploi> findAll() {
		
		return offreEmploiRepository.findAll();
	}

	@Override
	public OffreEmploi saveOrUpdate(OffreEmploi obj) {
				
		return offreEmploiRepository.save(obj);
	}

	@Override
	public Optional<OffreEmploi> getOne(Long id) {
		
		return offreEmploiRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
		offreEmploiRepository.deleteById(id);
		
	}
	
	public List<OffreEmploi> findAllByCompetence(Long idCompetance){
		return offreEmploiRepository.findAllByCompetance(idCompetance);
		
	}
	
	public List<OffreEmploi> findAllByLieu( Long idLieu){
		return offreEmploiRepository.findAllByLieu(idLieu);
	}
	
	public List<OffreEmploi> findAllByRecruteur(Long idRecruteur){
		return offreEmploiRepository.findAllByRecruteur(idRecruteur);
	}
	
	public List<OffreEmploi> getAllByCandidat (Long idCandidat){
		return offreEmploiRepository.getAllByCandidat(idCandidat);
	}
	public List<OffreEmploi> findAllByExprienceSouhaite(int experienceSouhaite){
		return offreEmploiRepository.findAllByExperienceSouhaite(experienceSouhaite);
	}

	public List<OffreEmploi> findAllByCategorieOffre(String categorieOffre){
		return offreEmploiRepository.findAllByCategorieOffre(categorieOffre);
	}

}
