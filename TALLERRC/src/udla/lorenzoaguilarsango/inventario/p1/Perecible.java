package udla.lorenzoaguilarsango.inventario.p1;

import java.time.LocalDate;
import java.util.Scanner;

public class Perecible extends Producto {
    private int vidaUtilDias;
    private String tipoAlmacenamiento;
    public Perecible(String nombre, int cantidad, double precio,
                     LocalDate fechaReabastecimiento,
                     int vidaUtilDias ,
                     String tipoAlmacenamiento) {

        super(nombre, precio, cantidad, fechaReabastecimiento);
        this.vidaUtilDias = vidaUtilDias;
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    public String getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    public void setTipoAlmacenamiento(String tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    public int getVidaUtilDias() {
        return vidaUtilDias;
    }

    public void setVidaUtilDias(int vidaUtilDias) {
        this.vidaUtilDias = vidaUtilDias;
    }
}
