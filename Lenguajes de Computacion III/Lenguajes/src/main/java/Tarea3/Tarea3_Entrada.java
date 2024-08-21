/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea3_Entrada {
    public static void main(String[] args) {
        try (Scanner scann = new Scanner(System.in) //Forma más rapida y efectiva de input
        ) {

            double dinero = 0, altura = 0;
            int genero = 0;

            boolean entero = false;

            //Entrada de genero
            while (!entero){
                System.out.print("\n\n¡Verifica tu entrada!\n\nIngresa tu genero (mujer = 1, hombre = 0): ");
                try {
                    genero = scann.nextInt();
                    if (genero == 0 || genero == 1){
                        entero = true;
                    } else {
                        System.out.println("Genero invalido, ingresa 1 si es mujer o ingresa 0 si es hombre");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida, debe ser un número.");
                    scann.next();
                }
            }

            entero = false;

            //Entrada de estatura
            while (!entero){
                System.out.print("\n\nIngresa tu estatura en metros: ");
                try {
                    altura = scann.nextDouble();
                    if (altura > 0 && altura <= 2.72){
                        entero = true;
                    } else {
                        System.out.println("Estatura invalida, no puedes ser más alto que el hombre más alto del mundo (2.72 m)");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida, debe ser un número positivo.");
                    scann.next();
                }
            }

            entero = false;

            //Entrada de dinero
            while (!entero){
                System.out.print("\n\nIngresa la cantidad de dinero que traes: ");
                try {
                    dinero = scann.nextDouble();
                    if (dinero >= 0){
                        entero = true;
                    } else {
                        System.out.println("Saldo invalido");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida, debe ser un número positivo.");
                    scann.next();
                }
            }

            System.out.print("\n\nTus datos:");

            //Impresion de datos
            if (genero == 1){
                System.out.print("\nEres mujer\nTu altura es de " + altura + " metros\nTraes $" + dinero);
            } else {
                System.out.print("\nEres hombre\nTu altura es de " + altura + " metros\nTraes $" + dinero);

            }

            if (genero == 1 && dinero >= 1000){
                System.out.println("\n\n¡ADELANTE CHICA!");
            } else if ( genero == 0 && dinero >= 1000 && altura >= 1.70){
                System.out.println("\n\n¡ADELANTE CHICO!");
            } else {
                System.out.println("\n\n¡Lo lamento, no puedes entrar!");
            }
        }
    }
}
