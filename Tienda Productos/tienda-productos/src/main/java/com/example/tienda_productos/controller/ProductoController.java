package com.example.tienda_productos.controller;

import com.example.tienda_productos.dto.HttpGlobalResponse;
import com.example.tienda_productos.dto.ProductoRequestDTO;
import com.example.tienda_productos.dto.ProductoResponseDTO;
import com.example.tienda_productos.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
// El controller recibe las peticiones HTTP del cliente
// Solo trabaja con DTOs, nunca con entidades directamente
@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {
 
    private final ProductoService productoService;
 
    // POST /productos/crear
    // Recibe un ProductoRequestDTO con todos los datos del producto
    @PostMapping("/crear")
    public HttpGlobalResponse<ProductoResponseDTO> crearProducto(@RequestBody ProductoRequestDTO request) {
        return productoService.crearProducto(request);
    }
 
    // GET /productos/listar
    // Retorna todos los productos SIN precioCompra ni stock
    @GetMapping("/listar")
    public HttpGlobalResponse<List<ProductoResponseDTO>> listarProductos() {
        return productoService.listarProductos();
    }
 
    // GET /productos/buscar/1
    // Retorna el producto con el ID indicado
    @GetMapping("/buscar/{id}")
    public HttpGlobalResponse<ProductoResponseDTO> buscarProducto(@PathVariable Long id) {
        return productoService.buscarProducto(id);
    }
 
    // GET /productos/categoria/Electronicos
    // Retorna todos los productos de una categoría
    @GetMapping("/categoria/{categoria}")
    public HttpGlobalResponse<List<ProductoResponseDTO>> buscarPorCategoria(@PathVariable String categoria) {
        return productoService.buscarPorCategoria(categoria);
    }
 
    // PUT /productos/actualizar/1
    // Actualiza los datos del producto con el ID indicado
    @PutMapping("/actualizar/{id}")
    public HttpGlobalResponse<ProductoResponseDTO> actualizarProducto(
            @PathVariable Long id,
            @RequestBody ProductoRequestDTO request) {
        return productoService.actualizarProducto(id, request);
    }
 
    // DELETE /productos/eliminar/1
    // Elimina el producto con el ID indicado
    @DeleteMapping("/eliminar/{id}")
    public HttpGlobalResponse<ProductoResponseDTO> eliminarProducto(@PathVariable Long id) {
        return productoService.eliminarProducto(id);
    }
}
