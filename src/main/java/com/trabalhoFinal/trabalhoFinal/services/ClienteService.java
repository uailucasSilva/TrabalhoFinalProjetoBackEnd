package com.trabalhoFinal.trabalhoFinal.services;

import com.trabalhoFinal.trabalhoFinal.models.Cliente;
import com.trabalhoFinal.trabalhoFinal.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    //Listar todos
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    //Buscar por ID
    public Optional<Cliente> findById(Long codCliente) {
        return clienteRepository.findById(Math.toIntExact(codCliente));
    }

    //Salvar Cliente
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    //Atualizar Cliente
    public Cliente updateCliente(Cliente cliente) {
        var dbPerson = findById(cliente.getCodCliente());
        if( dbPerson != null && !dbPerson.isEmpty()) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    //Deletar cliente
    public void deleteCliente(Long id) {
        var dbCliente = findById(id);
        if( dbCliente != null && !dbCliente.isEmpty()) {
            clienteRepository.deleteById(Math.toIntExact(id));
        }
    }

}
