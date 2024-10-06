
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tarea13_Archivos extends JFrame {

    JButton leer, escribir;
    JTextField Escribir;
    JTextArea Leer;

    public Tarea13_Archivos(){

        setTitle("Escribir y leer archivo");

        leer = new JButton("Leer Archivo");
        escribir = new JButton("Escribir Archivo");
        Leer = new JTextArea(20,20) ;
        Escribir = new JTextField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Ingresa los numeros separados por coma: "));
        panel.add(Escribir);
        panel.add(escribir);
        panel.add(leer);
        panel.add(Leer);

        this.add(panel);


        escribir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EscribirArchivo();
            }
        });
        leer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LeerArchivo();
            }
        });

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void LeerArchivo() {
        try{
            Leer.setText("");
            try (BufferedReader archivo = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Tarea13_NuevoArchivo.txt")))) {
                String linea;
                while ((linea = archivo.readLine()) != null) {
                    Leer.append(linea + "\n");
                }
            }

        } catch (IOException e) {
            System.out.print("Error al leer el archivo");
        }
    }

    private void EscribirArchivo() {
        try{
            String numeros[] = Escribir.getText().split(",");

            try (OutputStream os = new FileOutputStream("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Tarea13_NuevoArchivo.txt")) {
                for (String numero : numeros) {
                    os.write((numero.trim() + System.lineSeparator()).getBytes());
                }
            }

        } catch (IOException e) {
            System.out.print("Error al leer el archivo");
        }
    }

    public static void main(String[] args) {
        new Tarea13_Archivos();
    }

}
