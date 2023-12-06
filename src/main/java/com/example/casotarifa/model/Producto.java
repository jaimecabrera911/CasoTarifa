package com.example.casotarifa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private double descuento;
}
