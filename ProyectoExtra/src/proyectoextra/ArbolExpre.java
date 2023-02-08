
package proyectoextra;

import java.util.Stack;

/**
 * La clase permite la implementacion de un arbol de expresion por medio de la tranformacion de la cadena que se introduce, en este caso se introduce la cadena
 * posteriormenete se crea el arbol con la expresion de la cadena en postOrden, para poder facilitar la ejecucion del programa. Y posteriormente se resulve
 * la operacion que se haya insertado.
 * 
 * Tiene como composicion a la clase solucion porque con esta se puede reaizar la conversion de InOrden a PostOrden y despues resolver la operacion por medio
 * de la notacion polaca inversa.
 * @author Brain
 */
public class ArbolExpre extends ArbolBin{
    Solucion polacaS;
    
    /**
     * Metodo constructor que se define por heredar de ArbolBin, de esta forma se pueden implementar los nodos, y crear el arbol
     */
    public ArbolExpre(){
        super();
        polacaS = new Solucion();
    }
    
    /**
     * Metodo constructor que se define por heredar de ArbolBin, de esta forma se pueden implementar los nodos, y crear el arbol
     * @param root nodo que sera la raiz
     */
    public ArbolExpre(Nodo root){
        super(root);
    }
    
    /**
     * Metodo con el cual se puede crear el arbol, con esta se verifica cada uno de los caracteres de la String, con la revision de esta se va colocando 
     * en una pila. Primero se realiza la lectura de la cadena que esta en notacion PostOrden, ya que con esta forma los parentesis desaparecen, igual la
     * intente con InOrden pero no me funcionaba.
     * 
     * Una vez se lee cada uno de los caracteres se realiza la comprobacion de si es un operando u operador, cada vez que es un operando se mete a la pila,
     * y cada vez que se encuentra un operador al nodo nuevo se le agregan los hijos izq y derecho que les corresponden. Una vez asignado, se coloca de nuevo
     * de esta forma en la pila solo queda el nodo que guarda el arbol completo.
     * 
     * @param resultadoA  Cadena en PostOrden que se va a resolver
     */
    public void crearArbol(String resultadoA){
	Stack<Nodo> arbolito = new Stack<>();
	for (int i = 0; i < resultadoA.length(); i++) {
            Nodo node = new Nodo(0,null,resultadoA.charAt(i));
            switch (resultadoA.charAt(i)) {
		case '0':case '1':case '2':case '3':case '4':case '5':case '6':case '7':case '8':case '9':
                    arbolito.push(node);
                    break;
                    
		case '+':case '-':case '/':case '*':
                    node.der = arbolito.pop();
                    node.izq = arbolito.pop();
                    arbolito.push(node);
                    break;
            }
	}
        root = arbolito.pop();
    }
    
    /**
     * Metodo para el PostOrden, ya que se guarda el valor en una secciona del nodo que se llama caracter y no valor.
     * @param n nodo del cual se desea conocer la informacion
     */
    @Override
    protected void visit(Nodo n){
        System.out.println(n.operacion+" ");
    }	
}

