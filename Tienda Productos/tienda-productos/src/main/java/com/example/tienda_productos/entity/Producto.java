package com.example.tienda_productos.entity;

import jakarta.persistence.*;
import lombok.Data;
 
@Entity
@Table(name = "productos")
@Data
public class Producto {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name = "nombre")
    private String nombre;
 
    @Column(name = "descripcion")
    private String descripcion;
 
    @Column(name = "categoria")
    private String categoria;
 
    @Column(name = "precio_compra")
    private Double precioCompra; 
 
    @Column(name = "precio_venta")
    private Double precioVenta;
 
    @Column(name = "stock")
    private Integer stock; 
}