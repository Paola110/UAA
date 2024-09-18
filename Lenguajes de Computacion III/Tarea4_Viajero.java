/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea4;

import java.util.Random;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea4_Viajero {
    public static void main(String[] args){

        int viajeros[] = new int[10];
        String destinos [] = new String [10];
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            viajeros[i] = random.nextInt(42000 - 1500 + 1) + 1500;
            if (viajeros[i] > 40000){
                destinos[i] = "Europa";
            } else if (viajeros[i] > 25000){
                destinos[i] = "Cancun";
            } else {
                destinos[i] = "Guayabitos";
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Viajero " + (i + 1) + " ira a " + destinos[i] + " y tiene $" + viajeros[i]);
        }
    }
}
