package com.company.springframework.service;

import java.util.List;

import com.company.springframework.model.Categoria;

public interface CategoriaService {
	Categoria guardarCategoria(Categoria categoria);

    Categoria actualizarCategoria(Categoria categoria);

    void eliminarCategoria(Long id);

    Categoria obtenerCategoria(Long id);

    List<Categoria> listarTodasLasCategorias();
}
