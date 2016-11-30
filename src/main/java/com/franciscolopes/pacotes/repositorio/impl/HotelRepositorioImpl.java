package com.franciscolopes.pacotes.repositorio.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.franciscolopes.pacotes.dominio.Hotel;
import com.franciscolopes.pacotes.repositorio.HotelRepositorioCustom;

@Repository
@Transactional(readOnly=true)
public class HotelRepositorioImpl implements HotelRepositorioCustom  {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> buscaPorNomeOrdenadoPorPreco(String nome, BigDecimal diariaMin, BigDecimal diariaMax) {
		String jpql = "SELECT x FROM Hotel x WHERE x.nome LIKE :p1 AND x.diaria >= :p2 AND x.diaria <= :p3 ORDER BY x.diaria";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+nome+"%");
		query.setParameter("p2", diariaMin);
		query.setParameter("p3", diariaMax);
		return query.getResultList();
	}
	
	
}
