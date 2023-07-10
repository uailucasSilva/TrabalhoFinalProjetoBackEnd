package com.trabalhoFinal.trabalhoFinal.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/version")
@Tag(name = "Version", description = "Endpoints Versão")

public class VersionController {

  @GetMapping
  @Operation(tags = "Version", summary = "Retorna versão da API")
  public ResponseEntity<String> getVersion() {
    return new ResponseEntity<>("v.01", HttpStatus.OK);
  }
}
