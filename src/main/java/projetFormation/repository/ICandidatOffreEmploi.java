package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Candidature;

public interface ICandidatOffreEmploi extends JpaRepository<Candidature, Long>{

}
