package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.DispositivoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import com.trabalhoFinal.trabalhoFinal.utils.MediaType;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
  @Operation(summary = "Cria um dispositivo.", description = "Cria um dispositivo.", tags = {
      "Dispositivo" }, responses = {
          @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = DispositivoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<DispositivoVO> create(@RequestBody DispositivoVO dispositivoVO) {
    DispositivoVO created = service.create(dispositivoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Retorna todos os dispositivos.", description = "Retorna todos os dispositivos.", tags = {
      "Dispositivos" }, responses = {
          @ApiResponse(description = "Sucess.", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = DispositivoVO.class)))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
      })
  public ResponseEntity<List<DispositivoVO>> getAll() {
    List<DispositivoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca um dispositivo pelo ID.", description = "Busca um dispositivo pelo ID.", tags = {
      "Dispositivo" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DispositivoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<DispositivoVO> getByID(@PathVariable Long id) {
    DispositivoVO dispositivoVO = service.getById(id);
    return ResponseEntity.ok(dispositivoVO);
  }

  @GetMapping(value = "/recente", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca o dispositivo cadastrado mais recente.", description = "Busca o dispositivo cadastrado mais recente.", tags = {
      "Dispositivo" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = DispositivoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<DispositivoVO> getMostRecent() {
    DispositivoVO dispositivoVO = service.getMostRecent();
    return ResponseEntity.ok(dispositivoVO);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  @Operation(summary = "Atualiza um dispositivo pelo número de ID.", description = "Atualiza um dispositivo pelo número de ID.", tags = {
      "Dispositivo" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = DispositivoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<DispositivoVO> update(@RequestBody DispositivoVO DispositivoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(DispositivoVO, id));
  }

  @DeleteMapping("/{id}")
  @Operation(tags = {
      "Dispositivo" }, summary = "Apaga um dispositivo pelo ID.", description = "Apaga um dispositivo pelo ID.")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
