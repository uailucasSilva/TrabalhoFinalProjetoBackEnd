package com.trabalhoFinal.trabalhoFinal.services;


import com.trabalhoFinal.trabalhoFinal.models.Atendimento;
import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import com.trabalhoFinal.trabalhoFinal.enums.NivelDeAcesso;
import com.trabalhoFinal.trabalhoFinal.repositories.AtendenteRepository;
import com.trabalhoFinal.trabalhoFinal.repositories.AtendimentoRepository;
import com.trabalhoFinal.trabalhoFinal.repositories.SolicitacaoRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.entity.AtendimentoMapper;
import com.trabalhoFinal.trabalhoFinal.services.mapper.vo.AtendimentoVOMapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendimentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;

    @Autowired
    private AtendimentoVOMapper atendimentoVOMapper;

    @Autowired
    private AtendimentoMapper atendimentoMapper;

    @Autowired
    private AtendenteRepository atendenteRepository;

    @Autowired
    private SolicitacaoRepository solicitacaoRepository;

    public AtendimentoVO create(AtendimentoVO atendimentoVO) {
        atendenteRepository.findById(atendimentoVO.getAtendenteId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atendente não encontrado"));

        solicitacaoRepository.findById(atendimentoVO.getSolicitacaoId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Solicitação não encontrada"));

        Atendimento atendimento = atendimentoMapper.map(atendimentoVO);
        Atendimento dbAtendimento = repository.save(atendimento);

        AtendimentoVO newAtendimentoVO = atendimentoVOMapper.map(dbAtendimento);
        return newAtendimentoVO;
    }

    public List<AtendimentoVO> getAll() {
        List<Atendimento> atendimentos = repository.findAll();

        List<AtendimentoVO> atendimentoVOList = atendimentos.stream()
                .map(atendimentoVOMapper::map)
                .collect(Collectors.toList());

        return atendimentoVOList;
    }

    public AtendimentoVO getById(Long id) {
        Atendimento atendimento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        AtendimentoVO atendimentoVO = atendimentoVOMapper.map(atendimento);
        return atendimentoVO;
    }

    public AtendimentoVO update(AtendimentoVO atendimentoVO, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Atendimento atendimento = atendimentoMapper.map(atendimentoVO);

        atendimento.setId(id);
        Atendimento updated = repository.save(atendimento);

        AtendimentoVO newAtendimentoVO = atendimentoVOMapper.map(updated);
        return newAtendimentoVO;
    }

    public void delete(Long id) {
        Atendimento atendimento = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(id);
    }

    public List<AtendimentoVO> getByAtendenteId(Long atendenteId) {
        List<Atendimento> atendimento = repository.findByAtendenteId(atendenteId);

        return atendimento.stream()
                .map(atendimentoVOMapper::map)
                .collect(Collectors.toList());
    }
}
