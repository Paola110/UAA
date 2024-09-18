/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea2;


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
    }
}
