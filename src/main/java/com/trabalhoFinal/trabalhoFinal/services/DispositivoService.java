package com.trabalhoFinal.trabalhoFinal.services;

import com.trabalhoFinal.trabalhoFinal.models.Dispositivo;
import com.trabalhoFinal.trabalhoFinal.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DispositivoService {
    @Autowired
    private DispositivoRepository dispositivoRepository;

    //Listar todos
    public List<Dispositivo> findAll() {
        return dispositivoRepository.findAll();
    }

    //Buscar por ID
    public Optional<Dispositivo> findById(Long codAtendente) {
        return dispositivoRepository.findById(Math.toIntExact(codAtendente));
    }

    //Salvar Dispositivo
    public Dispositivo saveDispositivo(Dispositivo dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }

    //Atualizar Dispositivo
    public Dispositivo updateDispositivo(Dispositivo dispositivo) {
        var dbDispositivo = findById(dispositivo.getCodDispositivo());
        if( dbDispositivo != null && !dbDispositivo.isEmpty()) {
            return dispositivoRepository.save(dispositivo);
        }
        return null;
    }

    //Deletar Dispositivo
    public void deleteDispositivo(Long id) {
        var dbDispositivo = findById(id);
        if( dbDispositivo != null && !dbDispositivo.isEmpty()) {
            dispositivoRepository.deleteById(Math.toIntExact(id));
        }
    }
}
