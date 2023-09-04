package com.pfe.myschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Etablissement;

@Repository
public interface EtablissementRepository extends JpaRepository<Etablissement, Long>{
	
	@Query(value = "SELECT count(code) FROM Etablissement")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Etablissement")
	public int max();

	List<Etablissement> findAllByLibelleContaining(String libelle);
	
}
