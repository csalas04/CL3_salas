package com.company.springframework;

import com.company.springframework.model.Producto;
import com.company.springframework.model.Categoria;
import com.company.springframework.repository.CategoriaRepository;
import com.company.springframework.repository.ProductoRepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringframeworkInitialApplicationTests {

	@Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;



    @Test
    void insertarCategoria() {
        Categoria categoria = new Categoria();
        categoria.setDescripcion("Helados");

        Categoria categoriaRegistrada = categoriaRepository.save(categoria);

        assertThat(categoriaRegistrada).isNotNull();
        assertThat(categoriaRegistrada.getId()).isPositive();
        assertThat(categoriaRegistrada.getDescripcion()).isNotEmpty();
    }


    @Test
    void insertarProducto() {
        Producto producto = new Producto();
        producto.setDescripcion("Morocha Pezziduri");
        producto.setPrecio(new BigDecimal("29.99"));
        producto.setStock(20);
        producto.setEstado((byte) 1);

        Categoria categoria = new Categoria();
        categoria.setDescripcion("Helados");
        Categoria categoriaRegistrada = categoriaRepository.save(categoria);

        producto.setCategoria(categoriaRegistrada);

        Producto productoRegistrado = productoRepository.save(producto);

        assertThat(productoRegistrado).isNotNull();
        assertThat(productoRegistrado.getId()).isPositive();
        assertThat(productoRegistrado.getDescripcion()).isNotEmpty();
        assertThat(productoRegistrado.getPrecio()).isNotNull();
        assertThat(productoRegistrado.getStock()).isPositive();
        assertThat(productoRegistrado.getEstado()).isEqualTo((byte) 1);
        assertThat(productoRegistrado.getCategoria()).isNotNull();
        assertThat(productoRegistrado.getCategoria().getId()).isPositive();
        assertThat(productoRegistrado.getCategoria().getDescripcion()).isNotEmpty();
    }

    @Test
    void actualizarProducto() {

        Producto producto = productoRepository.findById(1L).orElse(null);

        producto.setDescripcion("Morocha Pezziduri 1L");

        productoRepository.save(producto);

        Producto productoActualizado = productoRepository.findById(1L).orElse(null);
        assertThat(productoActualizado.getDescripcion()).isEqualTo("Morocha Pezziduri 1L");
    }

    @Test
    void listarCategoria(){
        Iterable<Categoria> categorias = categoriaRepository.findAll();
        assertThat(categorias).isNotEmpty();
    }

    @Test
    void jpa_query_methods(){
        Iterable<Producto> productos = productoRepository.findByStock(20);
        assertThat(productos).isNotEmpty();

    }
    
    @Test
    void eliminarProducto() {

        productoRepository.deleteById(1L);

        Producto productoEliminado = productoRepository.findById(1L).orElse(null);
        assertThat(productoEliminado).isNull();

    }
}
