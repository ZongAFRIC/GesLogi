package com.app.logement.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.logement.entities.Chambre;
import com.app.logement.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation , Long>{
	@Query("select r from Reservation r where r.dateReservation = :dateReservation")
	List<Reservation> reservationParDate(@Param("dateReservation") Date id);

}
