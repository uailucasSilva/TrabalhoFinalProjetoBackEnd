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
public class AtendenteVO extends RepresentationModel<AtendenteVO> {
    private Long id;
    private String nome;
    private String email;
    private String numeroDaMatricula;
    private String telefone;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDeNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private NivelDeAcesso nivelDeAcesso;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String senha;
}
