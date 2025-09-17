package modelo.Controlador;

import modelo.Empleado;
import modelo.EmpleadoAsalariado;
import modelo.EmpleadoPorComision;
import modelo.EmpleadoAsalariadoPorComision;
import modelo.EmpleadoPorHoras;
import utilidades.Validador;
import vista.ReporteNomina;

import java.util.Scanner;

public class GestorNomina {
    private Scanner scanner;
    private ReporteNomina reporteNomina;

    public GestorNomina() {
        this.scanner = new Scanner(System.in);
        this.reporteNomina = new ReporteNomina();
    }

    public void agregarNuevoEmpleado() {
        System.out.println("\nSeleccione el tipo de empleado:");
        System.out.println("1. Asalariado");
        System.out.println("2. Por Horas");
        System.out.println("3. Por Comision");
        System.out.println("4. Asalariado Por Comision");

        int opcion = scanner.nextInt();
        String primerNombre, apellidoPaterno, numeroSeguroSocial;

        System.out.println("Ingresa primer nombre: ");
        primerNombre = scanner.next();
        System.out.println("Ingresa apellido paterno: ");
        apellidoPaterno = scanner.next();
        System.out.println("Ingresa numero de seguro social: ");
        numeroSeguroSocial = Validador.validarNumeroSeguroSocial(scanner.next());

        switch(opcion) {
            case 1:
                System.out.println("Ingrese salario semanal: ");
                double salarioSemanal = Validador.validarSalario(scanner.nextDouble());
                new EmpleadoAsalariado(primerNombre, apellidoPaterno, numeroSeguroSocial, salarioSemanal);
                break;

            case 2:
                System.out.println("Ingrese sueldo por hora: ");
                double sueldoPorHora = Validador.validarSalario(scanner.nextDouble());
                System.out.println("Ingrese horas trabajadas: ");
                double horasTrabajadas = Validador.validarHoras(scanner.nextDouble());
                new EmpleadoPorHoras(primerNombre, apellidoPaterno, numeroSeguroSocial, sueldoPorHora, horasTrabajadas);
                break;

            case 3:
                System.out.println("Ingrese ventas brutas: ");
                double ventasBrutas = Validador.validarVentas(scanner.nextDouble());
                System.out.println("Ingrese tarifa de comision: ");
                double tarifaComision = Validador.validarTarifa(scanner.nextDouble());
                new EmpleadoPorComision(primerNombre, apellidoPaterno, numeroSeguroSocial, ventasBrutas, tarifaComision);
                break;

            case 4:
                System.out.println("Ingrese salario base: ");
                double salarioBase = Validador.validarSalario(scanner.nextDouble());
                System.out.println("Ingrese ventas brutas: ");
                ventasBrutas = Validador.validarVentas(scanner.nextDouble());
                System.out.println("Ingrese tarifa de comision: ");
                tarifaComision = Validador.validarTarifa(scanner.nextDouble());
                new EmpleadoAsalariadoPorComision(primerNombre, apellidoPaterno, numeroSeguroSocial, 
                                                 salarioBase, ventasBrutas, tarifaComision);
                break;
        }
    }

    public void procesarPagos() {
        for(Empleado emp : Empleado.getListaEmpleados()) {
            double pago = emp.calcularPago();
            System.out.printf("\nPago para %s %s: $%.2f%n", emp.getPrimerNombre(), emp.getApellidoPaterno(), pago);
        }
    }

    public void generarReporte() {
        reporteNomina.generar();
    }

    public void actualizarEmpleado(String numeroSeguroSocial, String nuevoPrimerNombre, String nuevoApellidoPaterno) {
        Empleado empleado = Empleado.encontrarEmpleado(numeroSeguroSocial);
        if(empleado != null) {
            empleado.setPrimerNombre(nuevoPrimerNombre);
            empleado.setApellidoPaterno(nuevoApellidoPaterno);
            System.out.println("Informacion Empleado Actualizado Exitosamente!");
        } else {
            System.out.println("Empleado NO encontrado");
        }
    }

    public void eliminarEmpleado(String numeroSeguroSocial) {
        Empleado empleado = Empleado.encontrarEmpleado(numeroSeguroSocial);
        if(empleado != null) {
            empleado.eliminar();
            System.out.println("Empleado eliminado exitosamente");
        } else {
            System.out.println("Empleado NO encontrado");
        }
    }
}