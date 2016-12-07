package com.franciscolopes.pacotes.recursos;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franciscolopes.pacotes.dominio.Hotel;
import com.franciscolopes.pacotes.servico.HotelServico;

@RestController
@RequestMapping("/hoteis")
public class HotelRecurso {
	
	
	@Autowired
	private HotelServico hs;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Hotel>> nomes(@RequestParam(value="nome") String nome, @RequestParam(value="diariaMin") BigDecimal diariaMin, @RequestParam(value="diariaMax") BigDecimal diariaMax) {
		List<Hotel> lista = hs.buscaPorNomeOrdenadoPorPreco(nome, diariaMin, diariaMax);
		return ResponseEntity.status(HttpStatus.OK).body(lista);

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
		Hotel hotel = hs.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	/*
	@RequestMapping(method = RequestMethod.GET)
	public String todos(){
		return "Executou o metodo todos";
	}
*/
	
	
	
	
	
}
