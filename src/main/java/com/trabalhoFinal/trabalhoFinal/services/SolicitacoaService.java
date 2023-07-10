package com.trabalhoFinal.trabalhoFinal.services;

import com.trabalhoFinal.trabalhoFinal.models.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitacoaService {
    @Autowired
    private SolicitacoaService solicitacoaService;

    //Listar todos
    public List<Solicitacao> findAll() {
        return solicitacoaService.findAll();
    }

    //Buscar por ID
    public Optional<Solicitacao> findById(Long codDispositivo) {
        return solicitacoaService.findById(codDispositivo);
    }

    //Salvar Solicitacao
    public Solicitacao saveSolicitacao(Solicitacao solicitacao) {
        return solicitacoaService.save(solicitacao);
    }

    //Atualizar Dispositivo
    public Solicitacao updateDispositivo(Solicitacao solicitacao) {
        var dbSolicitacao = findById(solicitacao.getCodSolicitacao());
        if( dbSolicitacao != null && !dbSolicitacao.isEmpty()) {
            return solicitacoaService.save(solicitacao);
        }
        return null;
    }

    //Deletar Dispositivo
    public void deleteDispositivo(Long id) {
        var dbSolicitacao = findById(id);
        if( dbSolicitacao != null && !dbSolicitacao.isEmpty()) {
            solicitacoaService.deleteById(Math.toIntExact(id));
        }
    }
}
