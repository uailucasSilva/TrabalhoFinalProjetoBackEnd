package com.trabalhoFinal.trabalhoFinal.services.mapper.entity;

import com.trabalhoFinal.trabalhoFinal.models.Atendente;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
import org.springframework.stereotype.Component;

@Component
public class AtendenteMapper implements Mapper<AtendenteVO, Atendente> {

    @Override
    public Atendente map(AtendenteVO atendenteVO) {

        return Atendente.builder()
                .nome(atendenteVO.getNome())
                .email(atendenteVO.getEmail())
                .telefone(atendenteVO.getTelefone())
                .dataDeNascimento(atendenteVO.getDataDeNascimento())
                .nivelDeAcesso(atendenteVO.getNivelDeAcesso())
                .numeroDaMatricula(atendenteVO.getNumeroDaMatricula())
                .senha(atendenteVO.getSenha())
                .build();
    }
}
