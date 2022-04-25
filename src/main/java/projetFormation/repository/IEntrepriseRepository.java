package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Entreprise;

public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long>{

}
