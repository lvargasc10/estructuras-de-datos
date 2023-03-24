package Tarea2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase en la cual se devuelve una matriz nxla cantidad de datos ingresada, con varias operaciones en sus filas y una sumatoria final.
 * @author Luisa Mabel
 * @version 1.2
 * @date 24/02/2020
 */
public class MatrizOperaciones {
	
	//ATRIBUTOS
	
	//Lista dinamica con los resultados del tiro parabolico.
	ArrayList<Double> listaTipoParabolico;
	
	
	/**
	 * Metodo menu para que el usuario pueda interactuar con el algoritmo.
	 */	
	public void menu() {
		
		try {	
		
		//atributos
		Scanner lecturaInt = new Scanner(System.in);
		int opcion;		
		
		do {
		
		//menu de opciones
		System.out.println("\nBIENVENIDO"
				+ "\n[1] Ingresar los valores del tiro parabolico (VELOCIDAD y ANGULO)"
				+ "\n[2] Mostrar matriz con resultados"
				+ "\n[3] Salir");				
		
		opcion = lecturaInt.nextInt();
		
		if (opcion <= 0 || opcion >3) {
			System.out.println("La opcion ingresa NO es valida, observe el menu de opciones e intente de nuevo.");
			menu();
		}else {
		switch(opcion) {
		
		case 1:
			tipoParabolico();
		break;
		
		case 2:	
			//Condicional por si los valores ingresados no son los correctos.
			if(listaTipoParabolico.size()==0) {
				System.out.println("\nNo ha ingresado los valores necesarios para crear la matriz, intente de nuevo.");
				
			}else {
				//instancio las variables necesarias con ayuda de los metodos.
				Double[][] nuevaMatriz = crearMatriz(listaTipoParabolico);			
				Double[] columnaSuma =sumatoriaColumna(nuevaMatriz);
				imprimirMatriz(copiarMatriz(nuevaMatriz,columnaSuma,listaTipoParabolico));
			}
		break;
		
		case 3:			
			System.out.println("\nSaliendo... Gracias!");
		break;
			}
		
		}
			}while (opcion != 3);		
		}catch(Exception e) {System.out.println("La opcion ingresa NO es valida, observe el menu de opciones e intente de nuevo.");
			menu();
		}		
	}		
	
	/**
	 * Metodo para realizar las operaciones de tiro parabolico en los valores ingresados por el usuario.
	 * @return una lista dinamica con los valores operados.
	 */
	public ArrayList<Double> tipoParabolico(){
		
		try {
		Scanner lectura = new Scanner(System.in);		
		double cantidad;
		double velocidad;
		double angulo;
		double operacion;
		
		System.out.print("Ingrese la cantidad de datos (DEBE ser mayor a 0  y menor a 170): ");
		cantidad = lectura.nextDouble();
		
		if(cantidad <= 0.0 || cantidad > 170.0) {
			System.out.println("La cantidad ingresada DEBE ser mayor a 0  y menor a 170, intente de nuevo.");
			menu();
		}
		
		System.out.println((int)cantidad+" VELOCIDADES y "+(int)cantidad+" ANGULOS:");
		for (int i=1; i< cantidad+1;i++) {		
			
			System.out.println("\nIngrese la velocidad "+ i+":");
			velocidad = lectura.nextDouble();
			
			if(velocidad <= 0.0) {
				System.out.println("La velocidad ingresada DEBE ser mayor a 0, intente de nuevo.");
				menu();
			}
			
			System.out.println("Ingrese el angulo (Valor entre 0 y 90) "+ i +":");
			angulo = lectura.nextDouble();
			
			if(angulo<0 || angulo >90) {
				System.out.println("El angulo ingresado NO esta entre el rango indicado (0 a 90), intente de nuevo.");
				menu();
			}
			
			operacion = Math.round(Math.pow(velocidad, 2)*(Math.sin((Math.toRadians(2*angulo))))/9.8);			
			listaTipoParabolico.add(operacion);
			}
			}catch(Exception e) {System.out.println("El valor ingresado no es un numero, intente de nuevo.");		
		}
		return listaTipoParabolico;			
	}
	
	/**
	 * Metodo para crear la matriz con los valores y las operaciones sobre ellos.	
	 * @param la lista dinamica con los valores del tiro parabolico.
	 * @return la matriz con todos los resultados pero sin la sumatoria.
	 */
	public Double[][] crearMatriz(ArrayList<Double> listaTipoParabolico){		
		
		Double[][] matriz = new Double[4][listaTipoParabolico.size()];
		
		if (listaTipoParabolico!=null)
			for (int j=0;j<4;j++) 
				for	(int k = 0; k < listaTipoParabolico.size(); k++) {
					//invoco los metodos necesarios sobre cada posicion de la matriz en cada fila.
					matriz[0][k]= listaTipoParabolico.get(k);
					matriz[1][k]= fibonacciFila((double)k);
					matriz[2][k]= factorialFila((double)k+1.0);										
					matriz[3][k]= Math.pow(k,2);					
			}
		return matriz;		
	}
	
	/*
	 * Metodo recursivo para hallar fibonacci.
	 */
	public Double fibonacciFila(Double numeroPosicion) {
		if ((numeroPosicion == 0.0) || (numeroPosicion == 1.0))
			//Si el valor es 0 o 1 simplemnte se retorna el mismo valor.
			return numeroPosicion;
		else
			//invoco dentro de si misma  la funcion y realizo la suma de todos los números desde numeroPosicion -1.
		    return fibonacciFila(numeroPosicion - 1.0) + fibonacciFila(numeroPosicion - 2.0);
		   }
	
	/**
	 * Metodod para realizar el factorial a cada valor.
	 * @param el valor que se encuentra en la posicion.
	 * @return el factorial de ese numero.
	 */
	public Double factorialFila(Double numeroPosicion) {  
		
		//tomo como base el numero 1.
        Double factorial = 1.0;
        for(int i = 1; i <= numeroPosicion; ++i)
        {            
            factorial *= i;// realizo el producto de todos los numeros enteros positivos hasta el numero de posicion.
        }
        return factorial;
    }
	
	/**
	 * Metodo para sumar las filas de la matriz y colocarlas en un vector.
	 * @param matriz de valores.
	 * @return vector con la sumatoria de la fila.
	 */
	public Double[] sumatoriaColumna(Double[][] matriz) {
		Double[]vectorSuma = new Double[4];
		for(int i = 0; i < matriz.length; i++){  
            Double sumRow = 0.0;  
	            for(int j = 0; j < matriz[0].length; j++){
	           	sumRow=sumRow + matriz[i][j];	
	            vectorSuma[i]= sumRow;              
	           }	            
	       }
		return vectorSuma;
		}		
		
	/**
	* Metodo para crear una matriz con la sumatoria de cada fila.
	* @param matriz con los valores.
	* @param vector con la suma de los valores de las filas.
	* @param lista con los valores del tiro parabolico.
	* @return matriz final.
	*/		
	public Double[][] copiarMatriz(Double[][] matrizValores,Double[] vectorSuma,ArrayList<Double> listaTipoParabolico){
			
		Double[][] matriz = new Double[4][this.listaTipoParabolico.size() +1];
		int n = this.listaTipoParabolico.size() +1;
		for ( int i = 0 ; i < matrizValores.length; i++){
			//arraycopy, copia desde la posición origen de un array a un array destino en una posición específica. 
		    System.arraycopy(matrizValores[i], 0, matriz[i], 0, matrizValores[i].length);
		    //a la ultima columna de la matriz le asigno los valores del vector suma.
		    matriz[i][n-1]=vectorSuma[i];
			}		
		return matriz;
		}
	
	/**
	 * Metodo para imprimir la matriz de una manera organizada. 	
	 * @param matriz
	 */
	public void imprimirMatriz(Double[][] matriz) {
		
		String[] titulos = {"Parabolico ","Fibonacci  ","Factorial  ","Cuadrado   "};
		for (int i = 0; i < matriz.length; i++) {
			//imprimo los titulos de cada fila y un espacio entre ellos.
			System.out.print(titulos[i]+ "  ");
		    for (int j = 0; j < matriz[i].length; j++) {
		    	//imprimo un espacio entre los valores de la matriz.
		        System.out.print(matriz[i][j] + "  ");
		    }
		    System.out.println();            
		}		
	}
	
	/**
	 * Metodo principal del programa.
	 * @param args
	 */
	public static void main(String[] args) {	
		MatrizOperaciones matrizOperaciones = new MatrizOperaciones();
		matrizOperaciones.listaTipoParabolico = new ArrayList();
		matrizOperaciones.menu();
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
