package com.utn.productos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Schema(description = "DTO para actualizar stock")
public class ActualizarStockDTO {

    @NotNull
    @Min(0)
    @Schema(description = "Nuevo stock", example = "5")
    private Integer stock;

    public ActualizarStockDTO() {}

    public ActualizarStockDTO(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
