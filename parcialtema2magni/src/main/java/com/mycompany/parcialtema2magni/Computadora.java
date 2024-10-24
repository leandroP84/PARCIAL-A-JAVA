/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialtema2magni;

/**
 *
 * @author juampi
 */
import java.util.Scanner;

public class Computadora {

    private String marca;
    private String modelo;
    private String codigoBarras; // Cambiado a String
    private double precioTotal;
    private double porcentajeAumento;
    private double montoFinal;
    private String[][] componentes;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) { // Cambiado a String
        this.codigoBarras = codigoBarras;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public double getPorcentajeAumento() {
        return porcentajeAumento;
    }

    public void setPorcentajeAumento(double porcentajeAumento) {
        this.porcentajeAumento = porcentajeAumento;
    }

    public double getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    public String[][] getComponentes() {
        return componentes;
    }

    public void setComponentes(String[][] componentes) {
        this.componentes = componentes;
    }

    public void crearMatrizComputadora(int componentesPC) {
        componentes = new String[componentesPC][4];
    }

    public void agregarComponente(int index, String codigo, String descripcion, String precio, String obligatorio) {
        componentes[index][0] = codigo;
        componentes[index][1] = descripcion;
        componentes[index][2] = precio;
        componentes[index][3] = obligatorio;
    }

    public boolean componenteYaAgregado(String codigo) {
        for (String[] componente : componentes) {
            if (componente[0] != null && componente[0].equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public void verComponente() {
        System.out.println("Componentes seleccionados:");
        for (String[] componente : componentes) {
            if (componente[0] != null) {
                System.out.println("Codigo: " + componente[0] + ", Nombre: " + componente[1] + ", Precio: $" + componente[2] + ", Obligatorio: " + componente[3]);
            }
        }
    }

    public int contarComponentesObligatorios() {
        int contador = 0;
        for (String[] componente : componentes) {
            if (componente[3].equals("S")) {
                contador++;
            }
        }
        return contador;
    }

    public void calcularMontoFinal(double totalComponentes, boolean recargoAplica) {
        double recargo = 0;
        if (recargoAplica) {
            recargo = totalComponentes * 0.20;
        }
        this.montoFinal = totalComponentes + recargo;
    }

    public void mostrarInformacion() {
        System.out.println("La computadora especificada es:");
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Codigo de Barras: " + codigoBarras);
        System.out.println("Codigo Ítem Denominación Precio");
        
        double totalComponentes = 0;
        for (String[] componente : componentes) {
            if (componente[0] != null) {
                System.out.println(componente[0] + " " + componente[1] + " " + componente[2]);
                totalComponentes += Double.parseDouble(componente[2]); // Sumar precios
            }
        }

        boolean recargoAplica = contarComponentesObligatorios() < 5;
        calcularMontoFinal(totalComponentes, recargoAplica);

        System.out.println("Total Componentes: " + totalComponentes);
        System.out.println("Recargo: " + (recargoAplica ? totalComponentes * 0.20 : 0));
        System.out.println("Monto Final: " + montoFinal);
    }
}


