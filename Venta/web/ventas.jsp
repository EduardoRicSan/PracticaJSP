<%-- 
    Document   : ventas
    Created on : 22-sep-2016, 13:36:52
    Author     : Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar Ventas</title>
    </head>
    <body>
        <form action="VentaController" method ="post">
            <fieldset>
                <div>
                <label>Numero de venta</label>
                <input type ="number" name="numeroVenta" value = "${venta.NumeroVenta}"
                       readonly="readonly"/>
                </div>
                       <div>
                <label>Fecha de la venta</label>
                <input type ="text" name="fechaVenta" value = "${venta.fecha}"
                       placeholder="Introduce la fecha"/>
                       </div>
                       <div>
                <label>Total de la venta:</label>
                <input type ="number" name="totalVenta" value = "${venta.total}"
                       placeholder="Total a pagar"/>
                       </div>
                       <div>
                <label>Codigo del empleado::</label>
                <input type ="number" name="codigoEmpleado" value = "${venta.codigo}"
                       placeholder="Codigo del empleado"/>
                       </div>
                       <div>
                <label>Numero de Cliente:</label>
                <input type ="number" name="numeroCliente" value = "${venta.numClente}"
                       placeholder="Edad del usuario"/>
                       </div>
                       <div>
                <input type="submit" value="Guardar venta"/>
                       </div>
            </fieldset>
            
        </form>
    </body>
</html>
