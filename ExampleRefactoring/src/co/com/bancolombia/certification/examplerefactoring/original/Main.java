package co.com.bancolombia.certification.examplerefactoring.original;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int valPerro = 2000, valHamburguesa = 3000, cantPerro = 0, cantHamburguesa = 0, proSel = 0, cant, selFin = 0, total, totalPer = 0, totalHamb = 0;

        boolean initTrans = true;
        Scanner entradaEscaner = new Scanner (System.in);

        System.out.println("Venta de perros y hamburguesas");

        while(initTrans){

            System.out.println("Seleccione producto: ");
            System.out.println("1. Perro \n2. Hamburguesa");
            proSel = Integer.parseInt(entradaEscaner.nextLine());
            System.out.println("Indique cantidad: ");
            cant = Integer.parseInt(entradaEscaner.nextLine());
            if (proSel == 1) {
                cantPerro = cantPerro + cant;
            }else if (proSel == 2){
                cantHamburguesa = cantHamburguesa + cant;
            } else {
                break;
            }
            System.out.println("Desea finalizar o agregar otro producto ?");
            System.out.println("1. Agregar \n2. Finalizar");
            selFin = Integer.parseInt(entradaEscaner.nextLine());
            if(selFin == 1) {
                initTrans = true;
            }else if (selFin == 2) {
                initTrans = false;
            }else {
                break;
            }

        }

        totalHamb = valHamburguesa*cantHamburguesa;
        totalPer = valPerro*cantPerro;
        total = totalHamb + totalPer;
        System.out.println("Total: "+total);

    }
}
