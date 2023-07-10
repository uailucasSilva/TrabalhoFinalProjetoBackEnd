package com.trabalhoFinal.trabalhoFinal.services.mapper.vo;

import com.trabalhoFinal.trabalhoFinal.controllers.SolicitacaoController;
import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import com.trabalhoFinal.trabalhoFinal.services.DispositivoService;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import com.trabalhoFinal.trabalhoFinal.services.vo.SolicitacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoVOMapper implements Mapper<Solicitacao, SolicitacaoVO> {

    @Override
    public SolicitacaoVO map(Solicitacao solicitacao) {

        SolicitacaoVO solicitacaoVO = SolicitacaoVO.builder()
                .id(solicitacao.getId())
                .titulo(solicitacao.getTitulo())
                .descricao(solicitacao.getDescricao())
                .dataHoraCriacao(solicitacao.getDataHoraCriacao())
                .dataHoraFinalizacao(solicitacao.getDataHoraFinalizacao())
                .statusSolicitacao(solicitacao.getStatusSolicitacao())
                .dispositivoId(solicitacao.getDispositivo().getId())
                .build();

        solicitacaoVO.add(WebMvcLinkBuilder.linkTo(SolicitacaoController.class)
                .slash(solicitacaoVO.getId()).withSelfRel());

        return solicitacaoVO;
    }
}
