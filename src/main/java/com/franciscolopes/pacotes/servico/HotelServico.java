package com.franciscolopes.pacotes.servico;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscolopes.pacotes.dominio.Hotel;
import com.franciscolopes.pacotes.repositorio.HotelRepositorio;

@Service
public class HotelServico {

	@Autowired
	private HotelRepositorio repo;
	
	
	
	
	public List<Hotel> buscaPorNomeOrdenadoPorPreco(String nome, BigDecimal diariaMin, BigDecimal diariaMax){
		return repo.buscaPorNomeOrdenadoPorPreco(nome, diariaMin, diariaMax);

	}
	
	
	
}
