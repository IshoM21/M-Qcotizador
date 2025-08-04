package com.mq.persistence.repository;

import com.mq.persistence.entity.CotizacionProducto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CotizacionProductoRepository extends CrudRepository<CotizacionProducto, Long> {

    @Query("SELECT c FROM CotizacionProducto c WHERE c.cotizacion.id = ?1")
    List<CotizacionProducto> findByCotizacion(Long idCotizacion);
}
