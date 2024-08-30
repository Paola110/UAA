/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea7;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Tarea7_Instanciar extends JPanel implements ActionListener {

    JButton confirma1;
    JTextField texto1, texto2;

    public Tarea7_Instanciar() {
        texto1 = new JTextField(5);
        texto2 = new JTextField(15);
        confirma1 = new JButton("multiplica ");
        confirma1.addActionListener(this);
        setLayout(new FlowLayout());
        add(texto1);
        add(texto2);
        add(confirma1);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == confirma1) {
            Integer i = Integer.valueOf(texto1.getText());
            int cua = i + i;
            Integer ii = cua;
            texto2.setText("respuesta 2 " + ii.toString());
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("dos textfield y un boton ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tarea7_Instanciar bot = new Tarea7_Instanciar();
        frame.getContentPane().add(bot, BorderLayout.CENTER);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }

}
