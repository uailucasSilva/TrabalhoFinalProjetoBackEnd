package com.trabalhoFinal.trabalhoFinal.services.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class AtendimentoVO extends RepresentationModel<AtendimentoVO> {
    private Long id;
    private Long atendenteId;
    private Long solicitacaoId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataHoraAtendimento;
    private String observacao;
}
