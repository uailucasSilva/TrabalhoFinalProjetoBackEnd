package com.trabalhoFinal.trabalhoFinal.services.mapper.vo;


import com.trabalhoFinal.trabalhoFinal.controllers.AtendenteController;
import com.trabalhoFinal.trabalhoFinal.models.Atendente;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class AtendenteVOMapper implements Mapper<Atendente, AtendenteVO> {

    @Override
    public AtendenteVO map(Atendente atendente) {

        AtendenteVO atendenteVO = AtendenteVO.builder()
                .id(atendente.getId())
                .nome(atendente.getNome())
                .email(atendente.getEmail())
                .numeroDaMatricula(atendente.getNumeroDaMatricula())
                .telefone(atendente.getTelefone())
                .dataDeNascimento(atendente.getDataDeNascimento()).build();

        atendenteVO.add(WebMvcLinkBuilder.linkTo(AtendenteController.class)
                .slash(atendenteVO.getId()).withSelfRel());

        return atendenteVO;
    }
}
