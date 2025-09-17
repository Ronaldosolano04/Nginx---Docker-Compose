package modelo.utilidades;

import java.util.Scanner;

public class Validador {
    public static String validarNumeroSeguroSocial(String numero) {
        if (numero.matches("\\d{11}")) {
            return numero;
        } else {
            return solicitarNuevoValor("NUMERO DE SEGURO SOCIAL INVALIDO, DEBE TENER 11 DIGITOS");
        }
    }
    
    public static double validarSalario(double valor) {
        return valor > 0 ? valor : solicitarNuevoValorDouble("SALARIO DEBE SER MAYOR A CERO");
    }
    
    public static double validarHoras(double valor) {
        return (valor >= 0 && valor <= 168) ? valor : solicitarNuevoValorDouble("LAS HORAS DEBEN ESTAR ENTRE 0 Y 168");
    }
    
    public static double validarVentas(double valor) {
        return valor >= 0 ? valor : solicitarNuevoValorDouble("LAS VENTAS NO PUEDEN SER NEGATIVAS");
    }
    
    public static double validarTarifa(double valor) {
        return (valor > 0 && valor <= 1) ? valor : solicitarNuevoValorDouble("TARIFA DEBE ESTAR ENTRE 0 Y 1");
    }
    
    private static String solicitarNuevoValor(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.next();
    }
    
    private static double solicitarNuevoValorDouble(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mensaje);
        return scanner.nextDouble();
    }
}