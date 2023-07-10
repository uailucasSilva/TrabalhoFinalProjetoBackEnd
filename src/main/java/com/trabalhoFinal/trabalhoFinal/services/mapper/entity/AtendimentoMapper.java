package com.trabalhoFinal.trabalhoFinal.services.mapper.entity;

import com.trabalhoFinal.trabalhoFinal.models.Atendimento;
import com.trabalhoFinal.trabalhoFinal.repositories.AtendenteRepository;
import com.trabalhoFinal.trabalhoFinal.repositories.SolicitacaoRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendimentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtendimentoMapper implements Mapper<AtendimentoVO, Atendimento> {

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    @Override
    public Atendimento map(AtendimentoVO atendimentoVO) {

        return Atendimento.builder()
                .atendente(atendenteRepository.findById(atendimentoVO.getAtendenteId()).get())
                .solicitacao(solicitacaoRepository.findById(atendimentoVO.getSolicitacaoId()).get())
                .dataHoraDoAtendimento(atendimentoVO.getDataHoraAtendimento())
                .observacao(atendimentoVO.getObservacao())
                .build();
    }
}
