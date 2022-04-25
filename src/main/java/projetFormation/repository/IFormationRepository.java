package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Formation;

public interface IFormationRepository extends JpaRepository<Formation, Long>{

}
