package com.pfe.myschool.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

	Optional<Enseignant> findByMatricule(String mat);
	@Query(value = "SELECT count(matricule) FROM Enseignant where annee = :ann")
	public int nbre(@Param("ann") int ann);
	@Query(value = "SELECT max(matricule) FROM Enseignant  where annee = :ann")
	public int max(@Param("ann") int ann);
	

}
