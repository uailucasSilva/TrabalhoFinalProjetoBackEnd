package com.trabalhoFinal.trabalhoFinal.repositories;

import com.trabalhoFinal.trabalhoFinal.models.Atendimento;
import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

  @Query("FROM Atendimento WHERE atendente.id = ?1")
  List<Atendimento> findByAtendenteId(Long atendenteId);

}
