package Tarea9;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tarea9_Estaciones_Grafico extends JPanel implements ActionListener {

    JButton Estacion;
    JTextField Mes,Respuesta;

    public Tarea9_Estaciones_Grafico(){
        Mes = new JTextField(5);
        Respuesta = new JTextField(30);
        Estacion = new JButton("Averigualo");
        Estacion.addActionListener(this);
        setLayout(new FlowLayout());
        add(Mes);
        add(Respuesta);
        add(Estacion);
        Respuesta.setText("Respuesta: ");
    }

    @Override
    public void actionPerformed(ActionEvent AE){
        if(AE.getSource()==Estacion){
            Integer mes = Integer.valueOf(Mes.getText());

            if ((Objects.equals(mes, 12)) || (Objects.equals(mes, 1)) || (Objects.equals(mes, 2)) ){
                Respuesta.setText("El mes " + mes + " corresponde a la estación de Invierno.");
            }else if((Objects.equals(mes, 3)) || (Objects.equals(mes, 4)) || (Objects.equals(mes, 5))){
                Respuesta.setText("El mes " + mes + " corresponde a la estación de Primavera.");
            } else if ( (Objects.equals(mes, 6)) || (Objects.equals(mes, 7)) || (Objects.equals(mes, 8)) ){
                Respuesta.setText("El mes " + mes + " corresponde a la estación de Verano.");
            } else if ( (Objects.equals(mes, 9)) || (Objects.equals(mes, 10)) || (Objects.equals(mes, 11)) ){
                Respuesta.setText("El mes " + mes + " corresponde a la estación de Otoño.");
            }
        }
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Qué estación es?");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Tarea9_Estaciones_Grafico bot = new Tarea9_Estaciones_Grafico();
        frame.getContentPane().add(bot,BorderLayout.CENTER);
        frame.setBounds(100, 100, 400, 325);
        frame.setVisible(true);
    }
}