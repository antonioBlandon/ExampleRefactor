package co.com.bancolombia.certification.refactor.original;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		//Declarar variables
		String a = "";
		int b;
		long fIngreso;
		List<String> moto = new ArrayList<>(),carro = new ArrayList<>();
		boolean cupo = false,plcVal, plcExist=false, ingExi = false,car;
		
		//Capturar datos
		System.out.println ("Ingrese la placa por favor:");
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		a = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		System.out.println ("Ingrese el cilindraje si es motocicleta, de lo contrario ingrese 0:");
		b = Integer.parseInt(entradaEscaner.nextLine());
		System.out.println ("Placa: \"" + a +"\"");
		System.out.println ("Cilindraje: \"" + b +"\"");

		//Validar si ingreso placa
        if (!a.isEmpty()) {
        	
        	fIngreso = Calendar.getInstance().getTimeInMillis();
        	
        	//Determinar tipo de vehículo
        	if(b == 0) {
        		car = true;
        	}else {
        		car = false;
        	}

        	//Validar placa existe
        	if(car) {
        		for(String item : carro) {
        			if(item.equals(a)) {
        				plcExist = true;
        			}
        		}
        	}else {
        		for(String item : moto) {
        			if(item.equals(a)) {
        				plcExist = true;
        			}
        		}
        	}
        	
        	//Validar cupo
            if (car) {
            	if(carro.size() < 20) {
            		cupo = true;	
            	}
            } else {
            	if(moto.size() < 10) {
                    cupo = true;	
            	}
            }
            
            //Validar Placa
            String primeraLetra = a.substring(0, 1);
            if (primeraLetra.equals("A")) {
                //Dias validos
                int lunes = 2;
                int domingo = 1;

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(fIngreso);
                int dia = calendar.get(Calendar.DAY_OF_WEEK);
                if((dia == domingo) || (dia == lunes)) {
                	plcVal = true;
                }else {
                	plcVal = false;
                }
            }else {
            	plcVal = true;
            }

            //Cumple los requisitos, entonces puede ingresar el vehiculo y debe almacenar el registro de dicho ingreso
            if (cupo && plcVal && !plcExist) {

                ingExi = true;
                if (ingExi) {
                    if (car) {
                        carro.add(a);
                    } else {
                    	moto.add(a);
                    }
                }

            }
            
            //Se muestran los mensajes según sea el caso
            if (ingExi) {
            	System.out.println("Ingreso Exitoso");
            } else if ( plcVal && cupo && !plcExist) { //Solo se muestra si los otros mensajes no se han de mostrar
            	System.out.println("Error en el ingreso");
            }
            if (!plcVal) {
            	System.out.println("El vehiculo no puede ingresar");
            }
            if (!cupo) {
            	System.out.println("No hay cupo en el parqueadero");
            }
            if (plcExist) {
            	System.out.println("Ya existe un vehiculo con esta placa");
            }
        } else {
        	System.out.println("Debe ingresar una placa");
        }		
		
	}
	
	

}
