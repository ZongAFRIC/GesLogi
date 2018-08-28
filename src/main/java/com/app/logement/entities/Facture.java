package com.app.logement.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double montant;
	private Date dateEdition;
	@ManyToOne
    @JoinColumn(name = "id_client")
	private Client client;
	@ManyToOne
    @JoinColumn(name = "id_chambre")
	private Chambre chambre;
	

	
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

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Facture(double montant, Date dateEdition, Client client, Chambre chambre) {
		super();
		this.montant = montant;
		this.dateEdition = dateEdition;
		this.client = client;
		this.chambre = chambre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Date getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(Date dateEdition) {
		this.dateEdition = dateEdition;
	}


}
