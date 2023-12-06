package com.example.casotarifa.service;

import com.example.casotarifa.dto.CrearFacturaDto;
import com.example.casotarifa.dto.RespuetaFacturaDto;

public interface CalcularTarifaService {
    RespuetaFacturaDto calcularTarifa(CrearFacturaDto crearFacturaDto);
}
