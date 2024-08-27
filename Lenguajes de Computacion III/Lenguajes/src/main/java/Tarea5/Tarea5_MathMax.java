
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

package Tarea5;

/**
 *
 * @author Paola Montserrat Osorio García
 */

public class Tarea5_MathMax {

   public static int maximo(int a, int b) {
        if ( a > b ){
            return a;
        }else{
            return b;
        }
    }

   public  int maximo2(int a, int b) {
        if ( a > b ){
            return a;
        }else{
            return b;
        }
    }
    public static void main(String[] args) {
        int a1=12, a3=11, a4=20, a5=12, a6=14;

        int b = Math.max( Math.max(a6, a1), Math.max(a3, a4) ) ;
        int c = Math.max(b, Math.max (a5,a6) );

        System.out.println("El numero mayor "+ c);

        int e = maximo(a4, a3);

        System.out.println("El numero mayor "+ e);

        Tarea5_MathMax obj = new Tarea5_MathMax();

        int f= obj.maximo2(a5,a6);

        System.out.println("El numero mayor "+ f);
    }
}
