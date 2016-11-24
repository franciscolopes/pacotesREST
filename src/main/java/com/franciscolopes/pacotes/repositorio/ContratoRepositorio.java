package com.franciscolopes.pacotes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franciscolopes.pacotes.dominio.Contrato;



@Repository
public interface ContratoRepositorio extends JpaRepository<Contrato, Integer> {

}
