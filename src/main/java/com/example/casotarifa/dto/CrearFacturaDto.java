package com.example.casotarifa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CrearFacturaDto {
    private String codigoProducto;
    private int cantidad;
}
