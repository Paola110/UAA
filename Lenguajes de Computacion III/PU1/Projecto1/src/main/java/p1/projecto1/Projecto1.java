/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package p1.projecto1;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author monts
 */
public class Projecto1 extends JPanel implements ActionListener{
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel Instrucciones;
    private javax.swing.JLabel Lado1;
    private java.awt.TextField L1;
    private javax.swing.JLabel Lado2;
    private java.awt.TextField L2;
    private javax.swing.JLabel Lado3;
    private java.awt.TextField L3;
    private javax.swing.JButton Dibujar;
    private javax.swing.JPanel Dibujo;
    private javax.swing.JPanel tituloPanel;
    private javax.swing.JPanel instruccionesPanel;
    private javax.swing.JPanel inputPanel;
    private javax.swing.JPanel dibujoPanel;
    // End of variables declaration//GEN-END:variables
    
    /**
     *
     * @param proyecto1
     */
    public Projecto1(){
        setLayout(new GridLayout(2, 1)); // 2 rows, 1 column       
      
        // Add components to sub-panels
        tituloPanel.add(Titulo);
        instruccionesPanel.add(Instrucciones);
      
        // Use GridLayout (2 rows, 2 columns) for input fields
        inputPanel.setLayout(new GridLayout(3, 2)); // 3 rows, 2 columns
        inputPanel.add(Lado1);
        inputPanel.add(L1);
        inputPanel.add(Lado2);
        inputPanel.add(L2);
        inputPanel.add(Lado3);
        inputPanel.add(L3);
      
        add(tituloPanel);
        add(instruccionesPanel);
        add(inputPanel);
        add(dibujoPanel);
        
        initComponents();

        setSize(500, 350);
        
        add(Titulo); add(Instrucciones);
        
        add(Lado1); add(L1);
        add(Lado2); add(L2);
        add(Lado3); add(L3);

        add(Dibujar);
        Dibujar.addActionListener(this);
        
        add(Dibujo);
        
    }
    
    public void paintTriangle (Graphics g){
        super.paintComponent(g);
        int lado1 = Integer.parseInt(L1.getText());
        int lado2 = Integer.parseInt(L2.getText());
        int lado3 = Integer.parseInt(L3.getText());
        g.drawLine(lado1, lado1, lado2, lado2);
        g.drawLine(lado2, lado2, lado3, lado3);
        g.drawLine(lado3, lado3, lado1, lado1);
    }

    public static void main(String[] args) {

        new Projecto1().setVisible(true);

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Triangulo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Projecto1 dibujo = new Projecto1();
        frame.getContentPane().add(dibujo, BorderLayout.LINE_END);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == Dibujar){
            repaint();
        }
    }

    private void initComponents() {
        
        Titulo = new javax.swing.JLabel("Proyecto Unidad 1 Triangulo Paola Osorio");
        Instrucciones = new javax.swing.JLabel("Ingrese los lados del triangulo");
        Lado1 = new javax.swing.JLabel ("Ingrese el tamaño del lado 1: "); L1 = new java.awt.TextField(10);
        Lado2 = new javax.swing.JLabel ("Ingrese el tamaño del lado 2: "); L2 = new java.awt.TextField(10);
        Lado3 = new javax.swing.JLabel ("Ingrese el tamaño del lado 3: "); L3 = new java.awt.TextField(10);
        Dibujar = new javax.swing.JButton("Dibujar");
        Dibujo = new javax.swing.JPanel();
        tituloPanel = new JPanel();
        instruccionesPanel = new JPanel();
        inputPanel = new JPanel();
        dibujoPanel = new JPanel();
        
        tituloPanel.add(Titulo);
        instruccionesPanel.add(Instrucciones);
        inputPanel.add(Lado1);
        

        Dibujo.setBackground(new java.awt.Color(255, 255, 255));


        Titulo.setFont(new java.awt.Font("Tahoma", 1, 18));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        Instrucciones.setFont(new java.awt.Font("Tahoma", 0, 18));
        Instrucciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        Lado1.setFont(new java.awt.Font("Tahoma", 0, 18));
        L1.setFont(new java.awt.Font("Tahoma", 1, 18));
        Lado1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        Lado2.setFont(new java.awt.Font("Tahoma", 0, 18));
        L2.setFont(new java.awt.Font("Tahoma", 1, 18));
        Lado2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        
        Lado3.setFont(new java.awt.Font("Tahoma", 0, 18));
        L3.setFont(new java.awt.Font("Tahoma", 1, 18));
        Lado3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        Dibujar.setFont(new java.awt.Font("Tahoma", 1, 20));
        Dibujar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        javax.swing.GroupLayout Projecto1Layout = new javax.swing.GroupLayout(this);
        this.setLayout(Projecto1Layout);
        
        
    }

}
