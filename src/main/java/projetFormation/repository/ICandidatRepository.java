package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Candidat;

public interface ICandidatRepository extends JpaRepository<Candidat, Long>{

}
