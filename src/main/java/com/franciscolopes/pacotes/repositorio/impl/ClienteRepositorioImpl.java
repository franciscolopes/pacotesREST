package com.franciscolopes.pacotes.repositorio.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.franciscolopes.pacotes.dominio.Cliente;
import com.franciscolopes.pacotes.repositorio.ClienteRepositorioCustom;


@Repository
@Transactional(readOnly=true)
public class ClienteRepositorioImpl implements ClienteRepositorioCustom  {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		String jpql = "SELECT x FROM Cliente x ORDER BY x.nome";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> buscarPorNome(String trecho) {
		String jpql = "SELECT x FROM Cliente x WHERE x.nome LIKE :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", "%"+trecho+"%");
		return query.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscaCpf(String cpf) {
		String jpql = "SELECT x FROM Cliente x WHERE x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p1", cpf);
		List<Cliente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscaCpfDiferente(Integer codCliente, String cpf) {
		String jpql = "SELECT x FROM Cliente x WHERE x.codCliente <> :p0 AND x.cpf = :p1";
		Query query = em.createQuery(jpql);
		query.setParameter("p0", codCliente);
		query.setParameter("p1", cpf);
		List<Cliente> aux = query.getResultList();
		return (aux.size() > 0) ? aux.get(0) : null;
	}
}
