package com.example.tienda_productos.dto;

import lombok.Data;
 
@Data
public class ProductoResponseDTO {
 
    private Long id;
 
    private String nombre;
 
    private String descripcion;
 
    private String categoria;
 
    private Double precioVenta; 
}
