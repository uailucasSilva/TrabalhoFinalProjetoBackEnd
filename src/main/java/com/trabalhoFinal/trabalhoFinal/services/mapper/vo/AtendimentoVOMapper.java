package com.trabalhoFinal.trabalhoFinal.services.mapper.vo;

import com.trabalhoFinal.trabalhoFinal.controllers.AtendimentoController;
import com.trabalhoFinal.trabalhoFinal.models.Atendimento;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendimentoVO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoVOMapper implements Mapper<Atendimento, AtendimentoVO> {

    @Override
    public AtendimentoVO map(Atendimento atendimento) {

        AtendimentoVO atendimentoVO = AtendimentoVO.builder()
                .id(atendimento.getId())
                .atendenteId(atendimento.getAtendente().getId())
                .solicitacaoId(atendimento.getSolicitacao().getId())
                .dataHoraAtendimento(atendimento.getDataHoraDoAtendimento())
                .observacao(atendimento.getObservacao()).build();

        atendimentoVO.add(WebMvcLinkBuilder.linkTo(AtendimentoController.class)
                .slash(atendimentoVO.getId()).withSelfRel());

        return atendimentoVO;
    }
}
