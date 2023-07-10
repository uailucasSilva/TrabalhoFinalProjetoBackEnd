package com.trabalhoFinal.trabalhoFinal.services.mapper.entity;

import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import com.trabalhoFinal.trabalhoFinal.services.mapper.Mapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.ClienteVO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper implements Mapper<ClienteVO, Cliente> {

    @Override
    public Cliente map(ClienteVO clienteVO) {

        return Cliente.builder()
                .nome(clienteVO.getNome())
                .email(clienteVO.getEmail())
                .telefone(clienteVO.getTelefone())
                .numeroDaMatricula(clienteVO.getNumeroDaMatricula())
                .dataDeNascimento(clienteVO.getDataDeNascimento())
                .senha(clienteVO.getSenha())
                .cep(clienteVO.getCep())
                .rua(clienteVO.getRua())
                .bairro(clienteVO.getBairro())
                .cidade(clienteVO.getCidade())
                .numeroDaCasa(clienteVO.getNumeroDaCasa())
                .build();
    }
}
