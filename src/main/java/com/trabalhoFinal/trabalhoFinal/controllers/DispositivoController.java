package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.ClienteService;
import com.trabalhoFinal.trabalhoFinal.services.DispositivoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/dispositivo")
@Tag(name = "Dispositivo", description = "Endpoints para CRUD de dispositivo")
public class DispositivoController {

  @Autowired
  private DispositivoService service;

  @PostMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<DispositivoVO> create(@RequestBody DispositivoVO dispositivoVO) {
    DispositivoVO created = service.create(dispositivoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<List<DispositivoVO>> getAll() {
    List<DispositivoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<DispositivoVO> getByID(@PathVariable Long id) {
    DispositivoVO dispositivoVO = service.getById(id);
    return ResponseEntity.ok(dispositivoVO);
  }

  @GetMapping(value = "/recente", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  public ResponseEntity<DispositivoVO> getMostRecent() {
    DispositivoVO dispositivoVO = service.getMostRecent();
    return ResponseEntity.ok(dispositivoVO);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  public ResponseEntity<DispositivoVO> update(@RequestBody DispositivoVO DispositivoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(DispositivoVO, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
