package Examen;

import java.util.Scanner;

// Ejercicio 1.- Pedir al usuario una matriz 4x4 uno por uno y calcular su inversa.

public class Ejercicio1 {

    public static void ejecutar(Scanner sc) {
        double[][] matriz = new double[4][8];

        System.out.println("=== Ejercicio 1: Inversa de matriz 4x4 ===");
        System.out.println("Ingrese los 16 elementos de la matriz 4x4:");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j + 4] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Gauss-Jordan para inversa
        for (int i = 0; i < 4; i++) {
            int maxRow = i;
            for (int k = i + 1; k < 4; k++) {
                if (Math.abs(matriz[k][i]) > Math.abs(matriz[maxRow][i])) {
                    maxRow = k;
                }
            }

            double[] temp = matriz[i];
            matriz[i] = matriz[maxRow];
            matriz[maxRow] = temp;

            double pivote = matriz[i][i];
            if (Math.abs(pivote) < 1e-10) {
                System.out.println("La matriz no tiene inversa (es singular).");
                return;
            }
            for (int j = 0; j < 8; j++) {
                matriz[i][j] /= pivote;
            }

            for (int k = 0; k < 4; k++) {
                if (k != i) {
                    double factor = matriz[k][i];
                    for (int j = 0; j < 8; j++) {
                        matriz[k][j] -= factor * matriz[i][j];
                    }
                }
            }
        }

        System.out.println("\nMatriz inversa:");
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j < 8; j++) {
                System.out.printf("%.3f ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}
