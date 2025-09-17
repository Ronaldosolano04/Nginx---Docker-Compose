package modelo;

public class EmpleadoPorHoras extends Empleado {
    private double sueldoPorHora;
    private double horasTrabajadas;

    public EmpleadoPorHoras(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, 
                           double sueldoPorHora, double horasTrabajadas) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        this.sueldoPorHora = sueldoPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    @Override
    public double calcularPago() {
        if (horasTrabajadas <= 40) {
            return sueldoPorHora * horasTrabajadas;
        } else {
            double pagoBase = sueldoPorHora * 40;
            double pagoExtra = sueldoPorHora * 1.5 * (horasTrabajadas - 40);
            return pagoBase + pagoExtra;
        }
    }
}
