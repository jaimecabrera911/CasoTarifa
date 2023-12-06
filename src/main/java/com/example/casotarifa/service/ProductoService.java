package com.example.casotarifa.service;

import com.example.casotarifa.model.Producto;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarProductos() throws IOException;

    Optional<Producto> buscarProductoPorCodigo(String codigo);
}
