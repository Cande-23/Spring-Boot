package com.utn.productos.dto;

import com.utn.productos.model.Categoria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

@Schema(description = "DTO para crear o actualizar un producto")
public class ProductoDTO {

    @NotBlank
    @Size(min = 3, max = 100)
    @Schema(description = "Nombre del producto", example = "Auriculares Bluetooth")
    private String nombre;

    @Size(max = 500)
    @Schema(description = "Descripción", example = "Auriculares con cancelación de ruido")
    private String descripcion;

    @NotNull
    @DecimalMin(value = "0.01")
    @Schema(description = "Precio", example = "99.99")
    private Double precio;

    @NotNull
    @Min(0)
    @Schema(description = "Stock disponible", example = "10")
    private Integer stock;

    @NotNull
    @Schema(description = "Categoría del producto", example = "ELECTRONICA")
    private Categoria categoria;

    // getters y setters (o usar lombok)
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}
