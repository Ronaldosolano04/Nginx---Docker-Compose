package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String primerNombre;
    protected String apellidoPaterno;
    protected String numeroSeguroSocial;
    protected static List<Empleado> listaEmpleados = new ArrayList<>();

    public Empleado(String primerNombre, String apellidoPaterno, String numeroSeguroSocial) {
        this.primerNombre = primerNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroSeguroSocial = numeroSeguroSocial;
        listaEmpleados.add(this);
    }

    public abstract double calcularPago();

    public String getPrimerNombre() { return primerNombre; }
    public String getApellidoPaterno() { return apellidoPaterno; }
    public String getNumeroSeguroSocial() { return numeroSeguroSocial; }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
    }

    public static Empleado encontrarEmpleado(String numeroSeguroSocial) {
        for(Empleado emp : listaEmpleados) {
            if(emp.numeroSeguroSocial.equals(numeroSeguroSocial)) {
                return emp;
            }
        }
        return null;
    }

    public void eliminar() {
        listaEmpleados.remove(this);
    }

    public static List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
}
