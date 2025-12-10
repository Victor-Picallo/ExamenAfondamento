package Examen;

import java.util.Scanner;

// Ejercicio 1.- Pedir al usuario una matriz de tamaño 4x4 y calcular su inversa

public class Ejercicio1 {

    public static void ejecutar(Scanner sc) {
        // Se crea una matriz aumentada 4x8
        double[][] matriz = new double[4][8];

        System.out.println("=== Ejercicio 1: Inversa de matriz 4x4 ===");
        System.out.println("Ingrese los 16 elementos de la matriz 4x4:");

        // Lee la matriz 4x4 elemento a elemento desde el Scanner
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                // almacena A[i][j] en la parte izquierda
                matriz[i][j] = sc.nextDouble();
            }
        }

        // Agrega la matriz identidad a la derecha de la aumentada
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Si estamos en la diagonal ponemos 1.0, si no 0.0
                matriz[i][j + 4] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Aplicamos Gauss-Jordan para encontrar la inversa.
        for (int i = 0; i < 4; i++) {
            // Pivoteo parcial
            int maxRow = i;
            for (int k = i + 1; k < 4; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxRow][i])) {
                    maxRow = k;
                }
            }

            // Intercambia la fila actual i con la fila maxRow
            // Evita dividir por valores muy pequeños.
            double[] temp = matriz[i];
            matriz[i] = matriz[maxRow];
            matriz[maxRow] = temp;

            // Ahora esta posicion debería ser el mejor candidato a pivote.
            double pivote = matriz[i][i];
            // Si el pivote es cero la matriz no tiene inversa.
            if (Math.abs(pivote) < 1e-10) {
                System.out.println("La matriz no tiene inversa (es singular).");
                return;
            }

            // Divide toda la fila por el valor del pivote
            // para que la entrada quede en 1.
            for (int j = 0; j < 8; j++) {
                matriz[i][j] /= pivote;
            }

            // Elimina la columna i en todas las demás filas
            // restando un múltiplo de la fila pivote. Al final tendremos la identidad
            // en las 4 primeras columnas y la inversa en las 4 últimas.
            for (int k = 0; k < 4; k++) {
                if (k != i) {
                    double factor = matriz[k][i]; // lo que hay en la columna i de la fila k
                    for (int j = 0; j < 8; j++) {
                        // resta factor * fila_pivote a la fila k
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }

        // Imprime la matriz inversa
        System.out.println("\nMatriz inversa:");
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j < 8; j++) {
                // Formateamos cada elemento con 3 decimales
                System.out.printf("%.3f ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
