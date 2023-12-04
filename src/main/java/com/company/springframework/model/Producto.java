package com.company.springframework.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_producto")
@Getter
@Setter
public class Producto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String descripcion;

    @Column(precision = 10, scale = 2)
    private BigDecimal precio;

    @Column
    private int stock;

    @Column
    private byte estado;

    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
}
