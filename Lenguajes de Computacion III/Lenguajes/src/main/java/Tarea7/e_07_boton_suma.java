/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea7_Instanciar {

public class e_07_boton_suma extends JPanel implements ActionListener {
    JButton confirma1;
    JTextField texto1, texto2;

    public e_07_boton_suma() {
        texto1 = new JTextField(5);
        texto2 = new JTextField(15);
        confirma1 = new JButton("multiplica ");
        confirma1.addActionListener(this);
        setLayout(new FlowLayout());
        add(texto1);
        add(texto2);
        add(confirma1);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirma1) {
            Integer i = new Integer(texto1.getText().toString());
            int cua = i.intValue() + i.intValue();
            Integer ii = new Integer(cua);
            texto2.setText("respuesta " + ii.toString());
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("dos textfield y un boton ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        e_07_boton_suma bot = new e_07_boton_suma();
        frame.getContentPane().add(bot, BorderLayout.CENTER);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }
}

}
