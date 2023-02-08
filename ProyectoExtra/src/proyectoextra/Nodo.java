
package proyectoextra;

/**
 * Clase que imprementa un nodo, la cual es la base de todos los arboles y contiene cada uno de los atributos que se utilizan en los arboles.
 * @author Brain
 */
public class Nodo {
    int valor;
    char operacion;
    Nodo izq = null;
    Nodo der = null;
    Nodo padre=null;//Se agrega la referencia del padre para poder manejar la insercion mejor, porque en este caso no hay muchas condicionales para 
                    //la insercion de los valores 
    
    /**
     *Constructor por defecto de los nodos; 
     */
    
    public Nodo(){
        izq=der=null;
    }
    
    /**
     * Se crea el nodo unicamente con el valor que contiene
     * @param data
     * @param father
     * @param operacion
     */ 
    
    public Nodo(int data,Nodo father,char operacion){
        valor=data;
        izq=null;
        der=null;
        padre=father;
        this.operacion=operacion;
    }
    
    /**
     * Se crea el nodo con el valor y las refencias de los nodos de la 
     * @param data
     * @param izquierda
     * @param derecha
     * @param father
     */ 
    public Nodo(int data, Nodo izquierda, Nodo derecha,Nodo father){
        valor=data;
        izq = izquierda;
        der = derecha;
        padre= father;
    }   
    
    /**
     * Se crea mada la referencia del nodo de la izquierda
     * @param izq
     */
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
    
    /**
     * Se crea mada la referencia del nodo de la derecha
     * @param der
     */
    
    public void setDer(Nodo der) {
        this.der = der;
    }
}
