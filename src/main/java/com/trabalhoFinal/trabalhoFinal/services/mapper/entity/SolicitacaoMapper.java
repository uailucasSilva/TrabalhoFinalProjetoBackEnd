package com.trabalhoFinal.trabalhoFinal.services.mapper.entity;

import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import com.trabalhoFinal.trabalhoFinal.repositories.DispositivoRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.SolicitacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoMapper implements Mapper<SolicitacaoVO, Solicitacao> {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Override
    public Solicitacao map(SolicitacaoVO solicitacaoVO) {
        return Solicitacao.builder()
                .titulo(solicitacaoVO.getTitulo())
                .descricao(solicitacaoVO.getDescricao())
                .dispositivo(dispositivoRepository.findById(solicitacaoVO.getDispositivoId()).get())
                .dataHoraCriacao(solicitacaoVO.getDataHoraCriacao())
                .dataHoraFinalizacao(solicitacaoVO.getDataHoraFinalizacao())
                .statusSolicitacao(solicitacaoVO.getStatusSolicitacao())
                .build();
    }
}
