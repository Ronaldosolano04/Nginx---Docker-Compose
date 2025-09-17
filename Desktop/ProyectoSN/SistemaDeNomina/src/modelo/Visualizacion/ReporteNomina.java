package modelo.Visualizacion;

import modelo.Empleado;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReporteNomina {
    private static final DateTimeFormatter formatter = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public void generar() {
        System.out.println("\n=====REPORTE DE NOMINA=====");
        System.out.println("Fecha y hora: " + 
                LocalDateTime.now().format(formatter));
        System.out.println("---");
        
        double totalPagos = 0;

        for(Empleado emp : Empleado.getListaEmpleados()) {
            System.out.printf("%s %s%n", emp.getPrimerNombre(), emp.getApellidoPaterno());
            System.out.printf("Pago semanal: $%.2f%n", emp.calcularPago());
            System.out.println("---");
            totalPagos += emp.calcularPago();
        }

        System.out.printf("TOTAL DE PAGOS: $%.2f%n", totalPagos);
        System.out.println("---");
    }
}
