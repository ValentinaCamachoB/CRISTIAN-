package com.example.tienda_productos.dto;

import lombok.Data;
 
@Data
public class HttpGlobalResponse<T> {
 
    private String mensaje; 
 
    private T datos; 
}