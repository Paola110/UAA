/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Paola Osorio
 */

public class Tarea11_Dibujo extends JPanel implements ActionListener {

    TextField name;
    int oportunidades = 0;
    Image img;

    public Tarea11_Dibujo(Tarea11_Dibujo tarea11_Dibujo) {
        String imageFile = "C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Imagen.jpeg";
        img = Toolkit.getDefaultToolkit().getImage(imageFile);
        setLayout(new FlowLayout());
        name = new TextField(15);
        name.addActionListener(this);
        add(name);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        oportunidades = oportunidades + 1;
        repaint();
        if (oportunidades == 5) {
            System.exit(0);
            setVisible(false);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // paint background
        if (oportunidades == 1)
            g.drawLine(100, 110, 140, 150);
        if (oportunidades == 2) {
            g.drawLine(100, 110, 140, 150);
            g.drawOval(100, 110, 140, 150);
        }
        if (oportunidades == 3) {
            g.drawLine(100, 110, 140, 150);
            g.drawOval(100, 110, 140, 150);
            g.drawString("prueba", 50, 50);
        }
        if (oportunidades == 4) {
            g.drawLine(100, 110, 140, 150);
            g.drawOval(100, 110, 140, 150);
            g.drawString("prueba", 50, 50);
            g.drawImage(img, 120, 140, 55, 55, this);
        }
    }

    public static void main(String args[]) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Dibujo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tarea11_Dibujo dibujo = new Tarea11_Dibujo(null); // Pasar null temporalmente
        frame.getContentPane().add(dibujo, BorderLayout.CENTER);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }
}
