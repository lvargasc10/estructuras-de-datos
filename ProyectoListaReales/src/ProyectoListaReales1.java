import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Un ArrayList es un arreglo dinámico.
 * Un ArrayList puede servir para almancenar datos u objetos, sin definir previamente el tamaño del mismo.
 */

/**
 * Clase en la cual se puede manipular un arreglo de diferentes maneras por medio de métodos.
 * @author lvargasc10
 * @date 19/02/20
 */
public class ProyectoListaReales1 {
	
	//Variables
	
	//Lista que contendrá los números ingresados.
	ArrayList<Double> listaReales;
	
	/**
	 * Método principal del algoritmo.
	 * @param args
	 */
	public static void main(String[] args) {
		ProyectoListaReales1 proyectoReales = new ProyectoListaReales1();
		proyectoReales.listaReales = new ArrayList();
		proyectoReales.leerOpcion();
	}
	
	
	/**
	 * Método para mostrar al usuario el menú y manipular las opciones ingresadas según sea el caso.
	 */
	public void leerOpcion() {
		
		Scanner entrada = new Scanner(System.in);
		int opcion;		
		do {
		System.out.println("\nLista de Reales");
		System.out.println("[1] Agregar ");
		System.out.println("[2] Buscar");
		System.out.println("[3] Modificar elemento");
		System.out.println("[4] Eliminar elemento");
		System.out.println("[5] Insertar elemento");
		System.out.println("[6] Mostrar elementos");
		System.out.println("[7] Orden ascendente");
		System.out.println("[8] Orden descendente");
		System.out.println("[9] Salir\n");
		System.out.println("Ingrese opcion (1-9) ");		
		
		opcion = entrada.nextInt();
		switch(opcion) {
		case 1:
			ingresarValor();
		break;
		case 2:
			buscarValor();
		break;
		case 3:
			modificarValor();
		break;
		case 4:
			eliminarValor();
		break;
		case 5:
			insertarValor();
		break;
		case 6:
			mostrarLista();
		break;
		case 7:
			ordenarAscendente();
		break;
		case 8:
			ordenarDescendente();
		break;
				}
			}while (opcion != 9);
		}	
	
	/**
	 * Método para ingresar un valor al arreglo existente.	 
	 */
	public void ingresarValor() {
		Scanner entrada = new Scanner(System.in);
		double valor;
		System.out.print("Ingrese valor: ");
		valor = entrada.nextDouble();
		listaReales.add(valor);
	}
	
	/**
	 * Método para buscar un valor en que arreglo existente.
	 */
	public void buscarValor() {
		Scanner entrada = new Scanner (System.in);
		double valor;
		int indice;
		System.out.print("Valor a buscar: ");
		valor = entrada.nextDouble();
		indice = listaReales.indexOf(valor);//A indice se le asigna la posicion en la que se encuentra el valor ingresado.
		if (indice != -1) {
			System.out.println("Dato se encuentra en posición: "+indice);
		}else {
			System.out.println("Dato no se encuentra ");
		}
	}
	
	/**
	 * Método para modificar un valor previamente ingresado en el arreglo.
	 */
	public void modificarValor() {
		Scanner entrada = new Scanner(System.in);
		double valor,nuevoValor;
		int indice;
		System.out.print("Valor a modificar: ");
		valor = entrada.nextDouble();
		indice = listaReales.indexOf(valor);
		if (indice != -1) {
			System.out.print("Nuevo valor: ");
			nuevoValor = entrada.nextDouble();
			listaReales.set(indice,nuevoValor);
		}else {
			System.out.println("Dato no se encuentra");
		}
	}
	
	/**
	 * Método para eliminar un valor que se encuentre en arreglo.
	 */
	public void eliminarValor() {
		Scanner entrada = new Scanner(System.in);
		double valor;
		int indice;
		System.out.print("Valor a eliminar: ");
		valor = entrada.nextDouble();
		indice = listaReales.indexOf(valor);//A indice se le asigna la posicion en la que se encuentra el valor ingresado.
		if (indice != -1) {
			listaReales.remove(indice);
		}else {
			System.out.println("Dato no se encuentra");			
		}
	}
	
	/**
	 * Método para ingresar un valor pero seleccionando la posición deseada.	
	 */
	public void insertarValor(){
		Scanner entrada = new Scanner(System.in);
		double valor;
		int indice;
		System.out.print("Valor a insertar: ");
		valor = entrada.nextDouble();
		System.out.print("Posicion donde desea insertar: ");
		indice = entrada.nextInt();//A indice se le asigna el entero ingresado como posición.
		listaReales.add(indice,valor);		
	}
	
	/*
	 * Método para mostrar los elementos que contiene el arreglo.	
	 */
	public void mostrarLista() {
		if (!listaReales.isEmpty()) {
			System.out.println("Elementos de la lista: ");	
			for (int i=0; i<listaReales.size();i++) {
				System.out.println(listaReales.get(i));
			}
		}else {
			System.out.println("No existen valores en la lista");
		}	
		
	}
	
	/**
	 * Método para ordenar de mayor a menor los elementos que contiene el arreglo.
	 */
	public void ordenarAscendente() {
		Collections.sort(listaReales);
		mostrarLista();
	}
	
	/**
	 * Método para ordenar de menor a mayor los elementos que contiene el arreglo.
	 */	
	public void ordenarDescendente() {
		Comparator<Double> comparador = Collections.reverseOrder();
		Collections.sort(listaReales,comparador);
		mostrarLista();
	}	
}
	
		
