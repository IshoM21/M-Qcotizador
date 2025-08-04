package com.mq.service.implementation;

import com.mq.persistence.entity.Cliente;
import com.mq.persistence.repository.ClienteRepository;
import com.mq.service.exception.ClienteException;
import com.mq.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Optional<Cliente> findById(Long id) {
        return  clienteRepository.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepository.findAll();
    }

    @Override
    public Cliente save(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new ClienteException("El RFC ya está registrado en el sistema.");
        }
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
