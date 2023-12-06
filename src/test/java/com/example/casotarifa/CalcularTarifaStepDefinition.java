package com.example.casotarifa;

import com.example.casotarifa.dto.CrearFacturaDto;
import com.example.casotarifa.dto.RespuetaFacturaDto;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalcularTarifaStepDefinition {
    @LocalServerPort
    private String port;

    private TestRestTemplate restTemplate = new TestRestTemplate();

    private String apiUrl;
    private RespuetaFacturaDto response;
    private String codigoProducto;

    @Dado("que un cliente compra un producto con el código {string}")
    public void que_un_cliente_compra_un_producto_con_el_código(String string) {
        apiUrl = "http://localhost:8080/calcular-tarifa";
        codigoProducto = string;
    }

    @Cuando("se le factura por el producto")
    public void se_le_factura_por_el_producto() {
        response =
                restTemplate.postForObject(
                        apiUrl,
                        CrearFacturaDto.builder().cantidad(2).codigoProducto(codigoProducto).build(),
                        RespuetaFacturaDto.class
                );
    }

    @Entonces("el total del precio debería ser de ${double} con un descuento de ${double}")
    public void el_total_del_precio_debería_ser_de_$_con_un_descuento_de_$(Double double1, Double double2) {
        Assertions.assertEquals(double1, response.getTotal());
        Assertions.assertEquals(double2, response.getDescuento());
    }
}
