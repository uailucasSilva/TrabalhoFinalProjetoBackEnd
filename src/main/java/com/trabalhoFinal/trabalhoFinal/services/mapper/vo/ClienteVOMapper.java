package com.trabalhoFinal.trabalhoFinal.services.mapper.vo;

import com.trabalhoFinal.trabalhoFinal.controllers.ClienteController;
import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.AtendenteVO;
import com.trabalhoFinal.trabalhoFinal.services.vo.ClienteVO;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class ClienteVOMapper implements Mapper<Cliente, ClienteVO> {

    @Override
    public ClienteVO map(Cliente cliente) {

        ClienteVO clienteVO = ClienteVO.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .numeroDaMatricula(cliente.getNumeroDaMatricula())
                .dataDeNascimento(cliente.getDataDeNascimento())
                .telefone(cliente.getTelefone())
                .email(cliente.getEmail())
                .cep(cliente.getCep())
                .numeroDaCasa(cliente.getNumeroDaCasa())
                .rua(cliente.getRua())
                .cidade(cliente.getCidade())
                .bairro(cliente.getBairro())
                .build();

        clienteVO.add(WebMvcLinkBuilder.linkTo(ClienteController.class)
                .slash(clienteVO.getId()).withSelfRel());

        return clienteVO;
    }
}
