package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.AtendimentoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendimentoVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/atendimento")
@Tag(name = "Atendimento", description = "Endpoints para CRUD de atendimento")
public class AtendimentoController {

  @Autowired
  private AtendimentoService service;

  @PostMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<AtendimentoVO> create(@RequestBody AtendimentoVO atendimentoVO) {
    AtendimentoVO created = service.create(atendimentoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<AtendimentoVO>> getAll() {
    List<AtendimentoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<AtendimentoVO> getByID(@PathVariable Long id) {
    AtendimentoVO atendimento = service.getById(id);
    return ResponseEntity.ok(atendimento);
  }

  @GetMapping(value = "/atendente/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<AtendimentoVO>> getByAtendenteId(@PathVariable Long id) {
    List<AtendimentoVO> atendimento = service.getByAtendenteId(id);
    return ResponseEntity.ok(atendimento);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<AtendimentoVO> update(@RequestBody AtendimentoVO atendimentoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(atendimentoVO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
