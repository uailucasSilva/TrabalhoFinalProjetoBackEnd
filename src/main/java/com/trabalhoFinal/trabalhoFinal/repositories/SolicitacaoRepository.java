package com.trabalhoFinal.trabalhoFinal.repositories;

import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {

  @Query("FROM Solicitacao WHERE statusSolicitacao = 'EM_PROGRESSO'")
  List<Solicitacao> getAllEmProgresso();
}
