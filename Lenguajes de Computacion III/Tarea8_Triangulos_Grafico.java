package Tarea8;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tarea8_Triangulos_Grafico extends JPanel implements ActionListener {

    JButton Tipo_Triangulo;
    JTextField Lado1, Lado2, Lado3, Respuesta;

    public Tarea8_Triangulos_Grafico(){
        Lado1 = new JTextField(5);
        Lado2 = new JTextField(5);
        Lado3 = new JTextField(5);
        Respuesta = new JTextField(15);
        Tipo_Triangulo = new JButton("Averigualo");
        Tipo_Triangulo.addActionListener(this);
        setLayout(new FlowLayout());
        add(Lado1);
        add(Lado2);
        add(Lado3);
        add(Respuesta);
        add(Tipo_Triangulo);
        Respuesta.setText("Respuesta: ");
    }

    @Override
    public void actionPerformed(ActionEvent AE){
        if(AE.getSource()==Tipo_Triangulo){
            Integer l1 = Integer.valueOf(Lado1.getText());
            Integer l2 = Integer.valueOf(Lado2.getText());
            Integer l3 = Integer.valueOf(Lado3.getText());

            if ((Objects.equals(l1, l2)) && (Objects.equals(l3, l2))){
                Respuesta.setText("Es equilatero.");
                //System.out.print("\nEs equilatero\n");
            }else if((Objects.equals(l1, l2)) || (Objects.equals(l3, l2))){
                Respuesta.setText("Es isoceles.");
                //System.out.print("\nEs isoceles\n");
            } else if ( (!Objects.equals(l1, l2)) && (!Objects.equals(l3, l2))){
                Respuesta.setText("Es escaleno.");
                //System.out.print("\nEs escaleno\n");
            }
        }
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Qué tipo de triangulo es?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tarea8_Triangulos_Grafico bot = new Tarea8_Triangulos_Grafico();
        frame.getContentPane().add(bot,BorderLayout.CENTER);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }
}
