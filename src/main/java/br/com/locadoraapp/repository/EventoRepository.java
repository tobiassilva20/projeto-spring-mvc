package br.com.locadoraapp.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.locadoraapp.models.Evento;

public interface EventoRepository extends CrudRepository <Evento, String>{
	
	Evento findById(long id);
		
	
}
