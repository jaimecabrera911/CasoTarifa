package com.example.casotarifa.service;

import com.example.casotarifa.dto.CrearFacturaDto;
import com.example.casotarifa.dto.RespuetaFacturaDto;
import com.example.casotarifa.model.Factura;
import com.example.casotarifa.model.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CalcularTarifaServiceImpl implements CalcularTarifaService {

    private final ProductoService productoService;

    @Override
    public RespuetaFacturaDto calcularTarifa(CrearFacturaDto crearFacturaDto) {
        Factura factura = Factura.builder()
                .cantidad(crearFacturaDto.getCantidad())
                .build();
        factura.setPorcentajeImpuesto(0.19);
        Producto producto = productoService.buscarProductoPorCodigo(crearFacturaDto.getCodigoProducto()).orElseThrow();
        int cantidad = factura.getCantidad();
        double subtotal = producto.getPrecio() * cantidad;
        double descuento = subtotal * producto.getDescuento();
        double baseImpuesto = subtotal - descuento;
        double impuesto = baseImpuesto * factura.getPorcentajeImpuesto();
        double total = baseImpuesto + impuesto;
        factura.setProducto(producto);
        factura.setSubtotal(subtotal);
        factura.setDescuento(descuento);
        factura.setBaseImpuesto(baseImpuesto);
        factura.setImpuesto(impuesto);
        factura.setTotal(total);
        return RespuetaFacturaDto.builder()
                .codigoProducto(factura.getProducto().getCodigo())
                .nombreProducto(factura.getProducto().getNombre())
                .precioUnitario(factura.getProducto().getPrecio())
                .cantidad(factura.getCantidad())
                .subtotal(factura.getSubtotal())
                .descuento(factura.getDescuento())
                .baseImpuesto(factura.getBaseImpuesto())
                .porcentajeImpuesto(factura.getPorcentajeImpuesto())
                .impuesto(factura.getImpuesto())
                .total(factura.getTotal())
                .build();
    }

}
