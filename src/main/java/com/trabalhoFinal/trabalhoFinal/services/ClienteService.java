package com.trabalhoFinal.trabalhoFinal.services;


import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import com.trabalhoFinal.trabalhoFinal.repositories.ClienteRepository;
import com.trabalhoFinal.trabalhoFinal.services.mapper.entity.ClienteMapper;
import com.trabalhoFinal.trabalhoFinal.services.mapper.vo.ClienteVOMapper;
import com.trabalhoFinal.trabalhoFinal.services.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper clienteMapper;

    @Autowired
    private ClienteVOMapper voMapper;

    public ClienteVO create(ClienteVO clienteVO) {
        Random random = new Random();

        Integer numeroDaMatricula = random.nextInt(10000, 9000000);
        Cliente cliente = clienteMapper.map(clienteVO.withNumeroDaMatricula(numeroDaMatricula.toString()));
        Cliente dbCliente = repository.save(cliente);

        ClienteVO newCliente = voMapper.map(dbCliente);
        return newCliente;
    }

    public List<ClienteVO> getAll() {
        List<Cliente> clientes = repository.findAll();

        List<ClienteVO> clienteVOList = clientes.stream()
                .map(voMapper::map)
                .collect(Collectors.toList());

        return clienteVOList;
    }

    public ClienteVO getById(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        ClienteVO clienteVO = voMapper.map(cliente);
        return clienteVO;
    }

    public ClienteVO update(ClienteVO clienteVO, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Cliente cliente = clienteMapper.map(clienteVO);

        cliente.setId(id);
        Cliente updated = repository.save(cliente);

        ClienteVO newClienteVO = voMapper.map(updated);
        return newClienteVO;
    }

    public void delete(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        repository.deleteById(id);
    }

    public ClienteVO getByMatricula(String matricula) {
        Cliente clienteNameByNumeroDaMatricula = repository.getClienteNameByNumeroDaMatricula(matricula);

        ClienteVO clienteVO = voMapper.map(clienteNameByNumeroDaMatricula);
        return clienteVO;
    }
}
