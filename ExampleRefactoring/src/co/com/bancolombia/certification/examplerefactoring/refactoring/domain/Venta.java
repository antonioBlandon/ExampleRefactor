package co.com.bancolombia.certification.examplerefactoring.refactoring.domain;

import co.com.bancolombia.certification.examplerefactoring.refactoring.utils.Consola;

import static co.com.bancolombia.certification.examplerefactoring.refactoring.utils.Consola.capturarDato;

public class Venta {

    private static int cantidadDePerroSeleccinada = 0;
    private static int cantidadDeHamburguesaSeleccionada = 0;

    public static void iniciarVenta() {

        boolean ventaActivada = true;
        int productoSeleccionado;
        int cantidadDeProductoSeleccionada;
        int opcionFinVenta;
        Consola.mostrarMensaje("Venta de perros y hamburguesas");

        while(ventaActivada){

            productoSeleccionado = capturarDato().comoEntero("Seleccione producto: \n" + "1. Perro \n2. Hamburguesa" );
            cantidadDeProductoSeleccionada = capturarDato().comoEntero("Ingrese cantidad: ");
            aumentarProducto(productoSeleccionado, cantidadDeProductoSeleccionada);
            opcionFinVenta = capturarDato().comoEntero("Desea finalizar o agregar otro producto ? \n" + "1. Agregar \n2. Finalizar");
            ventaActivada = ventaEstaActivada(opcionFinVenta);

        }

    }

    public static void finalizarVenta() {
        int PRECIO_PERRO = 2000;
        int PRECIO_HAMBURGUESA = 3000;
        Consola.mostrarMensaje("Total: " +
                ((PRECIO_HAMBURGUESA * cantidadDeHamburguesaSeleccionada) + (PRECIO_PERRO *cantidadDePerroSeleccinada)) );
    }

    public static void aumentarProducto(int productoSeleccionado, int cantidadDeProductoSeleccionada) {
        if (productoSeleccionado == 1) {
            cantidadDePerroSeleccinada = cantidadDePerroSeleccinada + cantidadDeProductoSeleccionada;
        }else if (productoSeleccionado == 2){
            cantidadDeHamburguesaSeleccionada = cantidadDeHamburguesaSeleccionada + cantidadDeProductoSeleccionada;
        }
    }

    public static boolean ventaEstaActivada(int opcionFinVenta) {
        return opcionFinVenta == 1;
    }

}
