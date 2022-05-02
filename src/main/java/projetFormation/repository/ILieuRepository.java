package projetFormation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projetFormation.model.Lieu;

@Repository
public interface ILieuRepository extends JpaRepository<Lieu,Long>{

}
