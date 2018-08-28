package com.app.logement.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.logement.dao.ChambreRepository;
import com.app.logement.dao.ClientRepository;
import com.app.logement.dao.ReservationRepository;
import com.app.logement.entities.Chambre;
import com.app.logement.entities.Client;
import com.app.logement.entities.Reservation;


@Controller
public class ReservationController {
	
	@Autowired 
	ReservationRepository rRepository;
	@Autowired 
	ClientRepository cRepository;
	@Autowired 
	ChambreRepository chRepository;
	
	
	@RequestMapping("/traitement-reser")
	public String sowReservati(Model model) {
		model.addAttribute("reservations", rRepository.findAll());
		model.addAttribute("chambres", chRepository.findAll());	
		model.addAttribute("clients", cRepository.findAll());
		model.addAttribute("dispos", chRepository.libres("libre"));
		return "reservation/details";
	}
	
	@RequestMapping("/traitement-reservation")
	public String sowReservation(Model model) {
		model.addAttribute("reservations", rRepository.findAll());
		model.addAttribute("chambres", chRepository.findAll());	
		model.addAttribute("clients", cRepository.findAll());
		model.addAttribute("dispos", chRepository.libres("libre"));
		return "reservation/nouvelleReservation";
	}
	
	
//	@RequestMapping("/traitement-reservation/{id}")
//	public String modiReservation(Model model, @PathVariable(value = "id") Long id) {
//		model.addAttribute("reservavtion", rRepository.getOne(id));		
//		return "reservation/pageReservation";
//	}
	
	
	@RequestMapping("/create-reservation")
	public String saveReservati(Model model, String dateDebutReservation, String dateFinReservation, String nom, String prenom, String email,String telephone, long chambre) throws ParseException {
		Client clt = new Client(nom, prenom, email, telephone);
		cRepository.save(clt);
		Chambre ch = chRepository.getOne(chambre);
		ch.setStatut("occupee");
		chRepository.save(ch);
     	System.out.println(ch.getStatut());
     	Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutReservation);  
     	Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(dateFinReservation);  
     	Reservation reservation = new Reservation(date1, new Date(),date2, clt, ch);
	
		rRepository.save(reservation);
		model.addAttribute("reservations", rRepository.findAll());
		model.addAttribute("chambres", chRepository.findAll());
		model.addAttribute("clients", cRepository.findAll());
		model.addAttribute("dispos", chRepository.libres("libre"));
		
		return "reservation/nouvelleReservation";
		
	}
	
	@RequestMapping("/update-reservation")
	public String updateReservation(Model model, Long id, int duree, long client, long chambre) {
		Reservation r = rRepository.getOne(id);
		Client cl = cRepository.getOne(client);
		Chambre ch = chRepository.getOne(chambre);
		ch.setStatut("occupee");
		r.setClient(cl);
		r.setChambre(ch);
		r.setDateDebutReservation(r.getDateDebutReservation());
		r.setDateFinReservation(r.getDateFinReservation());
		rRepository.save(r);
		model.addAttribute("reservations", rRepository.findAll());
		model.addAttribute("chambres", chRepository.findAll());
		model.addAttribute("clients", cRepository.findAll());
		model.addAttribute("dispos", chRepository.libres("libre"));
	return "reservation/";
}
	
	@RequestMapping("/delete-reservation/{id}")
	public String  clientDelete(Model model,@PathVariable(value = "id") Long id ) {
		Reservation r=rRepository.getOne(id);
		rRepository.delete(r);
		model.addAttribute("reservations", rRepository.findAll());
		
		return "reservation/";
		
	}

}
