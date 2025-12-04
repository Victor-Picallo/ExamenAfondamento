package Examen;

// Ejercicio 2.- Pedir al usuario los coeficientes de las variables y terminos independientes para resolver un sistema de ecuaciones.

import java.util.Scanner;

public class Ejercicio2 {

    public static void ejecutar(Scanner sc) {
        System.out.println("\n=== Ejercicio 2: Sistema de ecuaciones ===");
        System.out.print("Número de ecuaciones/variables (2-4): ");
        int n = sc.nextInt();

        double[][] A = new double[n][n];
        double[] B = new double[n];

        System.out.println("Ingrese coeficientes de la matriz A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Ingrese términos independientes B:");
        for (int i = 0; i < n; i++) {
            System.out.print("B[" + i + "]: ");
            B[i] = sc.nextDouble();
        }

        // Eliminación gaussiana
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int k = i + 1; k < n; k++) {
                if (Math.abs(A[k][i]) > Math.abs(A[max][i])) {
                    max = k;
                }
            }

            double[] tempA = A[i];
            A[i] = A[max];
            A[max] = tempA;
            double tempB = B[i];
            B[i] = B[max];
            B[max] = tempB;

            if (Math.abs(A[i][i]) < 1e-10) {
                System.out.println("El sistema puede no tener solución única (pivote cero).");
                return;
            }

            for (int k = i + 1; k < n; k++) {
                double factor = A[k][i] / A[i][i];
                B[k] -= factor * B[i];
                for (int j = i; j < n; j++) {
                    A[k][j] -= factor * A[i][j];
                }
            }
        }

        double[] sol = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            sol[i] = B[i];
            for (int j = i + 1; j < n; j++) {
                sol[i] -= A[i][j] * sol[j];
            }
            sol[i] /= A[i][i];
        }

        System.out.println("\nSolución:");
        for (int i = 0; i < n; i++) {
            System.out.printf("x%d = %.3f\n", i + 1, sol[i]);
        }
    }
}
