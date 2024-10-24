
package javaapplication10;

import java.util.Scanner;

public class JavaApplication10 {
    public static void main(String[] args) {
        //Pida al usuario la dimensión de la matriz que se llenará. Valide que la dimensión ingresada
        //sea un número impar entre 3 y 15, caso contrario solicite nuevamente el valor 
        int X,contador, i, e;
        String opcion;
        contador = 0;
        Scanner sc = new Scanner (System.in); 
        do{
            do{
                System.out.println("Ingrese la dimension de la matriz multidimensional: ");
                X = Integer.parseInt(sc.nextLine());
                if (X % 2 != 0){               
                    contador = 1;
                }
            }while(contador != 1);
            //Cree la matriz con el tamaño indicado, complete únicamente la última fila de la matriz de
            //forma manual con valores enteros no nulos solicitados al usuario, distintos a cero, entre 10
            //y 99. Valide que los números cumplan con el rango indicado caso contrario solicite el
            //numero nuevamente. El resto de las filas deberá completarse usando la función Random
            //para la generación de números aleatorios, también en el rango de 10 a 99
            int [][] matriz = new int[X][X];
            for (i = X-1; i < X; i++){
                for (e = 0; e < X; e++){
                    System.out.println("Ingrese elumero de la matriz " + i + "," + e );
                    do{
                        matriz[i][e] = Integer.parseInt(sc.nextLine());
                        if (matriz[i][e] <= 9 || matriz[i][e] >= 100){
                            System.out.println("Solo puede ingresar un numero en el rango de 10 a 99");
                            System.out.println("Vuelva a ingresar el numero de la matriz " + i + "," + e);
                        }
                    } while (matriz[i][e] <= 9 || matriz[i][e] >= 100);
                }
            }
            System.out.println("A continuacion se rellena la Matriz con numeros aleatorios:");
            for (i = 0; i < X-1; i++){
                for (e = 0; e < X; e++){
                    do{    
                        System.out.println("Numero de la matriz" + i + "," + e);
                        matriz[i][e] = (int)(Math.random() * (99 - 10) + 10);
                        System.out.println(matriz[i][e]);
                    } while (matriz[i][e] <= 9 || matriz[i][e] >= 100);        
                }
            }
            //Muestre por pantalla la matriz resultante del paso 2 
            System.out.println("Matriz Bidimensional: ");
            for (i = 0; i < X; i++){
                for (e = 0; e < X; e++){
                System.out.print(matriz[i][e] + " ");    
                }    
                System.out.println(" ");    
            }        
            // Cree una función/método “obtenerValoresCentrales” que obtenga el valor central de la
            //matriz y los valores colindantes al centro de la matriz y los asigne en una matriz de 1
            //dimensión, retorne la matriz obtenida 20%
            //public int[] obtenerValoresCentrales(int[][] matriz){
            //}
            //Ejecute la función “obtenerValoresCentrales” y muestre por pantalla la matriz resultante
            //del paso 4
            System.out.println("Matriz con los valores Centrales:");
            int [] resultado = obtenerValoresCentrales(X, matriz);
            for (i = 0; i<9; i++){
                System.out.print(resultado[i] + ",");
            }
            System.out.println(" ");
            System.out.println("Matriz con los valores centrales de menor a mayor:");
            //Ordene la matriz obtenida en el paso 4 de menor a mayor, aplicando método de la burbuja
            boolean intercambio;
            do{
                intercambio = false;
                for ( i = 1; i < 9; i++) {
                    //si el par no está ordenado
                    if (resultado[i - 1] > resultado[i])
                    { //lo intercambiamos y recordamos que algo ha cambiado
                        int aux = resultado[i - 1];
                        resultado[i - 1] = resultado[i];
                        resultado[i] = aux;
                        intercambio = true;
                    }
                }
            } while (intercambio == true);
            for (int r = 0; r < 9; r++){
                System.out.print(resultado[r] + ",");
            }
            System.out.println(" ");
            //Cree una función “calcularPromedioDeMatrices” que reciba como parámetros la matriz
            //resultante en el paso 2 y la matriz resultante del paso 4, calcule el promedio de cada una de
            //las matrices, muestre los resultados por pantalla (suma total, cantidad de elementos y
            //promedio) y retorne finalmente el promedio de los 2 resultados calculados. 20%
            //public double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
            //}
            System.out.println("Suma total, cantidad de elementos y promedio de ambas matrices: ");
            calcularPromedioDeMatrices(matriz, resultado);
            
            System.out.println("Desea iniciar nuevamente la ejecución del programa? SI/NO");            
            opcion = sc.nextLine();
        }while(opcion.equalsIgnoreCase("SI"));        
    }
    public static int[] obtenerValoresCentrales(int a,int [][] matriz){
        int centro = (int) a/2;
        int[] matrizUni = new int[9];
        int r = 1;
        for (int i = (centro-1); i < (centro+2); i++){
            for (int e = (centro-1); e < (centro+2); e++){
                if(i == centro && e == centro){
                    matrizUni[0] = matriz[i][e];
                }else{
                    matrizUni[r] = matriz[i][e];
                    r++;
                }
            }
        }
        return matrizUni;
    }
    public static double calcularPromedioDeMatrices (int[][] matriz, int[] matrizValoresCentral){
        int i, e, r, sumaMat, cantElemMat, sumaValCen, cantElemValCen;
        double promMa, promValCen;
        sumaMat = 0;
        cantElemMat = 0;
        promMa = 0;
        sumaValCen = 0;
        cantElemValCen = 0;
        promValCen = 0;
        for (i = 0; i < matriz.length; i++){
            for (e = 0; e < matriz.length; e++){
                sumaMat += matriz[i][e];
                cantElemMat ++;
            }
        }
        promMa = sumaMat / ((double) cantElemMat);
        for (r = 0; r < matrizValoresCentral.length; r++){
            sumaValCen += matrizValoresCentral[r];
            cantElemValCen ++;
        }
        promValCen = sumaValCen / ((double)cantElemValCen);
        System.out.println("La suma total de la matriz es: " + sumaMat + " La cantidad de elementos es de: " + cantElemMat + " El promedio es de: " + promMa);
        System.out.println("La suma total de la matriz con valores centrales es: " + sumaValCen + " La cantidad de elementos es de: " + cantElemValCen + " El promedio es de: " + promValCen);
        System.out.println("El promedio de: " + promMa + " y " + promValCen + " es: " + (promMa + promValCen) / 2.0);
        return promMa;
    }
    
}
