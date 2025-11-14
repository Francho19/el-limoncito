Lavanderia "EL LIMONCITO"
Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe registrar nombre y teléfono del cliente y crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5), y Chaqueta ($9.000, o $7.500 c/u desde 5). El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el total resultante supera $60.000, aplicar descuento del 5% (una sola vez). No se permiten cantidades ≤ 0 ni totales negativos. Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

Analisis:

 Descripción del Proyecto

Este proyecto implementa un sistema simple para la gestión de órdenes de compra.
Permite:

Registrar clientes

Crear órdenes asociadas a un cliente

Crear ítems basados en un catálogo de precios

Agregar ítems a una orden

Calcular subtotales y totales

Confirmar la orden y evitar modificaciones posteriores


 Estructura del Proyecto

Archivo	Descripción

Catalogo.java	Contiene los precios base para distintos tipos de productos y calcula subtotales.

Cliente.java	Representa al cliente con su nombre e información de contacto.

Item.java	Representa un producto solicitado con tipo y cantidad. Calcula su subtotal usando el catálogo.

Orden.java	Maneja la lista de ítems de una orden, el cálculo del total y la confirmación.

App.java	Ejecuta un ejemplo de uso del sistema.

 Requerimientos de Aceptación

1 Catálogo

Debe proporcionar precios válidos para todos los tipos definidos.

Si se solicita un tipo inválido, debe lanzar una excepción.

Debe calcular correctamente subtotales:
subtotal = precio × cantidad

2.Cliente

Debe permitir registrar nombre y contacto válidos.

Debe mostrar su información en un formato legible al convertirlo a texto.

3.Ítem

Debe aceptar únicamente cantidades mayores a cero.

Debe calcular correctamente el subtotal usando el catálogo.

Debe almacenar correctamente el tipo y la cantidad.

4.Orden

Una orden debe crearse asociada a un cliente válido.

Debe permitir agregar ítems mientras no esté confirmada.

No debe permitir agregar ítems una vez confirmada.

No debe permitir confirmarse si está vacía.

Debe calcular el total sumando los subtotales de cada ítem.

Al confirmarse, debe cambiar su estado a confirmada.

5.App (flujo general)

Debe demostrar la creación de un cliente.

Crear una orden.

Agregar varios ítems válidos.

Mostrar el subtotal de cada ítem y el total final.

Confirmar la orden correctamente.


