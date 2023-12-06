# language: es

Característica: Calcular Tarifa

  Escenario: Aplicar Un Descuento
    Dado que un cliente compra un producto con el código <CodigoProducto>
    Cuando se le factura por el producto
    Entonces el total del precio debería ser de $41,6381 con un descuento de <DescuentoEsperado>

    Ejemplos:
      | CodigoProducto | PrecioUnitario | Cantidad | DescuentoEsperado |
      | VG007          | $10,00         | 5        | $34,99            |
      | VG007          | $15,00         | 3        | $20,00            |
      | VG007          | $8,50          | 10       | $50,00            |
