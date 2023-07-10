package com.trabalhoFinal.trabalhoFinal.repositories;

import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  @Query(value = "FROM Cliente WHERE numeroDaMatricula = ?1")
  Cliente getClienteNameByNumeroDaMatricula(String num);
}
