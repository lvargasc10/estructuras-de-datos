import java.util.Scanner;

/**
 * Algoritmo para realizar operaciones con enteros y adjuntarlas a un String.
 * @author lvargasc10
 * @date 14/02/20
 * @version 1.0
 */

public class Algoritmo {
	
	public Algoritmo() {};
	
		
	public void operaciones() {
		
		//Utilizo el try para evitar prosibles errores.
		try {
			Scanner lectorInt = new Scanner(System.in); //Utilizo scanner para facilitar la lectura de datos.
			
			//Solicito al usuario que ingrese los valores correspondientes.
			System.out.println("\nIngrese el primer valor (Entero): ");			
			int valorUno = lectorInt.nextInt();		
			
			System.out.println("Ingrese el segundo valor(Entero): ");
			int valorDos = lectorInt.nextInt();
			
			//Por medio de condicionales permito que se realicen las operaciones si se cumple lo estipulado.
			if(valorUno <= 0  || valorDos <= 0) {//Los valores deben ser mayores a 0.
				System.out.println("El valor ingresado debe ser mayor a 0. Intente de nuevo.");
				operaciones();
				
			}
			else if (valorUno < valorDos) {//El primero valor debe ser mayor al segundo.
				System.out.println("El primer valor debe ser mayor al segundo. Intente de nuevo.");
				operaciones();
			}
			
			else {
				
				//Realizo las operaciones si se cumplieron las condiciones.
				int suma = valorUno + valorDos; 
				int resta = valorUno - valorDos;
				int multiplicacion = valorUno*valorDos;	
				
				//Convierto los resultados enteros a cadenas.
				String sumaString = Integer.toString(suma);
				String restaString = Integer.toString(resta);
				String multiString = Integer.toString(multiplicacion);
				
				//Concateno los resultados en un solo arreglo.
				String suma_resta = sumaString.concat(restaString);
				String concatFinal = suma_resta.concat(multiString);			
				
				//Muestro al usuario el resultado de las operaciones ya concatenadas.
				System.out.println(concatFinal);
				
				System.out.print("\n¿Juegar de nuevo? \n[1]Si \n[2]No");
				int opcion = lectorInt.nextInt();
				
				switch(opcion) {
				case 1:
					operaciones();
				break;
				case 2:
					System.out.print("\n¡Gracias por Jugar! Adiós.");
				}
			}	
			//Si llega a ocurrir algun error, se muestra la siguiente excepción al usuario.
			}catch(Exception e) {System.out.println("El valor ingresado no es un numero ENTERO o \nes demasiado largo (MAX Valor: "+Integer.MAX_VALUE+") , intente de nuevo.");
				operaciones();
			}		
		}		
	}
	


