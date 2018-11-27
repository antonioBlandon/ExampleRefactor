package co.com.bancolombia.certification.examplerefactoring.refactoring;

import static co.com.bancolombia.certification.examplerefactoring.refactoring.domain.Venta.finalizarVenta;
import static co.com.bancolombia.certification.examplerefactoring.refactoring.domain.Venta.iniciarVenta;

public class Main {

    public static void main(String[] args) {

        iniciarVenta();
        finalizarVenta();

    }

}
