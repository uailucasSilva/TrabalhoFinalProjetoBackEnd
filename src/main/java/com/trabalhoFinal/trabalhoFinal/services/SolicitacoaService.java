package com.trabalhoFinal.trabalhoFinal.services;

import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import com.trabalhoFinal.trabalhoFinal.repositories.DispositivoRepository;
import com.trabalhoFinal.trabalhoFinal.repositories.SolicitacaoRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.entity.SolicitacaoMapper;
import com.trabalhoFinal.trabalhoFinal.services.mapper.vo.SolicitacaoVOMapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.SolicitacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitacaoService {

    @Autowired
    private SolicitacaoRepository repository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private SolicitacaoMapper solicitacaoMapper;

    @Autowired
    private SolicitacaoVOMapper voMapper;

    public SolicitacaoVO create(SolicitacaoVO solicitacaoVO) {
        dispositivoRepository.findById(solicitacaoVO.getDispositivoId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dispositivo não encontrado"));

        Solicitacao solicitacao = solicitacaoMapper.map(solicitacaoVO);
        Solicitacao dbSolicitacao = repository.save(solicitacao);

        SolicitacaoVO newSolicitacao = voMapper.map(dbSolicitacao);
        return newSolicitacao;
    }

    public List<SolicitacaoVO> getAll() {
        List<Solicitacao> solicitacaos = repository.findAll();

        List<SolicitacaoVO> solicitacaoVOList = solicitacaos.stream()
                .map(voMapper::map)
                .collect(Collectors.toList());

        return solicitacaoVOList;
    }

    public SolicitacaoVO getById(Long id) {
        Solicitacao solicitacao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        SolicitacaoVO solicitacaoVO = voMapper.map(solicitacao);
        return solicitacaoVO;
    }

    public SolicitacaoVO update(SolicitacaoVO solicitacaoVO, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        dispositivoRepository.findById(solicitacaoVO.getDispositivoId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Dispositivo não encontrado"));

        Solicitacao solicitacao = solicitacaoMapper.map(solicitacaoVO);

        solicitacao.setId(id);
        Solicitacao updated = repository.save(solicitacao);

        SolicitacaoVO newSolicitacaoVO = voMapper.map(updated);
        return newSolicitacaoVO;
    }

    public void delete(Long id) {
        Solicitacao solicitacao = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(id);
    }

    public List<SolicitacaoVO> getAllEmProgresso() {
        List<Solicitacao> allEmProgresso = repository.getAllEmProgresso();
        return allEmProgresso.stream().map(voMapper::map).collect(Collectors.toList());
    }
}
