package com.trabalhoFinal.trabalhoFinal.services;


import com.trabalhoFinal.trabalhoFinal.models.Dispositivo;
import com.trabalhoFinal.trabalhoFinal.repositories.ClienteRepository;
import com.trabalhoFinal.trabalhoFinal.repositories.DispositivoRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.entity.DispositivoMapper;
import com.trabalhoFinal.trabalhoFinal.services.mapper.vo.DispositivoVOMapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository repository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DispositivoMapper dispositivoMapper;

    @Autowired
    private DispositivoVOMapper voMapper;

    public DispositivoVO create(DispositivoVO dispositivoVO) {
        clienteRepository.findById(dispositivoVO.getClienteId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Dispositivo dispositivo = dispositivoMapper.map(dispositivoVO);
        Dispositivo dbDispositivo = repository.save(dispositivo);

        DispositivoVO newDispositivo = voMapper.map(dbDispositivo);
        return newDispositivo;
    }

    public List<DispositivoVO> getAll() {
        List<Dispositivo> dispositivos = repository.findAll();

        List<DispositivoVO> dispositivoVOList = dispositivos.stream()
                .map(voMapper::map)
                .collect(Collectors.toList());

        return dispositivoVOList;
    }

    public DispositivoVO getById(Long id) {
        Dispositivo dispositivo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        DispositivoVO dispositivoVO = voMapper.map(dispositivo);
        return dispositivoVO;
    }

    public DispositivoVO update(DispositivoVO dispositivoVO, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        clienteRepository.findById(dispositivoVO.getClienteId()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        Dispositivo dispositivo = dispositivoMapper.map(dispositivoVO);

        dispositivo.setId(id);
        Dispositivo updated = repository.save(dispositivo);

        DispositivoVO newDispositivoVO = voMapper.map(updated);
        return newDispositivoVO;
    }

    public void delete(Long id) {
        Dispositivo dispositivo = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(id);
    }

    public DispositivoVO getMostRecent(){
        Dispositivo cadastroMaisRecente = repository.getCadastroMaisRecente();

        DispositivoVO dispositivoVO = voMapper.map(cadastroMaisRecente);
        return dispositivoVO;
    }
}
