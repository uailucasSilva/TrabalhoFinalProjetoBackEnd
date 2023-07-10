package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.ClienteService;
import com.trabalhoFinal.trabalhoFinal.services.vo.ClienteVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
@Tag(name = "Cliente", description = "Endpoints para CRUD de cliente")
public class ClienteController {

  @Autowired
  private ClienteService service;

  @PostMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<ClienteVO> create(@RequestBody ClienteVO clienteVO) {
    ClienteVO created = service.create(clienteVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<ClienteVO>> getAll() {
    List<ClienteVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<ClienteVO> getByID(@PathVariable Long id) {
    ClienteVO atendente = service.getById(id);
    return ResponseEntity.ok(atendente);
  }

  @GetMapping(value = "/matricula/{matricula}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<ClienteVO> getClienteByNumeroDaMatricula(@PathVariable String matricula) {
    ClienteVO byMatricula = service.getByMatricula(matricula);
    return ResponseEntity.ok(byMatricula);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<ClienteVO> update(@RequestBody ClienteVO ClienteVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(ClienteVO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
