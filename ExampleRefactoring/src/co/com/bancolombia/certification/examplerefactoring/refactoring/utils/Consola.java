package co.com.bancolombia.certification.examplerefactoring.refactoring.utils;

import java.util.Scanner;

public class Consola {

    private static Consola consola;
    private static Scanner entradaEscaner;

    private Consola() {
    }

    public static Consola capturarDato() {
        if(consola == null) {
            entradaEscaner = new Scanner(System.in);
            consola = new Consola();
        }
        return consola;
    }

    public int comoEntero(String mensajeParaUsuario) {
        System.out.println (mensajeParaUsuario);
        return Integer.parseInt(entradaEscaner.nextLine());
    }

    public static void mostrarMensaje(String message) {
        System.out.println(message);
    }

}
