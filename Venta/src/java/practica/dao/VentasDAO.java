/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.dao;

import java.util.List;
import practica.model.Venta;
/**
 *
 * @author Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
 */
public interface VentasDAO {
    void agregarVenta(Venta venta);
    void borrarVenta (int venta);
    void cambiarVenta (Venta venta);
    List<Venta> desplegarVentas();
    Venta elegirVenta(int venta);
    
}
