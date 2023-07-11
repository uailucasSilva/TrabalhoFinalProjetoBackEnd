package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.ClienteService;
import com.trabalhoFinal.trabalhoFinal.services.vo.ClienteVO;
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
@RequestMapping(value = "/cliente")
@Tag(name = "Cliente", description = "Endpoints para CRUD de cliente.")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping(produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML })
    @Operation(summary = "Cria um cliente.", description = "Cria um cliente.", tags = { "Cliente" }, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = ClienteVO.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<ClienteVO> create(@RequestBody ClienteVO clienteVO) {
        ClienteVO created = service.create(clienteVO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML })
    @Operation(summary = "Retorna todos os clientes.", description = "Retorna todos os cliente.", tags = {
            "Cliente" }, responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = ClienteVO.class)))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<ClienteVO>> getAll() {
        List<ClienteVO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca um cliente pelo ID.", description = "Busca um cliente pelo ID.", tags = {
            "Cliente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ClienteVO.class))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ClienteVO> getByID(@PathVariable Long id) {
        ClienteVO cliente = service.getById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(value = "/matricula/{matricula}", produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML })
    @Operation(summary = "Busca um cliente pelo número de matrícula.", description = "Busca um cliente pelo número de matrícula.", tags = {
            "Cliente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = ClienteVO.class))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ClienteVO> getClienteByNumeroDaMatricula(@PathVariable String matricula) {
        ClienteVO byMatricula = service.getByMatricula(matricula);
        return ResponseEntity.ok(byMatricula);
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML })
    @Operation(summary = "Atualiza um cliente pelo número de ID.", description = "Atualiza um cliente pelo número de ID.", tags = {
            "Cliente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = ClienteVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<ClienteVO> update(@RequestBody ClienteVO ClienteVO,
            @PathVariable Long id) {
        return ResponseEntity.ok(service.update(ClienteVO, id));
    }

    @DeleteMapping("/{id}")
    @Operation(tags = {
            "Cliente" }, summary = "Apaga um cliente pelo ID.", description = "Apaga um cliente pelo ID.")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
