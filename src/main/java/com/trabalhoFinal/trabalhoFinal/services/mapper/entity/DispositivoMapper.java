package com.trabalhoFinal.trabalhoFinal.services.mapper.entity;

import com.trabalhoFinal.trabalhoFinal.models.Dispositivo;
import com.trabalhoFinal.trabalhoFinal.repositories.ClienteRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispositivoMapper implements Mapper<DispositivoVO, Dispositivo> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Dispositivo map(DispositivoVO dispositivoVO) {
        return Dispositivo.builder()
                .nome(dispositivoVO.getNome())
                .descricao(dispositivoVO.getDescricao())
                .cliente(clienteRepository.findById(dispositivoVO.getClienteId()).get())
                .dataDeCadastro(dispositivoVO.getDataDeCadastro())
                .dataDeDevolucao(dispositivoVO.getDataDeDevolucao())
                .build();
    }
}
