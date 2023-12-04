package com.company.springframework.repository;

import com.company.springframework.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    List<Producto> findByDescripcion(String descripcion);

    List<Producto> findByPrecio(BigDecimal precio);

    List<Producto> findByStock(int stock);

    List<Producto> findByEstado(byte estado);

    List<Producto> findByCategoriaDescripcion(String categoriaDescripcion);


}

