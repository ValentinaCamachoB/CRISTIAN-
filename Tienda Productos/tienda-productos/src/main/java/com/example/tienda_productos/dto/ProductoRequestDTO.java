package com.example.tienda_productos.dto;

import lombok.Data;
 
@Data
public class ProductoRequestDTO {
 
    private String nombre;
 
    private String descripcion;
 
    private String categoria;
 
    private Double precioCompra; 
 
    private Double precioVenta;
 
    private Integer stock; 
}
