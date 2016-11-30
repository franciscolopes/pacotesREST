package com.franciscolopes.pacotes.repositorio;

import java.math.BigDecimal;
import java.util.List;

import com.franciscolopes.pacotes.dominio.Hotel;

public interface HotelRepositorioCustom {
	
	public List<Hotel> buscaPorNomeOrdenadoPorPreco(String nome, BigDecimal diariaMin, BigDecimal diariaMax);
	
}
