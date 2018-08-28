package com.app.logement.entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date dateDebutReservation;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date dateReservation;
	@DateTimeFormat(pattern = "yyyy-dd-MM")
	private Date dateFinReservation;
	@ManyToOne
    @JoinColumn(name = "id_client")
	private Client client;
	@ManyToOne
    @JoinColumn(name = "id_chambre")
	private Chambre chambre;

	
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}


		

	public Reservation(Date dateDebutReservation, Date dateReservation, Date dateFinReservation, Client client,
			Chambre chambre) {
		super();
		this.dateDebutReservation = dateDebutReservation;
		this.dateReservation = dateReservation;
		this.dateFinReservation = dateFinReservation;
		this.client = client;
		this.chambre = chambre;
	}




	public Date getDateDebutReservation() {
		return dateDebutReservation;
	}




	public void setDateDebutReservation(Date dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}




	public Date getDateFinReservation() {
		return dateFinReservation;
	}




	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Chambre getChambre() {
		return chambre;
	}


	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}


	
	

}
