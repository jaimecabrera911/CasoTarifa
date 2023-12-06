package com.example.casotarifa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RespuetaFacturaDto {
    private String codigoProducto;
    private String nombreProducto;
    private double precioUnitario;
    private int cantidad;
    private double subtotal;
    private double descuento;
    private double baseImpuesto;
    private double porcentajeImpuesto;
    private double impuesto;
    private double total;
}
