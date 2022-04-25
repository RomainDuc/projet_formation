package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import projetFormation.model.Competence;

public interface ICompetenceRepository extends JpaRepository<Competence, Long>{

}