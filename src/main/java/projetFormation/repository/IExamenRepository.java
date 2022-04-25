package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projetFormation.model.Examen;

public interface IExamenRepository extends JpaRepository<Examen, Long>{

}
