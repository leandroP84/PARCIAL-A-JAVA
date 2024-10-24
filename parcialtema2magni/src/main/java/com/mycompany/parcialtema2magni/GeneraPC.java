/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialtema2magni;

import java.util.Scanner;

public class GeneraPC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array de componentes predefinido
        String[][] componentesPc = {
            {"AAA", "Placa Madre", "20000", "S"}, {"BBB", "Procesador", "25000", "S"},
            {"CCC", "Memoria RAM", "5000", "S"}, {"DDD", "Placa de Red", "3000", "N"},
            {"EEE", "Disco Rigido SSD", "22000", "S"}, {"FFF", "Placa de Video", "42000", "N"},
            {"GGG", "Monitor Led 21", "32000", "N"}, {"HHH", "Monitor Led 25", "41000", "N"},
            {"JJJ", "Kit Teclado - Mouse", "9000", "N"}, {"KKK", "Gabinete", "6500", "S"},
            {"LLL", "Fuente Alimentación", "6500", "S"}, {"MMM", "Placa de Sonido", "16500", "N"}
        };

        // Crear la computadora
        Computadora pc = new Computadora();
        
        // Pedir marca y modelo de la computadora
        System.out.println("Ingrese la marca de la computadora:");
        pc.setMarca(scanner.nextLine());
        
        System.out.println("Ingrese el modelo de la computadora:");
        pc.setModelo(scanner.nextLine());

        // Ingresar el código de barras como String
        System.out.println("Ingrese el código de barras (entre 7 y 15 caracteres):");
        String codigoBarras = scanner.nextLine();
        pc.setCodigoBarras(codigoBarras);
        
        // Pedir la cantidad de componentes a agregar
        int cantidadComponentes;
        do {
            System.out.println("Ingresa la cantidad de componentes (entre 5 y 12):");
            cantidadComponentes = scanner.nextInt();
        } while (cantidadComponentes < 5 || cantidadComponentes > 12);
        
        // Inicializar la matriz de componentes en la computadora
        pc.crearMatrizComputadora(cantidadComponentes);

        // Solicitar los componentes
        for (int i = 0; i < cantidadComponentes; i++) {
            String codigoComponente;
            
            System.out.println("Ingrese el codigo del componente:");
            codigoComponente = scanner.next();

            // Buscar el código ingresado en el array componentesPc
            int indexComponente = -1;
            for (int j = 0; j < componentesPc.length; j++) {
                if (componentesPc[j][0].equals(codigoComponente)) {
                    indexComponente = j;
                    break;
                }
            }

            // Agregar el componente si es válido
            if (indexComponente != -1) {
                pc.agregarComponente(i, componentesPc[indexComponente][0], componentesPc[indexComponente][1], componentesPc[indexComponente][2], componentesPc[indexComponente][3]);
            }
        }

        // Mostrar los componentes seleccionados
        pc.verComponente();

        // Calcular el total y mostrar la computadora
        double totalComponentes = 0; // Variable para el total de componentes
        boolean recargoAplica = pc.contarComponentesObligatorios() < 5;
        
        for (int i = 0; i < cantidadComponentes; i++) {
            totalComponentes += Double.parseDouble(pc.getComponentes()[i][2]);
        }

        double recargo = 0;
        if (recargoAplica) {
            recargo = totalComponentes * 0.20;
        }
        
        double montoFinal = totalComponentes + recargo;

        // Imprimir resultados finales
        System.out.println("La computadora especificada es:");
        System.out.println("Marca: " + pc.getMarca());
        System.out.println("Modelo: " + pc.getModelo());
        System.out.println("Codigo de Barras: " + pc.getCodigoBarras());
        System.out.println("Codigo Item  Denominacion               Precio");
        for (int i = 0; i < cantidadComponentes; i++) {
            System.out.printf("%s\t%s\t%s\n", pc.getComponentes()[i][0], pc.getComponentes()[i][1], pc.getComponentes()[i][2]);
        }
        System.out.println("Total Componentes: " + totalComponentes);
        System.out.println("Recargo: " + recargo);
        System.out.println("Monto Final: " + montoFinal);
        
        scanner.close();
    }
}
