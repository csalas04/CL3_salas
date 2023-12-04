package com.company.springframework.service;

import java.util.List;

import com.company.springframework.model.Producto;

public interface ProductoService {
	Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Long id);

    Producto obtenerProducto(Long id);

    List<Producto> listarTodosLosProductos();
}
