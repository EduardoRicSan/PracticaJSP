/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import practica.dao.VentaDAOImp;
import practica.dao.VentasDAO;
import practica.model.Venta;

/**
 *
 * @author Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
 */
@WebServlet(name = "VentaController", urlPatterns = {"/VentaController"})
public class VentaController extends HttpServlet {
    
     private static final String LISTAR_VENTAS ="/listarVentas.jsp";
    private static final String AGREGAR_O_CAMBIAR="/ventas.jsp";
    private VentasDAO dao;
    
     public VentaController() {
        dao = new VentaDAOImp();
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String forward = "";
       String action = request.getParameter("action");
       if(action.equalsIgnoreCase("borrar")){
           forward = LISTAR_VENTAS;
           int NumeroVenta = Integer.parseInt(request.getParameter("NumeroVenta"));
        dao.borrarVenta(NumeroVenta);
        request.setAttribute("ventas", dao.desplegarVentas());
       }else if(action.equalsIgnoreCase("cambiar")){
           forward = AGREGAR_O_CAMBIAR;
           int NumeroVenta = Integer.parseInt(request.getParameter("NumeroVenta"));
           Venta venta = dao.elegirVenta(NumeroVenta);
           request.setAttribute("venta", venta);
           
       }else if (action.equalsIgnoreCase("agregar")){
           forward = AGREGAR_O_CAMBIAR;
       }else {
           forward = LISTAR_VENTAS;
           request.setAttribute("ventas", dao.desplegarVentas());
       }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         Venta venta = new Venta();
        String NumeroVenta = request.getParameter("numeroVenta");
        venta.setFecha(request.getParameter("fechaVenta"));
        venta.setTotal(Integer.parseInt(request.getParameter("totalVenta")));
        venta.setCodigo(Integer.parseInt(request.getParameter("codigoEmpleado")));
        venta.setNumCliente(Integer.parseInt(request.getParameter("numeroCliente")));
        if (NumeroVenta == null || NumeroVenta.isEmpty()){
            dao.agregarVenta(venta);
        }else {
            venta.setNumeroVenta(Integer.parseInt(NumeroVenta)); //darle un id al usuario
            dao.cambiarVenta(venta);
        }
        RequestDispatcher view = request.getRequestDispatcher(LISTAR_VENTAS);
        request.setAttribute("usuario", dao.desplegarVentas());
        view.forward(request, response);
                
        
       
    }
    }
   
  

