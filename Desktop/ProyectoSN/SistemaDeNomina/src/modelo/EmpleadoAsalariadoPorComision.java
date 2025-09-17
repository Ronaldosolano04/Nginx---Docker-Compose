package modelo;

public class EmpleadoAsalariadoPorComision extends Empleado {
    private double salarioBase;
    private double ventasBrutas;
    private double tarifaComision;

    public EmpleadoAsalariadoPorComision(String primerNombre, String apellidoPaterno, String numeroSeguroSocial, 
                                        double salarioBase, double ventasBrutas, double tarifaComision) {
        super(primerNombre, apellidoPaterno, numeroSeguroSocial);
        this.salarioBase = salarioBase;
        this.ventasBrutas = ventasBrutas;
        this.tarifaComision = tarifaComision;
    }

    @Override
    public double calcularPago() {
        return (ventasBrutas * tarifaComision) + salarioBase + (salarioBase * 0.10);
    }
}
