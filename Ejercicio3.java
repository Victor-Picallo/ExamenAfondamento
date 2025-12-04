package Examen;

import java.util.Scanner;

// Ejercicio 3.- Pedir al usuario una matriz de tamaño 2x2 uno por uno y mostrar su traspuesta, indicando a continuacion si es simetrica.

public class Ejercicio3 {

    public static void ejecutar(Scanner sc) {
        double[][] matriz = new double[2][2];

        System.out.println("\n=== Ejercicio 3: Matriz 2x2 - Traspuesta y simetría ===");
        System.out.println("Ingrese los 4 elementos de la matriz 2x2:");

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextDouble();
            }
        }

        double[][] traspuesta = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                traspuesta[i][j] = matriz[j][i];
            }
        }

        System.out.println("\nMatriz original:");
        Utiles.imprimirMatriz(matriz, 2, 2);
        System.out.println("Traspuesta:");
        Utiles.imprimirMatriz(traspuesta, 2, 2);

        boolean simetrica = true;
        for (int i = 0; i < 2 && simetrica; i++) {
            for (int j = 0; j < 2; j++) {
                if (Math.abs(matriz[i][j] - matriz[j][i]) > 1e-10) {
                    simetrica = false;
                    break;
                }
            }
        }

        System.out.println(simetrica ? "La matriz ES simétrica." : "La matriz NO es simétrica.");
    }
}
