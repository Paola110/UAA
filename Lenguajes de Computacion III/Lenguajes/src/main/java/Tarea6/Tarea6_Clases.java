/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea6;

/**
 *
 * @author Paola Montserrat Osorio Garcia
 */
public class Tarea6_Clases {
    public static void main(String[]args) {
        a a1 = new a();
        System.out.println("Nombre de a "+a1.get_nom());
        a1.set_nom("Jose");
        System.out.println("Nombre de a "+a1.get_nom());

        b b1 = new b("Alberto");
        System.out.println("Nombre de b "+b1.get_nom());
        b1.set_nom("Magdalena");
        System.out.println("Nombre de b "+b1.get_nom());
     }
}

class a {
    String nombre = "Juan";

    public String get_nom(){
        return nombre;
    }

    public void set_nom(String newName) {
    this.nombre = newName;
    }
}


class b {
    String nombre="Maria";

    b(String s){
    nombre=s;
    }

    public String get_nom(){
        return nombre;
    }

    public void set_nom(String newName) {
    this.nombre = newName;
    }
}
