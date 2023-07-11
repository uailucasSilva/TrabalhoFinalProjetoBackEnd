package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.SolicitacaoService;
import com.trabalhoFinal.trabalhoFinal.services.vo.SolicitacaoVO;
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
  @Operation(summary = "Cria uma solicitação.", description = "Cria uma solicitação.", tags = {
      "Solicitação" }, responses = {
          @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = SolicitacaoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<SolicitacaoVO> create(@RequestBody SolicitacaoVO solicitacaoVO) {
    SolicitacaoVO created = service.create(solicitacaoVO);
    return new ResponseEntity<>(created, HttpStatus.CREATED);
  }

  @GetMapping(produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Retorna todos as solicitações.", description = "Retorna todos as solicitações.", tags = {
      "Solicitação" }, responses = {
          @ApiResponse(description = "Sucess.", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = SolicitacaoVO.class)))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
      })
  public ResponseEntity<List<SolicitacaoVO>> getAll() {
    List<SolicitacaoVO> all = service.getAll();
    return ResponseEntity.ok(all);
  }

  @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca uma solicitação pelo ID.", description = "Busca uma solicitação pelo ID.", tags = {
      "Solicitação" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SolicitacaoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<SolicitacaoVO> getByID(@PathVariable Long id) {
    SolicitacaoVO solicitacaoVO = service.getById(id);
    return ResponseEntity.ok(solicitacaoVO);
  }

  @GetMapping(value = "/em-progresso", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML })
  @Operation(summary = "Busca todas as solicitações que estão com o status em progresso.", description = "Busca todas as solicitações que estão com o status em progresso.", tags = {
      "Solicitação" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = {
              @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SolicitacaoVO.class))
          }),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<List<SolicitacaoVO>> getEmAndamento() {
    List<SolicitacaoVO> solicitacaoVO = service.getAllEmProgresso();
    return ResponseEntity.ok(solicitacaoVO);
  }

  @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
      MediaType.APPLICATION_XML,
      MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
          MediaType.APPLICATION_XML,
          MediaType.APPLICATION_YML })
  @Operation(summary = "Atualiza uma solicitação pelo ID.", description = "Atualiza uma solicitação pelo ID.", tags = {
      "Solicitação" }, responses = {
          @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = SolicitacaoVO.class))),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
          @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
      })
  public ResponseEntity<SolicitacaoVO> update(@RequestBody SolicitacaoVO SolicitacaoVO,
      @PathVariable Long id) {
    return ResponseEntity.ok(service.update(SolicitacaoVO, id));
  }

  @DeleteMapping("/{id}")
  @Operation(tags = {
      "Solicitação" }, summary = "Apaga uma solicitação pelo ID.", description = "Apaga uma solicitação pelo ID.")
  public ResponseEntity<?> delete(@PathVariable Long id) {
    service.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
