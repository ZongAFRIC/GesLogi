package com.app.logement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.logement.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
