package udla.lorenzoaguilarsango.inventario.p1;

import java.time.LocalDate;
import java.util.*;

public class Inventario {
    /**Atributos */
    private List<Producto> producto = new ArrayList<>();
    private double presupuesto=0;
    /**Metodos de java */
    public double getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    public List<Producto> getProducto() {
        return producto;
    }
    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

    public void modificacionPresupuesto(Scanner sc){
        System.out.println("Presupuesto actual: "+ presupuesto);
        System.out.println("Desea aumentar su presupuesto? s para si n para no");
        sc.nextLine();
        String eleccion = sc.nextLine();
        switch (eleccion) {
            case "s":
                System.out.println("Ingrese el presupuesto >");
                presupuesto = sc.nextDouble()+ presupuesto;
                break;
            case "n":
                System.out.println("Regresando al menu..");
                break;
            default:
                System.out.println("Opcion invalida \nRegresando al menu...");
                break;
        }
    }
    public void agregarProducto(Producto p) {
        producto.add(p);
        System.out.println("Producto agregado correctamente.");
    }

    // opcional: mostrar productos
    public void mostrarProductos() {
        for (Producto p : producto) {
            System.out.println("----------------------------");
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Cantidad: " + p.getCantidad());
            System.out.println("Precio unitario: " + p.getPrecio());
            System.out.println("REABASTECIMIENTO "+p.getFecha());
            // Si es perecible
            if (p instanceof Perecible) {
                Perecible per = (Perecible) p;
                System.out.println("Tipo: Perecible");
                System.out.println("Dias utiles " + per.getVidaUtilDias());
                System.out.println("Tipo de almacenamiento: " + per.getTipoAlmacenamiento());
            }

            // Si es no perecible
            else if (p instanceof NoPerecible) {
                NoPerecible np = (NoPerecible) p;
                System.out.println("Tipo: No perecible");
                System.out.println("Conservación: " + np.getTipoConservacion());
                System.out.println("Contenido Neto: " + np.getContenidoNeto());
                System.out.println("Marca: " + np.getMarca());
            }

            System.out.println("----------------------------");
        }
    }

    public void editarProducto(String nombreBuscado, Scanner sc) {
        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).getNombre().equals(nombreBuscado)) {
                System.out.println("Ingrese nuevo nombre:");
                String nuevoNombre = sc.nextLine();
                producto.get(i).setNombre(nuevoNombre);
                System.out.println(" Producto actualizado correctamente.");
                return;
            }
        }
        System.out.println(" No se encontró un producto con ese nombre.");
    }

    public void reabastecerProductos(Scanner sc, String nombrebuscado) {
        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).getNombre().equalsIgnoreCase(nombrebuscado)) {
                System.out.println("Ingrese la cantidad a pedir:");
                int nuevaCantidad = sc.nextInt();
                double costoTotal = producto.get(i).getPrecio() * nuevaCantidad;
                if (presupuesto < costoTotal) {
                    System.out.println("No se puede reabastecer, excede el presupuesto.");
                    System.out.println("Presupuesto: " + presupuesto);
                    System.out.println("Costo total: " + costoTotal);
                    return;
                }
                producto.get(i).setCantidad(producto.get(i).getCantidad() + nuevaCantidad);
                presupuesto -= costoTotal;
                System.out.println("Producto reabastecido exitosamente.");
                System.out.println("Nuevo stock: " + producto.get(i).getCantidad());
                System.out.println("Presupuesto restante: " + presupuesto);
                return;
            }
        }
        System.out.println("Producto no encontrado en el inventario.");
    }
    public void eliminarProducto(Scanner sc) {
        sc.nextLine();
        System.out.println("Ingrese el nombre del producto a eliminar:");
        String buscarnombre = sc.nextLine();
        int indice = -1;
        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).getNombre().equalsIgnoreCase(buscarnombre)) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            System.out.println("Producto no encontrado.");
        } else {
            producto.remove(indice);
            System.out.println("Producto eliminado correctamente.");
        }
    }
    public void despacharProducto(Scanner sc) {
        sc.nextLine();
        System.out.println("Ingrese el nombre del producto a despachar:");
        String buscarnombre = sc.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < producto.size(); i++) {
            if (producto.get(i).getNombre().equalsIgnoreCase(buscarnombre)) {
                encontrado = true;
                Producto p = producto.get(i);
                System.out.println("Usted tiene " + p.getCantidad() + " de " + p.getNombre());
                System.out.println("¿Cuánto desea despachar?");
                int despachar = sc.nextInt();
                if (despachar <= 0) {
                    System.out.println("Valor inválido. Debe despachar al menos 1.");
                    return;
                }
                if (despachar > p.getCantidad()) {
                    System.out.println("No se puede despachar más de lo que hay en stock.");
                    System.out.println("Disponible: " + p.getCantidad());
                    return;
                }
                p.setCantidad(p.getCantidad() - despachar);
                System.out.println("Despacho realizado. Nuevo stock: " + p.getCantidad());
                return;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }


}
