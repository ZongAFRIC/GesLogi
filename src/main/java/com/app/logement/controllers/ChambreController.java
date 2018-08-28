package com.app.logement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.logement.dao.ChambreRepository;
import com.app.logement.entities.Chambre;

@Controller
public class ChambreController {
	@Autowired 
	ChambreRepository chRepository;
		
	@RequestMapping("/traitement-chambre")
	public String tChambre(Model model) {
		model.addAttribute("chambres", chRepository.findAll());
		//model.addAttribute("dispos", chRepository.libres("libre"));
		model.addAttribute("occupees", chRepository.occupees("occupee"));
		return "chambre/pageChambre";
	}
	
	
	
	@RequestMapping("/traitement-chambre/{id}")
	public String teChambre(Model model, @PathVariable(value = "id") Long id) {
		model.addAttribute("chambre", chRepository.getOne(id) );
		model.addAttribute("chambres", chRepository.findAll());
		//model.addAttribute("dispos", chRepository.libres("libre"));
		return "chambre/pageChambre";
	}
	
	
	@RequestMapping("/create-chambre")
	public String saveChambre(Model model, String nom, double montant, String statut, String type) {
		Chambre chambre = new Chambre(nom, montant, "libre", type);
		chRepository.save(chambre);
		model.addAttribute("chambres", chRepository.findAll());
		//model.addAttribute("dispos", chRepository.libres("libre"));
		return "chambre/pageChambre";
	}
	
	@RequestMapping("/update-chambre")
	public String updateChambre(Model model,Long id, String nom, double prix, String statut, String type) {
		Chambre ch = chRepository.getOne(id);
		ch.setNom(nom);
		ch.setStatut(statut);
		ch.setType(type);
		ch.setPrix(prix);
		chRepository.save(ch);
		model.addAttribute("chambres", chRepository.findAll());
		//model.addAttribute("dispos", chRepository.libres("libre"));
		return "chambre/pageChambre";
	}
	
	
	
	@RequestMapping("/delete-chambre/{id}")
	public String deleteChambre(Model model,@PathVariable(value = "id") Long id) {
		Chambre chambre = chRepository.getOne(id);
		chRepository.delete(chambre);
		model.addAttribute("chambres", chRepository.findAll());
		return "chambre/pageChambre";
	}
	
	
	@RequestMapping("/chambres-libres")
	public String chambresLibres(Model model) {
		model.addAttribute("dispos", chRepository.libres("libre"));
		model.addAttribute("occupees", chRepository.occupees("occupee"));
		return "chambre/chambreLibre";
		
	}
	
	
}
