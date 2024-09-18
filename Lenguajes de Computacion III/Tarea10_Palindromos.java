package Tarea10;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 import java.awt.BorderLayout;
 import java.awt.FlowLayout;
 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
 /**
  *
  * @author Paola Osorio
  */
 public class Tarea10_Palindromos extends JPanel implements ActionListener {
 
     
     JButton verificarPalindromo, formatearTexto;
     JTextField textoPalindromo, textoFormateado, resultadoPalindromo, resultadoFormateado;
 
     public Tarea10_Palindromos() {
         textoPalindromo = new JTextField(10); // Campo para ingresar la palabra
         resultadoPalindromo = new JTextField(10); // Resultado de la verificación
 
         textoFormateado = new JTextField(10); // Campo para el texto a formatear
         resultadoFormateado = new JTextField(10); // Resultado del formateo
 
         verificarPalindromo = new JButton("Verificar");
         formatearTexto = new JButton("Formatear");
 
         Tarea10_Palindromos l = this;
         verificarPalindromo.addActionListener(l);
         formatearTexto.addActionListener(l);
 
         setLayout(new FlowLayout());
         add(new JLabel("Palabra para ver si es palíndromo:"));
         add(textoPalindromo);
         add(verificarPalindromo);
         add(resultadoPalindromo);
 
         add(new JLabel("Texto a formatear:"));
         add(textoFormateado);
         add(formatearTexto);
         add(resultadoFormateado);
     }
 
     @Override
     public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == verificarPalindromo) {
             String palabra = textoPalindromo.getText().replaceAll("\\s+", "").toLowerCase(); // Quita espacios y pone en minúsculas
             String invertida = new StringBuilder(palabra).reverse().toString();
 
             if (palabra.equals(invertida)) {
                 resultadoPalindromo.setText("Es palíndromo");
             } else {
                 resultadoPalindromo.setText("No es palíndromo");
             }
         } else if (ae.getSource() == formatearTexto) {
             String texto = textoFormateado.getText().replaceAll("\\s+", " ").trim(); // Reemplazar múltiples espacios por uno y eliminar espacios en los extremos
             String[] palabras = texto.split(" "); // Separar el texto en palabras
             StringBuilder formateado = new StringBuilder();
 
             for (String palabra : palabras) {
                 if (palabra.length() > 0) {
                     // Poner la primera letra en mayúscula y el resto en minúscula
                     formateado.append(palabra.substring(0, 1).toUpperCase())
                               .append(palabra.substring(1).toLowerCase())
                               .append(" ");
                 }
             }
 
             resultadoFormateado.setText(formateado.toString().trim()); // Convertir a string y eliminar el último espacio
         }
     }
 
     public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true);
         JFrame frame = new JFrame("Palindromo y Formateo de Texto");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
         Tarea10_Palindromos panel = new Tarea10_Palindromos();
         frame.getContentPane().add(panel, BorderLayout.CENTER);
         frame.setBounds(100, 100, 400, 200);
         frame.setVisible(true);
     }
 }