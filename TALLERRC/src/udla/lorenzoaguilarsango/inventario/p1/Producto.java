package udla.lorenzoaguilarsango.inventario.p1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Producto {
    /** Atributos de la clase */
    private String nombre;
    private double precio;
    private int cantidad;
    //INGRESO FECHA DE REABASTECIMIENTO FORMATO Anio/mes/dia
    private LocalDate fecha;
    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public Producto(String nombre, double precio, int cantidad, LocalDate fecha) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    /**Constructor */

    private String tiempoDeEntrega;
    /** Metodos get y set*/
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public double getPrecio() {return precio;}
    public void setPrecio(double precio) {this.precio = precio;}
    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    public String getTiempoDeEntrega() {return tiempoDeEntrega;}
    public void setTiempoDeEntrega(String tiempoDeEntrega) {this.tiempoDeEntrega = tiempoDeEntrega;}

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**  */
}
