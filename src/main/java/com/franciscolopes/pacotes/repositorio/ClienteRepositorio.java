package com.franciscolopes.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscolopes.pacotes.dominio.Cliente;



@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>, ClienteRepositorioCustom  {

}
