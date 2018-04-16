package br.com.locadoraapp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.locadoraapp.models.Evento;
import br.com.locadoraapp.repository.EventoRepository;

@Controller
public class EventoController  {
	
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String formEvento() {
		return "evento/formEvento";
	}
	
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST )
	public String formEvento(Evento evento) {
		
		er.save(evento);
		System.out.println("Evento cadastrado com sucesso!");
		return "redirect:/cadastrarEvento"; 
	}
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("eventos", eventos);
		return mv;
	}
}
