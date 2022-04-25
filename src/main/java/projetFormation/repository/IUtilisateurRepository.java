package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}
