# language: es

Característica: : Calcular Tarifa
  Escenario: Aplicar Un Descuento
    Dado que un cliente compra un producto con el código "VG007"
    Cuando se le factura por el producto
    Entonces el total del precio debería ser de $41,6381 con un descuento de $34,99