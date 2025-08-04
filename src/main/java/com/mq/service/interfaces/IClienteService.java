package com.mq.service.interfaces;

import com.mq.persistence.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    void deleteById(Long id);
}
