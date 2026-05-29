package com.example.tienda_productos.service;

import com.example.tienda_productos.dto.HttpGlobalResponse;
import com.example.tienda_productos.dto.ProductoRequestDTO;
import com.example.tienda_productos.dto.ProductoResponseDTO;
import com.example.tienda_productos.entity.Producto;
import com.example.tienda_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
@Service
@RequiredArgsConstructor
public class ProductoService {
 
    private final ProductoRepository productoRepository;
 
    // CREAR PRODUCTO
    public HttpGlobalResponse<ProductoResponseDTO> crearProducto(ProductoRequestDTO request) {
        HttpGlobalResponse<ProductoResponseDTO> respuesta = new HttpGlobalResponse<>();
 
        Producto nuevoProducto = new Producto();
        nuevoProducto.setNombre(request.getNombre());
        nuevoProducto.setDescripcion(request.getDescripcion());
        nuevoProducto.setCategoria(request.getCategoria());
        nuevoProducto.setPrecioCompra(request.getPrecioCompra()); // Se guarda en BD
        nuevoProducto.setPrecioVenta(request.getPrecioVenta());
        nuevoProducto.setStock(request.getStock());               // Se guarda en BD
        productoRepository.save(nuevoProducto);
 
        ProductoResponseDTO productoRespuesta = convertirADTO(nuevoProducto);
 
        respuesta.setMensaje("Producto creado correctamente");
        respuesta.setDatos(productoRespuesta);
        return respuesta;
    }

    // LISTAR TODOS LOS PRODUCTOS
    public HttpGlobalResponse<List<ProductoResponseDTO>> listarProductos() {
        HttpGlobalResponse<List<ProductoResponseDTO>> respuesta = new HttpGlobalResponse<>();
 
        List<Producto> productosEnBD = productoRepository.findAll();
        List<ProductoResponseDTO> listaDTO = new ArrayList<>();
 
        for (Producto producto : productosEnBD) {
            listaDTO.add(convertirADTO(producto));
        }
 
        respuesta.setMensaje("Productos encontrados: " + listaDTO.size());
        respuesta.setDatos(listaDTO);
        return respuesta;
    }
 
    // BUSCAR PRODUCTO POR ID
    public HttpGlobalResponse<ProductoResponseDTO> buscarProducto(Long id) {
        HttpGlobalResponse<ProductoResponseDTO> respuesta = new HttpGlobalResponse<>();
 
        Optional<Producto> productoEncontrado = productoRepository.findById(id);
 
        if (productoEncontrado.isEmpty()) {
            respuesta.setMensaje("Producto no encontrado con ID: " + id);
            return respuesta;
        }
 
        ProductoResponseDTO productoDTO = convertirADTO(productoEncontrado.get());
 
        respuesta.setMensaje("Producto encontrado");
        respuesta.setDatos(productoDTO);
        return respuesta;
    }
 
    // BUSCAR PRODUCTOS POR CATEGORÍA
    public HttpGlobalResponse<List<ProductoResponseDTO>> buscarPorCategoria(String categoria) {
        HttpGlobalResponse<List<ProductoResponseDTO>> respuesta = new HttpGlobalResponse<>();
 
        List<Producto> productosEncontrados = productoRepository.findByCategoria(categoria);
        List<ProductoResponseDTO> listaDTO = new ArrayList<>();
 
        for (Producto producto : productosEncontrados) {
            listaDTO.add(convertirADTO(producto));
        }
 
        respuesta.setMensaje("Productos en categoría '" + categoria + "': " + listaDTO.size());
        respuesta.setDatos(listaDTO);
        return respuesta;
    }
 
    // ACTUALIZAR PRODUCTO
    public HttpGlobalResponse<ProductoResponseDTO> actualizarProducto(Long id, ProductoRequestDTO request) {
        HttpGlobalResponse<ProductoResponseDTO> respuesta = new HttpGlobalResponse<>();
 
        Optional<Producto> productoEncontrado = productoRepository.findById(id);
 
        if (productoEncontrado.isEmpty()) {
            respuesta.setMensaje("Producto no encontrado con ID: " + id);
            return respuesta;
        }
 
        Producto producto = productoEncontrado.get();
        producto.setNombre(request.getNombre());
        producto.setDescripcion(request.getDescripcion());
        producto.setCategoria(request.getCategoria());
        producto.setPrecioCompra(request.getPrecioCompra());
        producto.setPrecioVenta(request.getPrecioVenta());
        producto.setStock(request.getStock());
        productoRepository.save(producto);
 
        ProductoResponseDTO productoDTO = convertirADTO(producto);
 
        respuesta.setMensaje("Producto actualizado correctamente");
        respuesta.setDatos(productoDTO);
        return respuesta;
    }
 
    // ELIMINAR PRODUCTO
    public HttpGlobalResponse<ProductoResponseDTO> eliminarProducto(Long id) {
        HttpGlobalResponse<ProductoResponseDTO> respuesta = new HttpGlobalResponse<>();
 
        Optional<Producto> productoEncontrado = productoRepository.findById(id);
 
        if (productoEncontrado.isEmpty()) {
            respuesta.setMensaje("Producto no encontrado con ID: " + id);
            return respuesta;
        }
 
        productoRepository.deleteById(id);
        respuesta.setMensaje("Producto eliminado correctamente");
        return respuesta;
    }
 
    private ProductoResponseDTO convertirADTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setCategoria(producto.getCategoria());
        dto.setPrecioVenta(producto.getPrecioVenta());

        return dto;
    }
}  

