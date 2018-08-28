package com.app.logement.controllers;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.logement.dao.ChambreRepository;
import com.app.logement.dao.ClientRepository;
import com.app.logement.dao.FactureRepository;
import com.app.logement.entities.Chambre;
import com.app.logement.entities.Client;
import com.app.logement.entities.Facture;
import com.app.logement.entities.Reservation;

@Controller
public class FactureController {
	@Autowired
	ClientRepository cRepository;
	@Autowired
	ChambreRepository chRepository;
	@Autowired	
	FactureRepository fRepository;
	
	@RequestMapping("/create-facture")
	public String saveFacture(Model model, double montant,long client, long chambre) {
		Client c = cRepository.getOne(client);
		Chambre ch = chRepository.getOne(chambre);
		montant=ch.getPrix();
		Facture facture = new Facture(montant,new Date(),c,ch);
		fRepository.save(facture);
		model.addAttribute("facrures", fRepository.findAll());
		
		return "fRepository.findAll())";
	}
	
	
	public String  factureDelete(@PathVariable(value = "id") Long id ) {
		Facture f=fRepository.getOne(id);
		fRepository.delete(f);
		
		return "facture/pageFacture";
		
	}

	
	

}
