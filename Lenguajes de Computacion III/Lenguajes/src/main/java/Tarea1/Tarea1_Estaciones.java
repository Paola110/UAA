/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea1_Estaciones {
    public static void main (String[] args){
        try (Scanner scann = new Scanner(System.in) //Forma más rapida y efectiva de input
        ) {
            boolean entero = false;
            int mes = 0;

            while (!entero){
                System.out.print("\n\n¡Verificar la estacion del año!\n\nIngresa el número de mes: ");
                try {
                    mes = scann.nextInt();
                    if (mes > 0 && mes < 13){
                        entero = true;
                    } else {
                        System.out.println("Número de mes invalido");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida.");
                    scann.next();
                }
            }

            String estacion = switch (mes) {
                case 12, 1, 2 -> "invierno";
                case 3, 4, 5 -> "primavera";
                case 6, 7, 8 -> "verano";
                case 9, 10, 11 -> "otoño";
                default -> "???";
            };

            System.out.println("\nEl mes " + mes + " corresponde a la estación de " + estacion + "\n\n");
        }
    }
}
