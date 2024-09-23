
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExamenU1_Gato extends JPanel implements ActionListener{

    JLabel Instrucciones;
    JButton UU, UD, UT, 
            DU, DD, DT, 
            TU, TD, TT;
    JLabel P1,R1, P2, R2;
    JButton Reinicio;

    public ExamenU1_Gato(){
        Instrucciones = new JLabel("Presiona la posición que desees");
        UU = new JButton("");
        UD = new JButton("");
        UT = new JButton("");
        DU = new JButton("");
        DD = new JButton("");
        DT = new JButton("");
        TU = new JButton("");
        TD = new JButton("");
        TT = new JButton("");
        UU.addActionListener(this); UD.addActionListener(this); UT.addActionListener(this);
        DU.addActionListener(this); DD.addActionListener(this); DT.addActionListener(this);
        TU.addActionListener(this); TD.addActionListener(this); TT.addActionListener(this);
        Reinicio.addActionListener(this);
        setLayout(new FlowLayout());
        add(Instrucciones);
        add(UU); add(UD); add(UT);
        add(DU); add(DD); add(DT);
        add(TU); add(TD); add(TT);
        add(P1); P1.setText("Jugador O :"); add(R1); R1.setText("0");
        add(P2); P1.setText("Jugador X :"); add(R2); R2.setText("0");
        add(Reinicio); Reinicio.setText("Reiniciar");

    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        if (AE.getSource()==Reinicio){
            UU.setText(""); UD.setText(""); UT.setText("");
            DU.setText(""); DD.setText(""); DT.setText("");
            TU.setText(""); TD.setText(""); TT.setText("");
        }
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Gato Examen 1 Paola Osorio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new ExamenU1_Gato());
        frame.setBounds(100, 500, 500, 500);
        frame.setVisible(true);
    }
}
