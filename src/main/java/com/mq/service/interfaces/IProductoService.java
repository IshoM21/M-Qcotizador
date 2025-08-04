package com.mq.service.interfaces;

import com.mq.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    Optional<Producto> findById(Long id);
    Optional<Producto> findByNombre(String nombre);
    List<Producto> findAll();
    void save(Producto producto);
    void deleteById(Long id);
}
