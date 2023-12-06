package com.example.casotarifa.service;

import com.example.casotarifa.model.Producto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {


    private final ObjectMapper mapper;
    private final ResourceLoader resourceLoader;

    @Override
    public List<Producto> listarProductos() {
        Resource resourceUrl = resourceLoader.getResource("classpath:data/products.json");
        List<Producto> productos = null;
        try {
            productos = mapper.readValue(
                    resourceUrl.getInputStream(),
                    new TypeReference<List<Producto>>() {
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productos;
    }

    @Override
    public Optional<Producto> buscarProductoPorCodigo(String codigo) {
        return listarProductos().stream().filter(producto -> producto.getCodigo().equals(codigo)).findFirst();
    }

}
