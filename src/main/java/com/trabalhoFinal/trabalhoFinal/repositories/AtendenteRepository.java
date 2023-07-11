package com.trabalhoFinal.trabalhoFinal.repositories;

import com.trabalhoFinal.trabalhoFinal.models.Atendente;
import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import com.trabalhoFinal.trabalhoFinal.enums.NivelDeAcesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendenteRepository extends JpaRepository<Atendente, Long> {

  @Query("FROM Atendente WHERE nivelDeAcesso = ?1")
  List<Atendente> findByAcesso(NivelDeAcesso nvl);
}
