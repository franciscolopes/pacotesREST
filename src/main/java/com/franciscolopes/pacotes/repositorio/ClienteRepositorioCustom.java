package com.franciscolopes.pacotes.repositorio;

import java.util.List;

import com.franciscolopes.pacotes.dominio.Cliente;

public interface ClienteRepositorioCustom {

	public List<Cliente> buscarTodosOrdenadosPorNome();
	public List<Cliente> buscarPorNome(String trecho);
	public Cliente buscaCpf(String cpf);
	public Cliente buscaCpfDiferente(Integer codigo, String cpf);
	
}
