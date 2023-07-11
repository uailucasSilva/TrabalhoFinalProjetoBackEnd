package com.trabalhoFinal.trabalhoFinal.repositories;

import com.trabalhoFinal.trabalhoFinal.models.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

  @Query("FROM Dispositivo ORDER BY dataDeCadastro LIMIT 1")
  Dispositivo getCadastroMaisRecente();
}
