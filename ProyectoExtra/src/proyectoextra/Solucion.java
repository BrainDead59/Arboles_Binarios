
package proyectoextra;
import java.util.Stack;

/**
 * Por medio de este metodo se resuelve la polaca inversa, por medio de la expresion que se guarda en conversion, ya que al hereda de la clase se puede
 * acceder al atributo de conversion, y ejecutar los metodos desde la instancia de solucion qeu esta en la clase ArbolExpre.
 * @author Brain
 */
public class Solucion extends Conversion{
    double resultado;
    
    /**
     * Con el metodo se lleva a cabo la ejecucion de la resolucion de la polaca inversa con el uso de una pila.
     * Primero se crea la pila, despues se verifica caracter a caracter la expresion PostOrden, y despues se comprueba que el valor sea un operador, en caso
     * de que los sea se sacan de la pila los dos operandos y se realiza la operacion que se define abajo, en base a esto se vuelve a guardar el valor y 
     * al final se van operando de dos terminos en dos terminos
     * 
     * @param expresion cadena con la cual se va a operar para obtener el valor
     */
    public void resolver(String expresion){
	Stack<Double> pilaR = new Stack<>();
	for(int i=0;i<expresion.length();i++){
            char elemento = expresion.charAt(i);
            if(jerarquia(elemento) > 0){ //Se cumple cuando es un operador
		double op1 = pilaR.pop();
		double op2 = pilaR.pop();
		double resul = operacion(op1,op2,elemento);
		pilaR.push(resul);
            }
            else{
		pilaR.push((double)(elemento-'0')); //Se guarda cuando es un operando 
            }
	}
	resultado = pilaR.pop(); // Ultiom valor que es el resultado de todas las operaciones
    }

    /**
     * Por medio del metodo se realiza la operacion de los valores que se insertan a los nodos, y despues se regresa el valor que corresponde
     * @param op1 operando numero uno
     * @param op2 operando numero dos
     * @param operador operador para realizar la operacion
     * @return  valor resultado de la operacion
     */
    public Double operacion(double op1, double op2, char operador){
	switch(operador){
            case '+':
		return op2 + op1;
            case '-':
		return op2 - op1;
            case '*':
		return op1 * op2;
            case '/':
		return op2 / op1;
	}
        return 0.0;
    }
}