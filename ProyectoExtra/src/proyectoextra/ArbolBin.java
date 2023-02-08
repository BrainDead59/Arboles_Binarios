
package proyectoextra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase que permite que las variantes hereden de esta, aunque no puede implementarla al cien por ciento, es una buena plantilla para conocer los metodos
 * y despues implementarlos
 * @author Brain
 */
public class ArbolBin {
    Nodo root;
    
    /**
     * Arbol por defecto
     */
    public ArbolBin(){
        root=null;
    }
    
    /**
     * Arbol que crea solo la raiz con el valor dado
     * @param val
     * @param operacion
     */
    public ArbolBin(int val,char operacion){
        root=new Nodo(val,null,operacion);
    }
    
    /**
     * Arbol que crea solo la raiz con el nodo raiz
     * @param root
     */
    public ArbolBin(Nodo root){
        this.root=root;
    }
    
    /**El metodo toma el valor del lado para colocar el hijo
     * @param padre
     * @param hijo
     * @param lado
     */
    public void add(Nodo padre, Nodo hijo, int lado){
	if(lado==0)
            padre.setIzq(hijo);
	else
            padre.setDer(hijo);
    }
    
    /**
     * Metodo que agrega los nodos, en base a las busquedaIzq Y busquedaDer
     * @param dato
     * @return 
     */
    public Nodo agregarNodo(int dato){
        Scanner entrada = new Scanner(System.in);
        if(root==null){
            Nodo nuevo =new Nodo(dato,null,'a');
            root=nuevo;
        }else{
            System.out.println("Insertar a partir de que lado de la raiz: \n0)Izquierda \n1)Derecha");
            int ladoA=entrada.nextInt();
            if(ladoA==1){
                Nodo nodoA = busquedaDer();//Se dirige al nodo mas derecho posible, a partir de la raiz
                System.out.println(nodoA.valor+" ");
                return nodoA;
            }
            if(ladoA==0){
                Nodo nodoA = busquedaIzq();//Se dirige al nodo mas izquierdo posible, a partir de la raiz
                System.out.println(nodoA.valor+" ");
                return nodoA;
            }
        }
        return null;
    }
    
    protected void visit(Nodo n){
        System.out.println(n.valor+" ");
    }	
    
    /**
     * Busqueda profunda por medio del nodo
     */
    public void breadthFrist(){
        Nodo r = root;
	Queue<Nodo> queue = new LinkedList();
	if(r!=null){
            queue.add(r);
            while(!queue.isEmpty()){
                r = (Nodo)queue.poll();
		visit(r);
		if(r.izq!=null)
                    queue.add(r.izq);
		if(r.der!=null)
                    queue.add(r.der);
            }
	}
    }
    
    /**
     * Busca los valores y regresa un booleano para indicar si existe o no
     * @param valor
     * @return 
     */
    public boolean busqueda(int valor){
        Nodo buscar = root;
	Queue<Nodo> queue = new LinkedList();
	if(buscar!=null){
            queue.add(buscar);
            while(!queue.isEmpty()){
                buscar = (Nodo)queue.poll();
                if(buscar.valor==valor){
                    return true;
                }
		if(buscar.izq!=null)
                    queue.add(buscar.izq);
		if(buscar.der!=null)
                    queue.add(buscar.der);
            }
	}
        return false;
    }
    
    /**
     * Busca sobre la rama izquierda de la raiz
     * @return 
     */
    public Nodo busquedaIzq(){
        Nodo izquierda = root;
        Queue<Nodo> queue = new LinkedList();
        if(izquierda!=null){
            queue.add(izquierda);
            while(!queue.isEmpty()){
                izquierda = (Nodo)queue.poll();
                if(izquierda.izq!=null){
                    queue.add(izquierda.izq);
                }else{
                    return izquierda;
                }
            }
        }
        return null;
    }
    
    
    /**
     * Busca el padre origen del nodo que se envie, es decir busca la raiz, para regresarla
     * @param base
     * @return 
     */
    public Nodo busquedaInv(Nodo base){
        Nodo izquierda = base;
        Queue<Nodo> queue = new LinkedList();
        if(izquierda!=null){
            queue.add(izquierda);
            while(!queue.isEmpty()){
                izquierda = (Nodo)queue.poll();
                if(izquierda.padre!=null){//Esta es la opcion mas importante que permite encontrar el padre del padre
                    queue.add(izquierda.padre);
                }else{
                    return izquierda;
                }
            }
        }
        return null;
    }
    
    /**
     * Busca sobre la rama derecha de la raiz
     * @return 
     */
    public Nodo busquedaDer(){
        Nodo derecha = root;
        Queue<Nodo> queue = new LinkedList();
        if(derecha!=null){
            queue.add(derecha);
            while(!queue.isEmpty()){
                derecha = (Nodo)queue.poll();
                if(derecha.der!=null){
                    queue.add(derecha.der);
                }else{
                    return derecha;
                }
            }
        }
        return null;
    }
    
    /**
     * Metodo de eliminacion de los nodos, donde se indica el valor del nodo a eliminar, en base a como se forma el arbol, donde la forma en que se 
     * construye no corresponde a algo ideal
     * @param valor
     * @return 
     */
    public ArbolBin eliminacionNodo(int valor){
        Nodo regreso= root;
        ArbolBin retorno;
        if(regreso==null){
            System.out.println("Arbol vacio");
        }else{
            if(regreso.valor==valor){//Considera el caso de que sea raiz
                if(regreso.izq==null){
                    regreso=regreso.der;
                    retorno = new ArbolBin(regreso);
                    return retorno;
                }  
                if(regreso.der==null){
                    regreso=root.izq;
                    retorno = new ArbolBin(regreso);
                    return retorno;
                }
                //Si existen referencias de derecha e izquierda
                if(regreso.der!=null && regreso.izq!=null){
                    Nodo izquierda = busquedaIzq();
                    izquierda.izq=regreso.der;
                    regreso=regreso.izq;
                    retorno = new ArbolBin(regreso);
                    return retorno;
                }
                
            }else{
                Nodo busqueda = root;
                Queue<Nodo> queueHijos = new LinkedList();
                if(root!=null){
                    queueHijos.add(busqueda);
                    while(!queueHijos.isEmpty()){
                        busqueda = (Nodo)queueHijos.poll();
                        if(busqueda.valor==valor){
                            System.out.println("Se rompio:"+busqueda.valor);
                            break;
                        }
                        if(busqueda.izq!=null){
                            queueHijos.add(busqueda.izq);
                        }
                        if(busqueda.der!=null){
                            queueHijos.add(busqueda.der);
                        }
                    }
                }
                Nodo padre;
                if(busqueda.der==null && busqueda.izq==null){//Nodo sin hijos - hoja
                    if(busqueda.padre.der==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.izq=null;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    if(busqueda.padre.izq==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.der=null;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    if(busqueda.padre.der!=null && busqueda.padre.izq!=null){
                        if(busqueda.padre.der.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.der=null;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                        if(busqueda.padre.izq.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.izq=null;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                    }
                }
                
                if(busqueda.izq==null){ //Nodo con un hijo derecho
                    if(busqueda.padre.der==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.izq=busqueda.der;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    
                    if(busqueda.padre.izq==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.der=busqueda.der;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    if(busqueda.padre.der!=null && busqueda.padre.izq!=null){
                        if(busqueda.padre.der.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.der=busqueda.der;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                        if(busqueda.padre.izq.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.izq=busqueda.der;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                    }
                }
                
                if(busqueda.der==null){ //Nodo con un hijo izquierdo
                    if(busqueda.padre.der==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.izq=busqueda.izq;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    
                    if(busqueda.padre.izq==null){
                        padre=busquedaInv(busqueda);
                        busqueda.padre.der=busqueda.izq;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    if(busqueda.padre.der!=null && busqueda.padre.izq!=null){
                        if(busqueda.padre.der.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.der=busqueda.izq;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                        if(busqueda.padre.izq.valor==busqueda.valor){
                            padre=busquedaInv(busqueda);
                            busqueda.padre.izq=busqueda.izq;
                            retorno = new ArbolBin(padre);
                            return retorno;
                        }
                    }
                }
                //Referencia a los dos hijos
                if(busqueda.izq!=null && busqueda.der!=null){
                    if(busqueda.padre.der.valor==busqueda.valor){
                        padre=busquedaInv(busqueda);
                        busqueda.izq.izq=busqueda.der;
                        busqueda.padre.der=busqueda.izq;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                    if(busqueda.padre.izq.valor==busqueda.valor){
                        padre=busquedaInv(busqueda);
                        busqueda.der.der=busqueda.izq;
                        busqueda.padre.izq=busqueda.der;
                        retorno = new ArbolBin(padre);
                        return retorno;
                    }
                }
            }
        }
        return null;
   }
    
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            visit(raiz);
            preOrden(raiz.izq);
            preOrden(raiz.der);
        }
    }
    
    public void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.izq);
            visit(raiz);
            inOrden(raiz.der);
        }
    }
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.izq);
            postOrden(raiz.der);
            visit(raiz);
        }
    }

}
