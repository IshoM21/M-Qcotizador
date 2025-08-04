package com.mq.service.interfaces;

import com.mq.persistence.entity.CotizacionProducto;

import java.util.List;
import java.util.Optional;

public interface ICotizacionProductoService {
    Optional<CotizacionProducto> findById(Long id);
    List<CotizacionProducto> findAll();
    List<CotizacionProducto> findByIdCotizacion(Long idCotizacion);
    CotizacionProducto save(CotizacionProducto cotizacionProducto);
    void delete(CotizacionProducto cotizacionProducto);
}
