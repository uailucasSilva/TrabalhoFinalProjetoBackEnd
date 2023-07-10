package com.trabalhoFinal.trabalhoFinal.services.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class DispositivoVO extends RepresentationModel<DispositivoVO> {
    private Long id;
    private String nome;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDeCadastro;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataDeDevolucao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long clienteId;
}
