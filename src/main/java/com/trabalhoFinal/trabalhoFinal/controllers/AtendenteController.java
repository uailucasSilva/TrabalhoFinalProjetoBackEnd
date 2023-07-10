package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.AtendenteService;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/atendente")
@Tag(name = "Atendente", description = "Endpoints para CRUD de atendente")
public class AtendenteController {

  @Autowired
  private AtendenteService service;

  @PostMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  @Operation(tags = "Atendente", summary = "Cria um atendente novo")
  public ResponseEntity<AtendenteVO> create(@RequestBody AtendenteVO atendenteVO) {
    AtendenteVO created = service.create(atendenteVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(tags = "Atendente", summary = "Busca Todos os atendentes")
  public ResponseEntity<List<AtendenteVO>> getAll() {
    List<AtendenteVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(tags = "Atendente", summary = "Busca atendente por ID")
  public ResponseEntity<AtendenteVO> getByID(@PathVariable Long id) {
    AtendenteVO atendente = service.getById(id);
    return ResponseEntity.ok(atendente);
  }

  @GetMapping(value = "/nivel-de-acesso/{nvl}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(tags = "Atendente", summary = "Busca atendente por nivel de acesso")
  public ResponseEntity<List<AtendenteVO>> getByNvlDeAcesso(@PathVariable String nvl) {
    List<AtendenteVO> atendente = service.getByNvl(nvl);
    return ResponseEntity.ok(atendente);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  @Operation(tags = "Atendente", summary = "Atualizada dados do atendente")
  public ResponseEntity<AtendenteVO> update(@RequestBody AtendenteVO atendenteVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(atendenteVO, id));
  }

  @DeleteMapping("/{id}")
  @Operation(tags = "Atendente", summary = "Apaga o atendente")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
