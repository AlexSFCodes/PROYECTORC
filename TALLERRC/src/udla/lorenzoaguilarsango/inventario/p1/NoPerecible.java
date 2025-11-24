package udla.lorenzoaguilarsango.inventario.p1;

import java.time.LocalDate;

public class NoPerecible extends Producto {

    private String tipoConservacion;
    private double contenidoNeto;
    private String marca;

    public NoPerecible(String nombre, int cantidad, double precio, LocalDate fechaReabastecimiento,
                       String tipoConservacion, double contenidoNeto, String marca) {
        super(nombre, precio, cantidad, fechaReabastecimiento);
        this.tipoConservacion = tipoConservacion;
        this.contenidoNeto = contenidoNeto;
        this.marca = marca;
    }

    // Getters y setters (opcional)
    public String getTipoConservacion() {
        return tipoConservacion;
    }

    public double getContenidoNeto() {
        return contenidoNeto;
    }

    public String getMarca() {
        return marca;
    }
}

