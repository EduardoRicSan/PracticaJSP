/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.model;

/**
 *
 * @author Jesús Eduardo Rico Sandoval lalo19jers.azul@gmail.com
 */
public class Venta {
    
     private int NumeroVenta;
     private String fecha;
     private int total;
     private int codigo;
     private int numCliente;

    public Venta(int NumeroVenta, String fecha, int total, int codigo, int numCliente) {
        this.NumeroVenta = NumeroVenta;
        this.fecha = fecha;
        this.total = total;
        this.codigo = codigo;
        this.numCliente = numCliente;
    }

  

    public Venta() {
       this(0,"",0,0,0);
    }

    public int getNumeroVenta() {
        return NumeroVenta;
    }

    public void setNumeroVenta(int NumeroVenta) {
        this.NumeroVenta = NumeroVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "NumeroVenta=" + NumeroVenta + ", fecha=" + fecha + ", total=" + total + ", codigo=" + codigo + ", numCliente=" + numCliente + '}';
    }

    
    
    
     
    
    
}
