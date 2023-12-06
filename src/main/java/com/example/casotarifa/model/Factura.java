package com.example.casotarifa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Factura {
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private double descuento;
    private double baseImpuesto;
    private double porcentajeImpuesto;
    private double impuesto;
    private double total;
}
