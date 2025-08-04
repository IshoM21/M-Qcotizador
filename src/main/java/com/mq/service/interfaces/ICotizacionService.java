package com.mq.service.interfaces;

import com.mq.persistence.entity.Cotizacion;

import java.util.List;
import java.util.Optional;

public interface ICotizacionService {
    Optional<Cotizacion> getCotizacionById(Long id);
    List<Cotizacion> getAllCotizaciones();
    void saveCotizacion(Cotizacion cotizacion);
    void deleteCotizacion(Long id);
}
