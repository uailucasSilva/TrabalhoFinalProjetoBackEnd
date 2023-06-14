package com.trabalhoFinal.trabalhoFinal.services;

import com.trabalhoFinal.trabalhoFinal.models.Atendente;
import com.trabalhoFinal.trabalhoFinal.repositories.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendenteService {
    @Autowired
    private AtendenteRepository atendenteRepository;

    //Listar todos
    public List<Atendente> findAll() {
        return atendenteRepository.findAll();
    }

    //Buscar por ID
    public Optional<Atendente> findById(Long codCliente) {
        return atendenteRepository.findById(Math.toIntExact(codCliente));
    }

    //Salvar Atendente
    public Atendente saveAtendente(Atendente atendente) {
        return atendenteRepository.save(atendente);
    }

    //Atualizar Atendente
    public Atendente updateAtendente(Atendente atendente) {
        var dbPerson = findById(atendente.getCodAtendente());
        if( dbPerson != null && !dbPerson.isEmpty()) {
            return atendenteRepository.save(atendente);
        }
        return null;
    }

    //Deletar Atendente
    public void deleteAtendente(Long id) {
        var dbCliente = findById(id);
        if( dbCliente != null && !dbCliente.isEmpty()) {
            atendenteRepository.deleteById(Math.toIntExact(id));
        }
    }

}
