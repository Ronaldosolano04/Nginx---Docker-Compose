package modelo.Visualizacion;

import controlador.GestorNomina;
import java.util.Scanner;

public class Menu {
    private final GestorNomina gestorNomina;
    private final Scanner scanner;

    public Menu(GestorNomina gestorNomina) {
        this.gestorNomina = gestorNomina;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        boolean continuar = true;

        while(continuar) {
            System.out.println("\n===SISTEMA DE NOMINA===");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Procesar pagos");
            System.out.println("3. Generar reporte");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch(opcion) {
                case 1:
                    gestorNomina.agregarNuevoEmpleado();
                    break;
                case 2:
                    gestorNomina.procesarPagos();
                    break;
                case 3:
                    gestorNomina.generarReporte();
                    break;
                case 4:
                    actualizarEmpleado();
                    break;
                case 5:
                    eliminarEmpleado();
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion NO VALIDA");
            }
        }
    }

    private void actualizarEmpleado() {
        System.out.println("\n=== Actualizar Empleado ===");
        System.out.println("Ingrese NSS del empleado: ");
        String numeroSeguroSocial = scanner.next();

        System.out.println("Ingrese nuevo primer nombre: ");
        String nuevoPrimerNombre = scanner.next();

        System.out.println("Ingrese nuevo apellido paterno: ");
        String nuevoApellidoPaterno = scanner.next();

        gestorNomina.actualizarEmpleado(numeroSeguroSocial, nuevoPrimerNombre, nuevoApellidoPaterno);
    }

    private void eliminarEmpleado() {
        System.out.println("\n=== Eliminar Empleado ===");
        System.out.println("Ingrese NSS del empleado: ");
        String numeroSeguroSocial = scanner.next();

        gestorNomina.eliminarEmpleado(numeroSeguroSocial);
    }
}
