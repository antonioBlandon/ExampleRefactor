package co.com.bancolombia.certification.refactor.refactoring;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		String placa = "";
		int cilindraje;
		long fechaIngresoAlParqueadero;
		List<String> motosEnParqueadero = new ArrayList<>();
		List<String> carrosEnParqueadero = new ArrayList<>();
		boolean tieneCupo = false;
		boolean placaValida; 
		boolean placaExiste = false; 
		boolean ingresoExitoso = false;
		boolean esCarro;
		
		//Capturar datos
		System.out.println ("Ingrese la placa por favor:");
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		placa = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		System.out.println ("Ingrese el cilindraje si es motocicleta, de lo contrario ingrese 0:");
		cilindraje = Integer.parseInt(entradaEscaner.nextLine());
		System.out.println ("Placa: \"" + placa +"\"");
		System.out.println ("Cilindraje: \"" + cilindraje +"\"");

		//Validar si ingreso placa
        if (!placa.isEmpty()) {
        	
        	fechaIngresoAlParqueadero = Calendar.getInstance().getTimeInMillis();
        	
        	//Determinar tipo de vehículo
        	if(cilindraje == 0) {
        		esCarro = true;
        	}else {
        		esCarro = false;
        	}

        	//Validar placa existe
        	if(esCarro) {
        		for(String item : carrosEnParqueadero) {
        			if(item.equals(placa)) {
        				placaExiste = true;
        			}
        		}
        	}else {
        		for(String item : motosEnParqueadero) {
        			if(item.equals(placa)) {
        				placaExiste = true;
        			}
        		}
        	}
        	
        	//Validar cupo
            if (esCarro) {
            	if(carrosEnParqueadero.size() < 20) {
            		tieneCupo = true;	
            	}
            } else {
            	if(motosEnParqueadero.size() < 10) {
                    tieneCupo = true;	
            	}
            }
            
            //Validar Placa
            String primeraLetra = placa.substring(0, 1);
            if (primeraLetra.equals("A")) {
                //Dias validos
                int lunes = 2;
                int domingo = 1;

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(fechaIngresoAlParqueadero);
                int dia = calendar.get(Calendar.DAY_OF_WEEK);
                if((dia == domingo) || (dia == lunes)) {
                	placaValida = true;
                }else {
                	placaValida = false;
                }
            }else {
            	placaValida = true;
            }

            //Cumple los requisitos, entonces puede ingresar el vehiculo y debe almacenar el registro de dicho ingreso
            if (tieneCupo && placaValida && !placaExiste) {

                ingresoExitoso = true;
                if (ingresoExitoso) {
                    if (esCarro) {
                        carrosEnParqueadero.add(placa);
                    } else {
                    	motosEnParqueadero.add(placa);
                    }
                }

            }
            
            //Se muestran los mensajes según sea el caso
            if (ingresoExitoso) {
            	System.out.println("Ingreso Exitoso");
            } else if ( placaValida && tieneCupo && !placaExiste) { //Solo se muestra si los otros mensajes no se han de mostrar
            	System.out.println("Error en el ingreso");
            }
            if (!placaValida) {
            	System.out.println("El vehiculo no puede ingresar");
            }
            if (!tieneCupo) {
            	System.out.println("No hay cupo en el parqueadero");
            }
            if (placaExiste) {
            	System.out.println("Ya existe un vehiculo con esta placa");
            }
        } else {
        	System.out.println("Debe ingresar una placa");
        }		
		
	}
	
	

}
