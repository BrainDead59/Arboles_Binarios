
package proyectoextra;

import java.util.Stack;

/**
 * En esta clase se realiza el metodo que permite la transformacion del cadena que representa la expresion a resolver, se tranforma de InOrden a PostOrden
 * @author Brain
 */
public class Conversion{
    String post;
    
    /**
     * Metodo constructor para inicializar la cadena.
     */
    public Conversion(){
        post=" ";
    }
    
    /**
     * El metodo permite que se lea la expresion, para esto esta debe de estar completamente separada con los parentesis  y se debe de operar valores pares
     * , una ves esto se cumple se van colocando los operadores en una pila, y los parentesis de igual forma en la pila, de tal manera que cuando se
     * encuentra un parentesis que cierra se sacan de la pila los operadores y se colocan despues de los dos operandos que les corresponden
     * @param expresion Cadena InOrden que se transforma a PostOrden
     */
    public void conversionPost(String expresion){
        Stack<Character> pilaP = new Stack<>();
        for(int i=0;i<expresion.length();i++){
            char elemento = expresion.charAt(i);
            if(jerarquia(elemento)>0){ 
		pilaP.push(elemento);//Coloca operadores
            }
            else if(elemento==')'){ //Cierra operacion de dos operandos y se comienzan a concatener los operadores, hasta que inicia otra operacion
		char salida = pilaP.pop();
		while(salida != '('){
                    post += salida; 
                    salida = pilaP.pop();
		}
            }
            else if(elemento == '('){ //Se colocan los parentesis en la pila, para que al momento de sacar los operadores, estos limiten el numero de operaciones
		pilaP.push(elemento); 
            }
            else{ //Inserta los operandos
		post+=elemento;
            }
        }
    }

    /**
     * Permite que se determine si es un operador y permita que en la solucion de la expresion se pueda realizar la solucion de la expresion
     * @param operador caracter que se desea conocer si es un operador
     * @return valor que verifica que sea un operador
     */
    public int jerarquia(char operador){
	switch(operador){
            case '+':
            case '-':
            case '*':
            case '/':
		return 1;
	}
    return -1;
    }
}
