package com.franciscolopes.pacotes.servico;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franciscolopes.pacotes.dominio.Cliente;
import com.franciscolopes.pacotes.repositorio.ClienteRepositorio;
import com.franciscolopes.pacotes.servico.excecoes.NaoEncontradoException;
import com.franciscolopes.pacotes.servico.excecoes.ServicoException;
import com.franciscolopes.pacotes.servico.excecoes.ValidacaoException;

@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio repo;
	
	public void validar(Cliente x) {
		
		
		List<String> erros = new ArrayList<>();
		
		if (x.getNome()==null) {
			erros.add("Favor preencher o campo nome");
		}
		if (x.getEmail()==null) {
			erros.add("Favor preencher o campo email");
		}
		if (x.getTelefone()==null) {
			erros.add("Favor preencher o campo telefone");
		}
		if (x.getCpf()==null) {
			erros.add("Favor preencher o campo cpf");
		}
		
		if (x.getNascimento()==null) {
			erros.add("Favor preencher um valor válido para a data de nascimento");
		}
		
		if (x.getRendaMensal()==null) {
			erros.add("Favor preencher um valor válido para a renda mensal");
		}
		
		
		if (!erros.isEmpty()) {
			throw new ValidacaoException("Erro de validação", erros);
		}
	}
	
	
	
	
	public Cliente inserir(Cliente x)  throws ServicoException {
			Cliente aux = repo.buscaCpf(x.getCpf());
			if (aux != null) {
				throw new ServicoException("Já existe um cliente com esse cpf!", 1);
			}
			validar(x);
			return repo.save(x);
	}
	
	

	public Cliente atualizar(Cliente x)  throws ServicoException {
			Cliente aux = repo.buscaCpfDiferente(x.getCodCliente(), x.getCpf());
			if (aux != null) {
				throw new ServicoException("Já existe um cliente com esse cpf!", 1);
			}
			
			validar(x);
			return repo.save(x);
		
	}
	

	public void excluir(Cliente x) throws ServicoException {
			
			
			x = repo.findOne(x.getCodCliente());
			if (!x.getContratos().isEmpty()) {
				throw new ServicoException("Exclusão não permitida: este cliente possui contratos!", 2);
			
			}
			
	}
	
	public Cliente buscar(int cod){
		Cliente cli = repo.findOne(cod);
		if (cli == null) {
			throw new NaoEncontradoException("Cliente não encontrado!", 1);
		}
		return cli;
	}


	
	public List<Cliente> buscarTodosOrdenadosPorNome() {
		return repo.buscarTodosOrdenadosPorNome();
	}
	
	public List<Cliente> buscarPorNome(String trecho) {
		return repo.buscarPorNome(trecho);
	}
	
	
}
