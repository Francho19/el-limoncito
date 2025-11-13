Lavanderia "EL LIMONCITO"
Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe registrar nombre y teléfono del cliente y crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5), y Chaqueta ($9.000, o $7.500 c/u desde 5). El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el total resultante supera $60.000, aplicar descuento del 5% (una sola vez). No se permiten cantidades ≤ 0 ni totales negativos. Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

Analisis:

-Ra1: Diseña un programa aplicando estructuras de control, validaciones, funciones y clases que representen los elementos del sistema de manera eficiente y organizada.
Que nos piden:
-Calcular subtotales por ítem según cantidad.  
-Sumar subtotales para obtener el el total bruto.
-Si el cliente elige servicio s, agregar recargo del 10%.  
-Si el total final supera $60.000 , aplicar descuento del 5% (una sola vez).  
-No permitir cantidades menores o iguales a 0 ni totales negativos.  
-Al confirmar la orden, esta no puede editarse.  
-Generar un resumen con:
-Datos del cliente  
-Detalle con precios aplicados  
-Total bruto  
-Recargo  
-Descuento  
-Total final
Crear unas clases que van en el domain:
1.Cliente– guarda datos del cliente (nombre, teléfono).  
2.Item – representa una prenda y calcula su subtotal.  
3.Orden – gestiona los ítems, calcula totales, recargos y descuentos.  
4.Catalogo – contiene los productos y precios disponibles.  
5.Main– controla el flujo principal del programa.

-Ra2: Servicios:
Encargada de: Registrar nombre, teléfono y tipo de servicio (normal o exprés).
Agregar prendas con su cantidad.
Calcular subtotal, recargo, descuento y total final.
Mostrar un resumen claro con los valores aplicados.
Métodos principales:
agregarPrenda(String prenda, int cantidad)
calcularTotal()
mostrarCliente()
