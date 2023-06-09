package com.trabalhoFinal.trabalhoFinal.controllers;

import com.trabalhoFinal.trabalhoFinal.services.AtendenteService;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
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
@RequestMapping("atendente")
@Tag(name = "Atendente", description = "Endpoints para CRUD de atendente.")
public class AtendenteController {

    @Autowired
    private AtendenteService service;

    @PostMapping(produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML })
    @Operation(summary = "Cria um atendente.", description = "Cria um atendente.", tags = { "Atendente" }, responses = {
            @ApiResponse(description = "Created", responseCode = "201", content = @Content(schema = @Schema(implementation = AtendenteVO.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
            @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
    })
    public ResponseEntity<AtendenteVO> create(@RequestBody AtendenteVO atendenteVO) {
        AtendenteVO created = service.create(atendenteVO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML })
    @Operation(summary = "Retorna todos os atendentes.", description = "Retorna todos os atendentes.", tags = {
            "Atendente" }, responses = {
                    @ApiResponse(description = "Sucess.", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, array = @ArraySchema(schema = @Schema(implementation = AtendenteVO.class)))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content),
            })
    public ResponseEntity<List<AtendenteVO>> getAll() {
        List<AtendenteVO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML })
    @Operation(summary = "Busca um atendente pelo ID.", description = "Busca um atendente pelo ID.", tags = {
            "Atendente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AtendenteVO.class))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<AtendenteVO> getByID(@PathVariable("id") Long id) {
        AtendenteVO atendente = service.getById(id);
        return ResponseEntity.ok(atendente);
    }

    @GetMapping(value = "/nivel-de-acesso/{nvl}", produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML })
    @Operation(summary = "Busca um atendente pelo nível de acesso.", description = "Busca um atendente pelo nível de acesso.", tags = {
            "Atendente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = {
                            @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = AtendenteVO.class))
                    }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<AtendenteVO>> getByNvlDeAcesso(@PathVariable String nvl) {
        List<AtendenteVO> atendente = service.getByNvl(nvl);
        return ResponseEntity.ok(atendente);
    }

    @PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON,
            MediaType.APPLICATION_XML,
            MediaType.APPLICATION_YML }, consumes = { MediaType.APPLICATION_JSON,
                    MediaType.APPLICATION_XML,
                    MediaType.APPLICATION_YML })
    @Operation(summary = "Atualiza um atendente pelo número de ID.", description = "Atualiza um atendente pelo número de ID.", tags = {
            "Atendente" }, responses = {
                    @ApiResponse(description = "Success", responseCode = "200", content = @Content(schema = @Schema(implementation = AtendenteVO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<AtendenteVO> update(@RequestBody AtendenteVO atendenteVO,
            @PathVariable Long id) {
        return ResponseEntity.ok(service.update(atendenteVO, id));
    }

    @DeleteMapping("/{id}")
    @Operation(tags = {
            "Atendente" }, summary = "Apaga um atendente pelo ID.", description = "Apaga um atendente pelo ID.")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
