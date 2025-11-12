package com.utn.productos.service;

import com.utn.productos.dto.ActualizarStockDTO;
import com.utn.productos.dto.ProductoDTO;
import com.utn.productos.dto.ProductoResponseDTO;
import com.utn.productos.exception.ProductoNotFoundException;
import com.utn.productos.model.Producto;
import com.utn.productos.model.Categoria;
import com.utn.productos.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    // Crear
    public ProductoResponseDTO crearProducto(ProductoDTO dto) {
        Producto p = dtoToEntity(dto);
        Producto guardado = repo.save(p);
        return entityToResponseDTO(guardado);
    }

    // Todos
    public List<ProductoResponseDTO> obtenerTodos() {
        return repo.findAll().stream().map(this::entityToResponseDTO).collect(Collectors.toList());
    }

    // Por id
    public Optional<ProductoResponseDTO> obtenerPorId(Long id) {
        return repo.findById(id).map(this::entityToResponseDTO);
    }

    // Por categoria
    public List<ProductoResponseDTO> obtenerPorCategoria(Categoria categoria) {
        return repo.findByCategoria(categoria).stream().map(this::entityToResponseDTO).collect(Collectors.toList());
    }

    // Actualizar completo
    public ProductoResponseDTO actualizarProducto(Long id, ProductoDTO dto) {
        Producto existing = repo.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
        existing.setNombre(dto.getNombre());
        existing.setDescripcion(dto.getDescripcion());
        existing.setPrecio(dto.getPrecio());
        existing.setStock(dto.getStock());
        existing.setCategoria(dto.getCategoria());
        Producto updated = repo.save(existing);
        return entityToResponseDTO(updated);
    }

    // Actualizar solo stock
    public ProductoResponseDTO actualizarStock(Long id, Integer nuevoStock) {
        Producto existing = repo.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
        existing.setStock(nuevoStock);
        Producto updated = repo.save(existing);
        return entityToResponseDTO(updated);
    }

    // Eliminar
    public void eliminarProducto(Long id) {
        Producto existing = repo.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));
        repo.delete(existing);
    }

    // Helpers mapeo
    public Producto dtoToEntity(ProductoDTO dto) {
        return Producto.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoria(dto.getCategoria())
                .build();
    }

    public ProductoResponseDTO entityToResponseDTO(Producto p) {
        return new ProductoResponseDTO(p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), p.getStock(), p.getCategoria());
    }
}
