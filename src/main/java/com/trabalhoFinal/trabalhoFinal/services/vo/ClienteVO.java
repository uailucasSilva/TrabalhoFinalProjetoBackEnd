package com.trabalhoFinal.trabalhoFinal.services.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trabalhoFinal.trabalhoFinal.enums.NivelDeAcesso;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Getter
@Setter
@Builder
@With
public class ClienteVO extends RepresentationModel<ClienteVO> {
    private Long id;
    private String nome;
    private String numeroDaMatricula;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDeNascimento;
    private String telefone;
    private String email;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;
    private String rua;
    private String bairro;
    private String numeroDaCasa;
    private String cidade;
    private String cep;
}
