package com.franciscolopes.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscolopes.pacotes.dominio.Pacote;



@Repository
public interface PacoteRepositorio extends JpaRepository<Pacote, Integer> {

}
