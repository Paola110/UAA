/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea2;

import java.util.Arrays;


/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea2_Triangulos {
    public static void main (String[] args){

        double l1 = 12, l2 = 11, l3 = 12;

        System.out.print("\n\n¿Qué tipo de triangulo es?\n\n");

        if ((l1==l2) && (l3==l2)){
            System.out.print("\nEs equilatero\n");
        }else if((l1 == l2) || (l3==l2)){
            System.out.print("\nEs isoceles\n");
        } else if ( (l1 != l2) && (l3 != l2)){
            System.out.print("\nEs escaleno\n");
        }

        int[] arr = new int [10];

        arr[0] = 4; arr[1] = 13; arr[2] = 12; arr[3] = 3; arr[4] = 4;
        arr[5] = 8; arr[6] = 9; arr[7] = 11; arr[8] = 13; arr[9] = 14;

        for (int i=0; i<=9; i++){
            System.out.print(" "+arr[i]);
            System.out.println(" long "+arr.length);
            String w = new String(arr.toString());
            System.out.println(" string "+w.toString());
        }
    }
}
