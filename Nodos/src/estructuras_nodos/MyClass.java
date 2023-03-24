package estructuras_nodos;

public class MyClass {
	/**
	 * Metodo principal de la clase.
	 * @param args
	 */
	public static void main(String args[]) {
		System.out.println("Comenzamos");
		//instanciamos la lista simple.
		listaSimple n1=new listaSimple();
		
		//invocamos las funcion insertar primero con el parametro de un entero=2, este se coloca al inicio de la lista simple.
		n1.insertarPrimero(2);
		//invocamos las funcion insertar con el parametro de un entero=1, este se coloca al inicio de la lista simple.
		//dejando de ser 2 la cabeza y ahora será 1.
		n1.insertarPrimero(1);
		//invocamos la funcion insertar final con parametro entero=3, este se colca al final de la lista simple.
		n1.insertarFinal(3);
		//invocamos la funcion insertar final con parametro entero=4, este se colca al final de la lista simple.
		//con lo cual el 4 pasa a estar de ultimas y el 3 de penultimas.
		n1.insertarFinal(4);

		
		System.out.println("Listamos desde main");
		//Invocamos la funcion listar, con la cual imprimimos el nodo actual, hasta recorrerlos todos.
		n1.listar();
		System.out.println("Borramos un Elemento");
		//invocamos la funcion borrar con parametro entero=2, con lo cual eliminamos el nodo que contenga dicha información.
		n1.borrar(2);
		//invocamos la funcion borrar con parametro entero=5,(En este caso el 5 no se encuentra en la lista).
		n1.borrar(5);
		System.out.println("volvemos a listar");
		//Invocamos la funcion listar, con la cual imprimimos el nodo actual, hasta recorrerlos todos. Ahora sin los elementos borrados previamente.
		n1.listar();
		}
	}

/**
 * Clase nodo.
 * @author lvargasc10
 *
 */
class Nodo{
	//Atributos con encapsulamiento.
	
	//elemento de tipo entero que se encontrará en la lista simple.
	private int elemento;
	
	//siguiente es de tipo Nodo.
	private Nodo siguiente;

/**
 * metodo constructor del Nodo	
 * @param elem, contenido del nodo.
 * @param sig, el nodo siguiente.
 */
public Nodo (int elem, Nodo sig){
	elemento = elem;
	siguiente = sig;
	}

/**
 * Metodo que devuelve el contenido del nodo.
 * @return el elemento de tipo entero.
 */
public int getElemento(){
	return elemento;
	}

/**
 * Metodo para devolver el nodo siguiente al que se apunta.
 * @return devuelve el siguiente nodo.
 */
public Nodo getSig(){
	return siguiente;
	}

/**
 * Funcion para asignar un dato al nodo.
 * @param elem, en este caso se asigna un entero.
 */
public void setElemento(int elem){
	elemento = elem;
	}
/**
 * Metodo para asignar a siguiente el nodo.
 * @param sig, el nodo siguiente.
 */
public void setSig(Nodo sig){
	siguiente = sig;
	}

}

/**
 * Clase listsSimple, en este caso cada nodo esta enlazado con otro unicamente. Solo apunta al siguiente nodo o a null.
 * @author lvargasc10
 *
 */
class listaSimple{
	//Atributos con encapsulamiento.	
	
	//variable de tipo Nodo, en este caso el primero (la cabeza).
	private Nodo primero;
	//Numero de elementos en la lista simple.
	private int numElem;
	
/**
 * Metodo constructor de la listaSimple	
 */
public listaSimple(){
	//Como el primer nodo esta apuntando a null, quiere decir que solo hay un nodo.
	primero = null;
	//Se inicializa en 0 el numero de elementos pues esta vacia la listaSimple.
	numElem = 0;
}

/**
 * Funcion para agregar elementos de primeras en la listaSimple.
 * @param elemento, en este caso un entero.
 */
public void insertarPrimero (int elemento){
	//Se instancia un nuevo nodo,con parametro entero y se asignara al inicio.
	Nodo nuevo = new Nodo (elemento, primero);
	//el primero nodo, para a ser ahora el nuevo nodo, reemplazandolo.
	primero = nuevo;
	//Se aumenta el numero de elementos de la listaSimple.
	numElem++;
}

/**
 * Funcion para agregar a la lista simple un elemento al final (cola).
 * @param elemento de tipo entero.
 */
public void insertarFinal (int elemento){
	//Se instancia el nuevo nodo apuntando a null porque estará ahora en la cola.
	Nodo nuevo = new Nodo(elemento, null);
	//Se verifica si sólo hay un nodo actualmente.
	if (primero == null){
		//de ser asi el primero para a ser el nuevo nodo.
		 primero = nuevo;
	}else {
		//De no ser asi, se instancia un nodo actual que seria el primero.
		Nodo actual = primero;
		//Mientras que el nodo actual no este apuntando a null.
		while (actual.getSig()!= null){			
			//El nodo actual será el siguiente nodo.
			actual = actual.getSig();
			}
		//Hasta llegar al nodo nuevo que será el actual y esta de ultimas.
		actual.setSig(nuevo);
		//Se aumenta el acumulador que contiene la cantidad de elementos de la listaSimple.
		numElem++;	
	}
		System.out.println("Final");	
}

/**
 * Funcion para eliminar un elemento de la listaSimple.
 * @param elem,entero que se desea eliminar.
 */
public void borrar(int elem){
	//Revisamos si en la lista no se encuentra ningun elemento.
	if (primero == null)
		System.out.println("lista vacía"); 
	else
		//Si el elemento a borrar esta en la primera posicion, se le asigna o se apunta al siguiente nodo.
		if (primero.getElemento()== elem){
			primero = primero.getSig();
			//Se resta del acumulador el numero de elementos de la lista simple.
			numElem--;					}
		else {
			Nodo actual = primero;
			while (actual.getSig()!=null && actual.getSig().getElemento() != elem)
				actual = actual.getSig();
			if (actual.getSig()== null )
				System.out.println ("elemento "+elem+" no esta en la lista");
			else{
				actual.setSig(actual.getSig().getSig());
				numElem--;
				}
			}
	}

/**
 * Funcion para mostrar los elementos que contiene la lsita simple.
 */
public void listar(){
	Nodo actual = primero;
	while (actual.getSig()!= null){
		System.out.println(actual.getElemento());
		actual = actual.getSig();
		}
	System.out.println(actual.getElemento());
	}
}
