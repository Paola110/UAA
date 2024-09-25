
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paola Montserrat Osorio García
 */
public class Projecto1 extends JPanel implements ActionListener{
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel Titulo;
    private JLabel Instrucciones;
    private JLabel Lado1, Lado2, Lado3;
    private JTextField L1, L2, L3;
    private JButton Dibujar;
    private JPanel Dibujo;
    
    private int lado1, lado2, lado3;
    private JLabel Error;
    
    // End of variables declaration//GEN-END:variables
   
    public Projecto1(){
        
        Titulo = new JLabel("Proyecto Unidad 1 Triangulo Paola Osorio");
        Instrucciones = new JLabel("Ingrese los lados del triangulo");
        Lado1 = new JLabel ("Ingrese el tamaño del lado 1: "); 
        L1 = new JTextField(10);
        Lado2 = new JLabel ("Ingrese el tamaño del lado 2: ");
        L2 = new JTextField(10);        
        Lado3 = new JLabel ("Ingrese el tamaño del lado 3: "); 
        L3 = new JTextField(10);        
        Error = new JLabel (""); 
        Dibujar = new JButton("Dibujar");
        
        Dibujo = new JPanel(){
            @Override
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                paintTriangle(g);
            }
        };
        
        Dibujo.setBackground(new java.awt.Color(255,255,255));
        Dibujo.setPreferredSize(new java.awt.Dimension(400, 400));
        
        setLayout(new BorderLayout());
        
        JPanel tituloPanel = new JPanel();
        tituloPanel.add(Titulo);
        
        JPanel inputPanel = new JPanel(new GridLayout(7,1,10,10));
        inputPanel.add(Instrucciones);
        inputPanel.add(new JLabel());
        inputPanel.add(Lado1);
        inputPanel.add(L1);
        inputPanel.add(Lado2);
        inputPanel.add(L2);
        inputPanel.add(Lado3);
        inputPanel.add(L3);
        inputPanel.add(Dibujar);
        inputPanel.add(new JLabel());
        inputPanel.add(Error);
        
        
        
        add(tituloPanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(Dibujo, BorderLayout.SOUTH);

        Dibujar.addActionListener(this);
        
    }
    
    public void paintTriangle (Graphics g){
        try {
            lado1 = Integer.parseInt(L1.getText());
            lado2 = Integer.parseInt(L2.getText());
            lado3 = Integer.parseInt(L3.getText());
            
            Error.setText("");

            if (lado1 <= 0 || lado2 <= 0 || lado3 <= 0) {
                Error.setText("Los lados deben ser positivos.");
                return;
            }
            
            if (lado1 < 100 && lado2 < 100 && lado3 < 100){
                lado1*=10;
                lado2*=10;
                lado3*=10;
            }

            if (lado1 + lado2 > lado3 && lado1 + lado3 > lado2 && lado2 + lado3 > lado1) {
                //Primer punto
                int x1 = 100;
                int y1 = 350;
                
                //Nos movemos a la derecha hacia el segundo punto con el lado 1
                int x2 = x1 + lado1;
                int y2 = y1;
                
                //Se busca el angulo con ley de coseno
                // Cos0 = (a² + b² - c²)/ 2ab
                double cosTheta = (Math.pow(lado1, 2) + Math.pow(lado2, 2) - Math.pow(lado3, 2)) / (2.0 * lado2 * lado1);
                double theta = Math.acos(cosTheta); 
                
                //Calculamos el punto tres con el angulo obtenido
                // x = r + cos0 --> x3 = x1 + cos0
                int x3 = (int) (x1 + lado2 * Math.cos(theta));
                // y = r + sin0 --> y3 = y1 + sin0
                int y3 = (int) (y1 - lado2 * Math.sin(theta));
                
                g.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
            } else {
                Error.setText("Los lados no forman un triángulo.");
            }
        } catch (NumberFormatException e) {
            Error.setText("Ingrese valores válidos para los lados.");
        }
    }

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Triangulo");
        Projecto1 dibujo = new Projecto1(){};
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(dibujo);
        frame.setSize(500, 800);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Dibujar){
            Dibujo.repaint();
        }
    }
}