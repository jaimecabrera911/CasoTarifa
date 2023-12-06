package com.example.casotarifa.controller;

import com.example.casotarifa.dto.CrearFacturaDto;
import com.example.casotarifa.dto.RespuetaFacturaDto;
import com.example.casotarifa.service.CalcularTarifaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calcular-tarifa")
@RequiredArgsConstructor
public class TarifaController {

    private final CalcularTarifaService calcularTarifaService;

    @PostMapping
    public RespuetaFacturaDto calcarTarifa(@RequestBody CrearFacturaDto crearFacturaDto) {
        return calcularTarifaService.calcularTarifa(crearFacturaDto);
    }

}
