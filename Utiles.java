package Examen;

// Clase Utiles con método para imprimir matrices para no tener que repetir código

public class Utiles {

    public static void imprimirMatriz(double[][] matriz, int filas, int cols) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%.3f ", matriz[i][j]);
            }
            System.out.println();
        }
    }
}