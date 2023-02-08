
package proyectoextra;

import java.util.ArrayList;

/**
 * La clase permite la implementacion del heap por medio de un ArrayList, por medio de este se pueden agregar los valores de cada nodo, y a la vez se pueden
 * cambiar los valores por medio de los indices que tienen, mas que nada esta version del heap, se basa en lo visto en los temas de algoritmo de ordenamiento
 * donde se puede encontrar cada uno de los nodos y con eso trabajar.
 * @author Brain
 */
public class Heap extends ArbolBinBusq{
    ArrayList<Integer> elementos;
    
    /**
     * Metodo constructor que inicializa el Array List
     */
    public Heap(){
        elementos = new ArrayList<>();
    }
    
    /**
     * Metodo que permite verificar la integridad de los nodos padres con respecto a los nodos hijos, cuando se realiza una insercion de un nuevo nodo
     * y se debe comprobar que el hijo no sea mayor al hijo.
     */
    public void integridadPadre(){
	int ultimoHijo = elementos.size() - 1; //Posicion del ultimo hijo
	while (ultimoHijo > 0){
            int ultimoPadre = (ultimoHijo-1)/2; //Posicion del padre del ultimo hijo
            int hijo = elementos.get(ultimoHijo);
            int padre = elementos.get(ultimoPadre);
            if (hijo > padre) {
		elementos.set(ultimoHijo, padre);
		elementos.set(ultimoPadre, hijo);
		ultimoHijo = ultimoPadre; //Conserva la posicion del hijo que se volvio padre y se verifica la condicion en caso de que haya mas nodos
            }else{
		break;
            }
	}
    }
    
    /**
     * Metodo que permite la insercion de un nuevo elemento a la lista, y posteriormente se comprueba que los valores cumplan con la condicion del heap
     * @param elemento valor que se añade al heap
     */
    public void insertar(int elemento){
        elementos.add(elemento);
        integridadPadre();
    }
    
    /**
     * Se lleva a cabo el metodo para poder comprobar la integridad de la raiz, cuando es esta eliminada y se tiene que comprobar cual de dos hijos es 
     * el mayor para que se sucede el caso de que la raíz sea menor, que es lo que sucede normalmente debido a la integridad del arbol, se realiza, el
     * intercambio y esto se realiza de forma ciclica hasta que la integridad se cumpla.
     */
    public void integridadHijo(){
	int raiz = 0;
	int a,b;
	int hijoIzq = 2*raiz+1; //Posicion del hijo de la raiz
	while (hijoIzq < elementos.size()){ // Se comprueba con el hijo de la izq debido a que cuando se agrega el segundo valor representa al hijo izq
            int max=hijoIzq, hijoDer=hijoIzq+1;
            if (hijoDer < elementos.size()){ 
		a=elementos.get(hijoDer);
		b=elementos.get(hijoIzq);
		if (a > b){
                    max++; //Posicion del hijo mayor en caso de que exista
		}
            }
            a=elementos.get(raiz);
            b=elementos.get(max);
            if (a < b){ //Comparacion de la raiz con el hijo mayor
		int temp = elementos.get(raiz);
		elementos.set(raiz, elementos.get(max));
		elementos.set(max, temp);
		raiz = max;
		hijoIzq = 2*raiz+1; //Se colocar de nuevo la posiciondel hijo izq y se vuelve a compara en caso de que se tenga que comprobar la max hijo
            }else{
		break;
            }
	}
    }

    /**
     * Con este metodo se elimina un valor del array, y por medio de este se verifican las posibles condiciones,donde existan elementos en el array, 
     * cuando no hay y cuando se debe eliminar la raiz, en este ultimo caso de elimina el valor de la raiz, y se coloca el valor del ultimo hijo
     * @return  valor de la raiz que se elimina
     */
    public int eliminar(){
        if (elementos.isEmpty()){
            System.out.println("Heap vacio");
            return 0;
        }
        if (elementos.size() == 1){
            root=null;
            return elementos.remove(0);
        }
        int raiz = elementos.get(0);
        elementos.set(0, elementos.remove(elementos.size()-1)); //Se intercambian posiciones la raiz se elimina  y se coloca el ultimo hijo de la lista
        integridadHijo();
        return raiz; //Comprobar el hijo
    }
    
    /**
     * Imprimir los valores del arreglo
     * @return 
     */
    @Override
    public String toString() {
    return elementos.toString();
    }
}
