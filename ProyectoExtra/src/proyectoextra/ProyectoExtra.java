
package proyectoextra;

import java.util.Scanner;

/**
 * En esta clase se lleva a cabo el metodo principal de proyecto por el cual se puede escojer cual de los arboles se desea trabajar, de acuerdo al tipo de
 * arbol se realiza un instancia de este y se despliega un pequeño menu con la opciones.
 * @author Brain
 */
public class ProyectoExtra {
    
/**
 * Por medio de este metodo se pueden trabajar cada uno de los arboles, no todas las implementaciones estan totalmente relacionadas con la forma de un tree
 * pero si siguen las reglas de como se deben implementar, ese es el caso del heap, donde se debe de considerar que las posiciones de los nodos hijos y padres.
 * @param args 
 */ 
public static void main(String args[]){
    Scanner entrada = new Scanner(System.in);
    ArbolBinBusq arbolB;
    Heap heap;
    int opcionA;
    do{
        System.out.println("Inserta con que tipo de arbol quieres trabajar: \n1)Heap \n2)Arboles Binarios de busqueda \n3)Arbol de Expresion \n4)Salir ");
        opcionA = entrada.nextInt();
        switch(opcionA){
            case 1:
                heap = new Heap();
                int opcionH,valorH;
                do{
                    System.out.print("\nSelecciona una opcion: \n1)Insertar valor \n2)Eliminar raiz \n3)Imprimir \n4)Salir \n");
                    opcionH=entrada.nextInt();
                    switch(opcionH){
                        case 1:
                            System.out.print("\nInserta el valor:");
                            valorH=entrada.nextInt();
                            heap.insertar(valorH);
                            System.out.println(heap);
                            break;

			case 2:
                            System.out.print("\nEliminando Raíz:");
                            int maximo = heap.eliminar();
                            System.out.println("Raiz eliminada:"+maximo);
                            System.out.println(heap);
                            break;

			case 3:
                            System.out.print("\nHeap:");
                            System.out.print("Arbol:"+heap.toString());
                            break;

			default:
                            opcionH=4;
                            break;

                    }
                }while(opcionH<4);
                break;
                        
            case 2:
                arbolB = new ArbolBinBusq();
                System.out.println("Arbol:Binario de busqueda");
                int opcionX = 0;
                do{
                    System.out.println("Inserta las opciones para tu arbol: \n1)Agregar Nodo \n2)Eliminar nodo \n3)Buscar \n4)Imprimir Arbol \n5)Salir \n");
                    opcionX=entrada.nextInt();
                    switch(opcionX){
                        case 1:
                            System.out.println("Inserta el valor del nodo:");
                            int valor = entrada.nextInt();
                            arbolB.agregarNodoBusq(valor);
                            break;
                                
                        case 2:
                            System.out.println("Inserta el valor del nodo:");
                            int eliminar = entrada.nextInt();
                            arbolB.eliminarNodo(eliminar);
                            break;
                                
                        case 3:
                            System.out.println("Inserta el valor del nodo:");
                            int buscar = entrada.nextInt();
                            int regreso = arbolB.buscarNodo(buscar);
                            if(regreso==0){
                                System.out.println("El valor no existe en el arbol"); 
                            }else{
                                System.out.println("El valor existe en el arbol"); 
                            }
                            break;
                                
                        case 4:
                            System.out.println("Arbol");
                            arbolB.breadthFrist();
                            break;
                                
                        default:
                           opcionX=5;
                    }
                }while(opcionX<5);
                break;
                    
            case 3:
                ArbolExpre arbolE = new ArbolExpre();
                int opcionE;
                do{
                    System.out.print("\nSelecciona una opcion: \n1)Insertar expresion \n2)Mostrar arbol \n3)Resolver expresion \n4)Salir \n");
                    opcionE=entrada.nextInt();
                    switch(opcionE){
                        case 1:
                            System.out.println("Ingresa la expresion a resolver");
                            String expresion = entrada.next(); // ((((5+3)*(2+5))/6)*4)
                            arbolE.polacaS.conversionPost(expresion);
                            break;
                            
			case 2:
                            System.out.println("Arbol:");
                            arbolE.crearArbol(arbolE.polacaS.post);
                            arbolE.postOrden(arbolE.root);
                            break;

			case 3:
                            arbolE.polacaS.resolver(arbolE.polacaS.post);
                            System.out.print("\nSolucion:"+arbolE.polacaS.resultado);
                            break;
                            
			default:
				opcionE=4;
				break;

                    }
                }while(opcionE<4);
                break;
                    
                default:
                    opcionA=4;
                    break;
        }
    }while(opcionA<4);    
}
}
