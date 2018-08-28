package com.app.logement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.logement.entities.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long>{

}
