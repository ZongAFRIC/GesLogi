package com.app.logement.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.logement.dao.ClientRepository;
import com.app.logement.entities.Chambre;
import com.app.logement.entities.Client;

@Controller
public class ClientController {
	
	@Autowired 
	ClientRepository cRepository;
	
	@RequestMapping("/traitement-client")
	public String sowClient(Model model) {
		model.addAttribute("clients", cRepository.findAll());
		return "client/listeClients";
		
	}
	

	@RequestMapping("/listeClients")
	public String listeClient(Model model) {
		model.addAttribute("clients", cRepository.findAll());
		return "client/listeClients";
		
	}
	
	@RequestMapping("/traitement-client/{id}")
	public String teChambre(Model model, @PathVariable(value = "id") Long id) {
		model.addAttribute("client", cRepository.getOne(id) );
		//model.addAttribute("client", cRepository.findAll());
		return "client/pageClient";
	}
	
	
	@RequestMapping("/create-client")
	public String saveClent(Model model,Long id, String nom, String prenom, String email, String telephone) {
		Client client = new Client(nom, prenom, email, telephone);
		cRepository.save(client);
		model.addAttribute("clients", cRepository.findAll());
		return "client/pageClient";
	}
	
	
	@RequestMapping("/update-client")
	public String updateClient(Model model,Long id, String nom, String prenom, String email, String telephone) {
		Client c = cRepository.getOne(id);
		c.setNom(nom);
		c.setPrenom(prenom);
		c.setEmail(email);
		c.setTelephone(telephone);
		cRepository.save(c);
		model.addAttribute("clients", cRepository.findAll());
		return "client/pageClient";
	}
	
	@RequestMapping("/delete-client/{id}")
	public String deleteClient(Model model,@PathVariable(value = "id") Long id) {
		Client client = cRepository.getOne(id);
		cRepository.delete(client);
		model.addAttribute("clients", cRepository.findAll());
		return "client/pageClient";
	}
	
	

}
