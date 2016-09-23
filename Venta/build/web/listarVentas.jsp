<%-- 
    Document   : listarVentas
    Created on : 22-sep-2016, 13:45:21
    Author     : Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Ventas</title>
    </head>
   <body>
        <table>
            <thead>
                <tr>
                    <th>Numero venta</th>
                    <th>Fecha Venta</th>
                    <th>Total Venta</th>
                    <th>Codigo Empleado</th>
                    <th>Numero Cliente</th>
                </tr>
            </thead>
            <tbody>
               <c:forEach var="venta" items="${ventas}">
                   <tr>
                       <td>${venta.NumeroVenta}</td> <!--utilizando el getter del id-->
                       <td>${venta.fecha}</td>
                       <td>${venta.total}</td>
                       <td>${venta.codigo}</td>
                       <td>${venta.numClente}</td>
                       <td><a href="VentaController?action=cambiar&NumeroVenta=${venta.NumeroVenta}"></a>Cambiar</td>
                       <td><a href="VentaController?action=borrar=${venta.NumeroVenta}"></a>Borrar</td>
                   </tr>
               </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="VentaController?action=agregar">Nueva Venta</a>  
        </p>
    </body>
</html>
