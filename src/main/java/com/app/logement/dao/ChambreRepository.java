package com.app.logement.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.logement.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
	@Query("select c from Chambre c where c.statut = :statut")
	List<Chambre> libres(@Param("statut") String id);
	@Query("select c from Chambre c where c.statut = :statut")
	List<Chambre> occupees(@Param("statut") String id);

}
