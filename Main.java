package Examen;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;

        while (seguir) {
            System.out.println("\n=== EXAMEN ===");
            System.out.println("1. Inversa matriz 4x4");
            System.out.println("2. Resolver sistema ecuaciones");
            System.out.println("3. Traspuesta y simetría 2x2");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            int opcion = sc.nextInt();

            if (opcion == 1) {
                Ejercicio1.ejecutar(sc);
            } else if (opcion == 2) {
                Ejercicio2.ejecutar(sc);
            } else if (opcion == 3) {
                Ejercicio3.ejecutar(sc);
            } else if (opcion == 0) {
                seguir = false;
            } else {
                System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
