package tarea2;
 
import java.util.Scanner;
/*
*FIUSAC-Ingenieria en Ciencias y Sistemas
*Laboratorio de Introduccion para la Programacion de Computacion 1
Seccion:F
Tarea 2
*/
public class Tarea2 {
 
    static Scanner sc = new Scanner(System.in);
 
    public static void main(String[] args) {
 
        int cantidadDatos;
        double promedio;
        char inicialEjercicio = 'T';
        boolean programaFinalizado = false;
 
        System.out.println("Tarea 2: Fundamentos de Java");
        System.out.println("Ejercicio identificado con la letra: " + inicialEjercicio);
 
        cantidadDatos = leerEnteroValidado(" ¿Cuantos numeros desea ingresar para el arreglo?  (1-20):  ", 1, 20);
 
        int[] arreglo = llenarArreglo1D(cantidadDatos);
        procesarArreglo1D(arreglo);
 
        int filas = leerEnteroValidado("\n¿Cuantas filas tendra la matriz? (1-10): ", 1, 10);
        int columnas = leerEnteroValidado("¿Cuantas columnas tendra la matriz? (1-10): ", 1, 10);
        int[][] matriz = llenarMatriz2D(filas, columnas);
        procesarMatriz2D(matriz);
 
        programaFinalizado = true;
        if (programaFinalizado) {
            System.out.println("\nPrograma finalizado correctamente.");
        }
        sc.close();
    }
 
    static int leerEnteroValidado(String mensaje, int min, int max) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Error: el valor debe estar entre " + min + " y " + max + ". Intente de nuevo.");
                }
            } else {
                System.out.println("Error: debe ingresar un numero entero (no texto). Intente de nuevo.");
                sc.next();
            }
        }
        return valor;
    }
 
    static int[] llenarArreglo1D(int cantidad) {
        int[] datos = new int[cantidad];
        System.out.println("\n--Ingreso de datos para el arreglo (1 dimension)--");
        for (int i = 0; i < cantidad; i++) {
            datos[i] = leerEnteroValidado("Ingrese el numero " + (i + 1) + " (entre 1 y 100): ", 1, 100);
        }
        return datos;
    }
 
    static void procesarArreglo1D(int[] datos) {
        int maximo = datos[0];
        int minimo = datos[0];
        int suma = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > maximo) {
                maximo = datos[i];
            }
            if (datos[i] < minimo) {
                minimo = datos[i];
            }
            suma += datos[i];
        }
        double promedio = (double) suma / datos.length;
        System.out.println("\n--Resultados del arreglo 1D--");
        System.out.print("Datos ingresados: ");
        for (int dato : datos) {
            System.out.print(dato + " ");
        }
        System.out.println();
        System.out.println("Máximo: " + maximo);
        System.out.println("Mínimo: " + minimo);
        System.out.println("Promedio: " + promedio);
    }
 
    static int[][] llenarMatriz2D(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        System.out.println("\n--- Ingreso de datos para la matriz (2 dimensiones) ---");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String mensaje = "Ingrese el valor para la posición [" + i + "][" + j + "] (entre 1 y 50): ";
                matriz[i][j] = leerEnteroValidado(mensaje, 1, 50);
            }
        }
        return matriz;
    }
 
    static void procesarMatriz2D(int[][] matriz) {
        System.out.println("\n--- Resultados de la matriz 2D ---");
        int sumaTotal = 0;
 
        for (int i = 0; i < matriz.length; i++) {
            int sumaFila = 0;
            System.out.print("Fila " + i + ": ");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
                sumaFila += matriz[i][j];
            }
            System.out.println(" -> Suma de la fila: " + sumaFila);
            sumaTotal += sumaFila;
        }
 
        System.out.println("Suma total de todos los elementos de la matriz: " + sumaTotal);
    }
}
 

