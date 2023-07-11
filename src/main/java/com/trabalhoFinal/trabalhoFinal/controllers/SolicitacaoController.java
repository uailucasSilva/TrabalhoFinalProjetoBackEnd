package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.SolicitacaoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.SolicitacaoVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/solicitacao")
@Tag(name = "Solicitação", description = "Endpoints para CRUD de solicitação")
public class SolicitacaoController {

  @Autowired
  private SolicitacaoService service;

  @PostMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })

  public ResponseEntity<SolicitacaoVO> create(@RequestBody SolicitacaoVO solicitacaoVO) {
    SolicitacaoVO created = service.create(solicitacaoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<SolicitacaoVO>> getAll() {
    List<SolicitacaoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<SolicitacaoVO> getByID(@PathVariable Long id) {
    SolicitacaoVO solicitacaoVO = service.getById(id);
    return ResponseEntity.ok(solicitacaoVO);
  }

  @GetMapping(value = "/em-progresso", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<SolicitacaoVO>> getEmAndamento() {
    List<SolicitacaoVO> solicitacaoVO = service.getAllEmProgresso();
    return ResponseEntity.ok(solicitacaoVO);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<SolicitacaoVO> update(@RequestBody SolicitacaoVO SolicitacaoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(SolicitacaoVO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
