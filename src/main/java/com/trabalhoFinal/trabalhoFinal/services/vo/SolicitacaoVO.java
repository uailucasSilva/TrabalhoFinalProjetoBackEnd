package com.trabalhoFinal.trabalhoFinal.services.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.trabalhoFinal.trabalhoFinal.enums.StatusSolicitacao;
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
public class SolicitacaoVO extends RepresentationModel<SolicitacaoVO> {
    private Long id;
    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataHoraCriacao;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataHoraFinalizacao;
    private StatusSolicitacao statusSolicitacao;
    private Long dispositivoId;
}
