package com.pfe.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pfe.myschool.model.Institut;

@Repository
public interface InstitutRepository extends JpaRepository<Institut, Long> {

	@Query(value = "SELECT count(code) FROM Institut")
	public int nbre();
	@Query(value = "SELECT max(code) FROM Institut")
	public int max();
}
