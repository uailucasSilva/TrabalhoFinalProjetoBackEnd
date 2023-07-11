package com.trabalhoFinal.trabalhoFinal.services.mapper.vo;

import com.trabalhoFinal.trabalhoFinal.controllers.DispositivoController;
import com.trabalhoFinal.trabalhoFinal.models.Dispositivo;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.DispositivoVO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class DispositivoVOMapper implements Mapper<Dispositivo, DispositivoVO> {

    @Override
    public DispositivoVO map(Dispositivo dispositivo) {

        DispositivoVO dispositivoVO = DispositivoVO.builder()
                .id(dispositivo.getId())
                .nome(dispositivo.getNome())
                .descricao(dispositivo.getDescricao())
                .dataDeCadastro(dispositivo.getDataDeCadastro())
                .dataDeDevolucao(dispositivo.getDataDeDevolucao())
                .clienteId(dispositivo.getCliente().getId())
                .build();

        dispositivoVO.add(WebMvcLinkBuilder.linkTo(DispositivoController.class)
                .slash(dispositivoVO.getId()).withSelfRel());

        return dispositivoVO;
    }
}