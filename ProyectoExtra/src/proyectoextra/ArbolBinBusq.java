
package proyectoextra;

/**
 * Clase que permite la creacion de un arbol Binariod de Busqueda, todas los metodo sirven para poder ser implementados posteriormente en el arbol de
 * busqueda binaria balanceado, pero de igual forma se tendrían que modificar por la rotaciones y ajustes.
 * @author Brain
 */
public class ArbolBinBusq extends ArbolBin{
    
    public ArbolBinBusq(){
        super();
    }
    
    public ArbolBinBusq(int val){
        super(val,'a');
    }
    
    public ArbolBinBusq(Nodo root){
        super(root);
    }
    
    /**
     * Se eliminan los nodos, en base a la busqueda del valor del nodo, y despues se elimina cambiando la referencia del padre
     * @param dato
     */
    public void eliminarNodo(int dato){
        Nodo viajero = root;
        Nodo padre = root;//Nodo que toma la posicion del padre, no se toma la viajero.padre, porque esta se modificaria en cada iteracion
        boolean NodoIzq=true;
        while(viajero.valor!=dato){
            padre=viajero;
            if(dato<viajero.valor){
                viajero=viajero.izq;
                NodoIzq=true;//Se indica si el nodo es derecho o izquierdo, lo que permite decirle al padre a que direccion pauntar
            }else{
                viajero=viajero.der;
                NodoIzq=false;
            }
            if(viajero==null){
                return;//termina la ejecucio ya que no lo encontro
            }
        }
        //Se analizan los tres posibles caso de un nodo: hoja, un hijo, dos hijos
        if(viajero.izq==null && viajero.der==null){//Sin hijos
            if(viajero==root){
                root=null;
            }else if(NodoIzq){
                padre.izq=null;
            }else{
                padre.der=null;
            }
        }else if(viajero.der==null){//Con hijo izquierdo
            if(viajero==root){
                root=viajero.izq;
            }else if(NodoIzq){
                padre.izq=viajero.izq;
            }else{
                padre.der=viajero.izq;
            }
        }else if(viajero.izq==null){//Con hijo derecho
            if(viajero==root){
                root=viajero.der;
            }else if(NodoIzq){
                padre.izq=viajero.der;
            }else{
                padre.der=viajero.der;
            }
        }else{//Con ambos hijos
            Nodo intercambio = buscador(viajero);
            if(viajero==root){
                root=intercambio;
            }else if(NodoIzq){
                padre.izq=intercambio;
            }else{
                padre.der=intercambio;
            }
            intercambio.der=viajero.der;//Toma los valores de la derecha del viajero para que no se pierdan 
        }
    }
    
    /**
     * En este metodo se lleva a cabo la busqueda del nodo que reemplaza al nodo a eliminar
     * @param viajero
     * @return 
     */
    public Nodo buscador(Nodo viajero){
        Nodo intercambio=viajero;
        Nodo viajeroI=viajero.izq;
        //busca hasta la derecha final
        while(viajeroI!=null){
            intercambio=viajeroI;
            viajeroI=viajeroI.der;
        }
        //Cuando el padre tiene ñietos 
        if(intercambio!=viajero.izq){//Si encuentra que se ha desplazado a la derecha significa que tiene hijos y los nodos se guardan a la izquierda
            intercambio.izq=viajero.izq;
        }
        return intercambio;
    }
    
    /**
     * Metodo que agrega un nuevo nodo de acuerdo a loa valores y a la posicion que este debería tener
     * @param dato
     */
    public void agregarNodoBusq(int dato){
        Nodo nuevo = new Nodo(dato,null,'a');
        if(root==null){
            root=nuevo;
        }else{
            Nodo viajero = root;
            Nodo padre;//De forma igual a la elimininacion si se utiliza el atributo padre del nodo este modificaria constantemente la variable en el ciclo
            while(true){
                padre=viajero;
                if(dato<viajero.valor){
                    viajero=viajero.izq;
                    if(viajero==null){
                        padre.izq=nuevo;
                        nuevo.padre=padre;//Se asigna cual es el padre, aunque no se utilice el atributo
                        break;
                    }
                }else{
                    viajero=viajero.der;
                    if(viajero==null){
                        padre.der=nuevo;
                        nuevo.padre=padre;
                        break;
                    }
                }
            }
        }
    }
    
    /**
     *Se busca el nodo en base a la valor de este
     * @param valor
     * @return 
     */
    public int buscarNodo(int valor){
        Nodo viajero=root;
        while(viajero.valor!=valor){
            if(valor<viajero.valor){
                viajero=viajero.izq;
            }else{
                viajero=viajero.der;
            }
            if(viajero==null){
                return 0;
            }
        }
        return 1;
    }
}
