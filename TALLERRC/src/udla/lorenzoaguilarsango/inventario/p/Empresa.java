package udla.lorenzoaguilarsango.inventario.p;

import udla.lorenzoaguilarsango.inventario.p1.Inventario;
import udla.lorenzoaguilarsango.inventario.p1.NoPerecible;
import udla.lorenzoaguilarsango.inventario.p1.Perecible;
import udla.lorenzoaguilarsango.inventario.p1.Producto;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        boolean seguir=true;
        while (seguir){
            int opcion = Menu(scanner);
            switch (opcion) {
                case 1:
                    inventario.modificacionPresupuesto(scanner);
                    break;
                case 2:
                    agregarProducto(scanner, inventario);
                    break;
                case 3:
                    inventario.mostrarProductos();
                    break;
                case 4:
                    editarProducto(scanner, inventario);
                    break;
                case 5:
                    reabastecerProducto(scanner, inventario);
                    break;
                case 6:
                    inventario.eliminarProducto(scanner);
                    break;
                case 7:
                    inventario.despacharProducto(scanner);
                    break;
                default:
                    System.out.println("Saliendo :)");
                    seguir = false;
                    break;
            }
        }
    }

    // METODOS INTERFAZ
    public static int Menu(Scanner sc) {
        System.out.println("1) PRESUPUESTO");
        System.out.println("2) AGREGAR PRODUCTO");
        System.out.println("3) VER PRODUCTOS");
        System.out.println("4) EDITAR PRODCUTO");
        System.out.println("5) REABASTECER PRODUCTO");
        System.out.println("6) ELIMINAR PRODUCTO");
        System.out.println("7) DESPACHAR PRODUCTO");
        System.out.println("8) salir");
        System.out.println(">>");
        int opc = sc.nextInt();
        return opc;
    }

    public static void agregarProducto(Scanner sc, Inventario inv){
        sc.nextLine(); // limpiar buffer
        System.out.println("Ingrese nombre del producto:");
        String nombre = sc.nextLine();
        System.out.println("Ingrese cantidad:");
        int cantidad = sc.nextInt();
        System.out.println("Ingrese el precio");
        double precio = sc.nextDouble();
        double precio_final = precio*cantidad;
        if (precio_final>inv.getPresupuesto()){
            System.out.println("No puede comprar esa cantidad su presupuesto es de "+ inv.getPresupuesto());
            System.out.println("Costo total es de "+ precio_final);
            System.out.println("");
            return;
        }
        System.out.println("Ingrese día del reabastecimiento:");
        int dia = sc.nextInt();
        System.out.println("Ingrese el mes:");
        int mes = sc.nextInt();
        System.out.println("Ingrese el anio:");
        int anio = sc.nextInt();
        LocalDate fechaReabastecimiento  = LocalDate.of(anio, mes, dia);
        System.out.println("El producto es perecible? s para si n para no");
        sc.nextLine();
        String eleccion = sc.nextLine();
        switch (eleccion){
            case "s":
                System.out.println("Ingrese la vida util del alimento en dias");
                int diaCaducidad = sc.nextInt();
                sc.nextLine();
                System.out.println("Ingrese tipo de almacenamiento");
                String tipoAlmacenamiento;
                tipoAlmacenamiento = sc.nextLine();
                Perecible p = new Perecible(nombre, cantidad, precio, fechaReabastecimiento, diaCaducidad, tipoAlmacenamiento);
                inv.agregarProducto(p);
                break;
            case "n":
                System.out.println("Ingrese tipo de conservación (Enlatado, Seco, Empaquetado, etc):");
                String tipoConservacion = sc.nextLine();

                System.out.println("Ingrese contenido neto (en gramos o ml):");
                double contenidoNeto = sc.nextDouble();
                sc.nextLine();

                System.out.println("Ingrese marca del producto:");
                String marca = sc.nextLine();

                NoPerecible np = new NoPerecible(nombre, cantidad, precio, fechaReabastecimiento, tipoConservacion, contenidoNeto, marca);
                inv.agregarProducto(np);
                System.out.println("Producto NO perecible agregado correctamente.");
                break;
            default:
                System.out.println("Error");
                break;
        }
        inv.setPresupuesto(inv.getPresupuesto()-precio_final);
    }
    public static void editarProducto(Scanner sc, Inventario inv){
        sc.nextLine();
        System.out.println("Ingrese el nombre del producto que desea editar");
        String buscar = sc.nextLine();
        inv.editarProducto(buscar, sc);
    }
    public static void reabastecerProducto(Scanner sc, Inventario inv){
        sc.nextLine();
        System.out.println("Ingrese el nombre del producto que desea reabastecer");
        String buscar = sc.nextLine();
        inv.reabastecerProductos( sc, buscar);
    }

}