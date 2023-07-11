package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.AtendimentoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendimentoVO;
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
  @Operation(summary = "Cria um atendimento.", description = "Cria um atendimento.", tags = {
      "Atendimento" }, responses = {
          @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = AtendimentoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<AtendimentoVO> create(@RequestBody AtendimentoVO atendimentoVO) {
    AtendimentoVO created = service.create(atendimentoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Retorna todos os atendimentos.", description = "Retorna todos os atendimentos.", tags = {
      "Atendimento" }, responses = {
          @ApiResponse(description = "Sucess.", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = AtendimentoVO.class)))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
      })
  public ResponseEntity<List<AtendimentoVO>> getAll() {
    List<AtendimentoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca um atendimento pelo ID.", description = "Busca um atendimento pelo ID.", tags = {
      "Atendimento" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AtendimentoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<AtendimentoVO> getByID(@PathVariable Long id) {
    AtendimentoVO atendimento = service.getById(id);
    return ResponseEntity.ok(atendimento);
  }

  @GetMapping(value = "/atendente/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca todos os atendimentos de um atendente pelo ID do atendente.", description = "Busca todos os atendimentos de um atendente pelo ID do atendente.", tags = {
      "Atendimento" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AtendimentoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<List<AtendimentoVO>> getByAtendenteId(@PathVariable Long id) {
    List<AtendimentoVO> atendimento = service.getByAtendenteId(id);
    return ResponseEntity.ok(atendimento);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  @Operation(summary = "Atualiza um atendimento pelo número de ID.", description = "Atualiza um atendimento pelo número de ID.", tags = {
      "Atendimento" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = AtendimentoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<AtendimentoVO> update(@RequestBody AtendimentoVO atendimentoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(atendimentoVO, id));
  }

  @DeleteMapping("/{id}")
  @Operation(tags = {
      "Atendimento" }, summary = "Apaga um atendimento pelo ID.", description = "Apaga um atendimento pelo ID.")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
