package com.app.logement.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="chambre")
public class Chambre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nom;
	private double prix;
	private String statut;
	private String type;
	@OneToMany(mappedBy = "chambre", cascade = CascadeType.ALL)
	private Collection<Reservation> reservations;
	@OneToMany(mappedBy ="chambre", cascade=CascadeType.ALL)
	private Collection<Facture>factures;
	
	public Chambre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Chambre(String nom, double prix, String statut, String type) {
		super();
		
		this.nom = nom;
		this.prix = prix;
		this.statut = statut;
		this.type = type;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Collection<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	

}
