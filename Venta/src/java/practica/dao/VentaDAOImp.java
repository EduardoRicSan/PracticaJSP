/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import practica.model.Venta;
import practica.util.UtilDB;

/**
 *
 * @author Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
 */
public class VentaDAOImp implements VentasDAO{
    private Connection connection;
    public VentaDAOImp(){
        connection = UtilDB.getConnection();
        
    }

    @Override
    public void agregarVenta(Venta venta) {
         try{
           String query = "INSERT INTO ventas (NumeroVenta,FechaVenta, TotalVenta, CodigoEmpleado, NumeroCliente)"
                   + " values (?,?,?,?,?)";
           PreparedStatement ps = connection.prepareStatement(query);
           ps.setInt(1, venta.getNumeroVenta());
            ps.setString(2, venta.getFecha());
             ps.setInt(3, venta.getTotal());
              ps.setInt(4, venta.getCodigo());
              ps.setInt(5,venta.getNumCliente());
              ps.executeUpdate();
              ps.close();
       } catch(SQLException e){
           e.printStackTrace();
       }  
        
    }

    @Override
    public void borrarVenta(int NumeroVenta) {
         try{
           String query = "DELETE FROM ventas WHERE "
                   + "NumeroVenta = ?";
           PreparedStatement ps =connection.prepareStatement(query);
           ps.setInt(1, NumeroVenta);
           ps.executeUpdate();
       }catch (SQLException e){
           e.printStackTrace();
       }
    }

    @Override
    public void cambiarVenta(Venta venta) {
        try{
           String query = "UPDATE ventas SET NumeroVenta=?"
                   + ", FechaVenta=?"
                   + ", TotalVenta=?"
                   + ", CodigoEmpleado=?"
                   + ", NumeroCliente=?"
                   + "WHERE NumeroVenta = ?";
         
           PreparedStatement ps = connection.prepareStatement(query);
           ps.setInt(1, venta.getNumeroVenta());
            ps.setString(2, venta.getFecha());
             ps.setInt(3, venta.getTotal());
              ps.setInt(4, venta.getCodigo());
              ps.setInt(5, venta.getNumCliente());
              ps.executeUpdate();
              ps.close();
       } catch(SQLException e){
           e.printStackTrace();
       }  
    }

    @Override
    public List<Venta>desplegarVentas() {
         List<Venta> ventas = new ArrayList<Venta>();
        try{
        Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ventas");
            while(rs.next()){ 
                
                Venta venta = new Venta(
                rs.getInt("NumeroVenta"),
                rs.getString("fechaVenta"),
                rs.getInt("totalVenta"),
                rs.getInt("codigoEmpleado"),
                rs.getInt("numeroCliente"));
            }
        
        rs.close();
          statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }    
        return ventas;
    }

    @Override
    public Venta elegirVenta(int NumeroVenta) {
         Venta venta = null;
       try{
           String query = "SELECT * FROM ventas WHERE NumeroVenta =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, NumeroVenta);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){ 
                venta = new Venta( 
                rs.getInt("NumeroVenta"),
                rs.getString("FechaVenta"),
                rs.getInt("TotalVenta"),
                rs.getInt("CodigoEmpleado"),
                rs.getInt("NumeroCliente"));
            }
                         
          rs.close();
          statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }    
        
        
        return venta;
    }
    
    
}
