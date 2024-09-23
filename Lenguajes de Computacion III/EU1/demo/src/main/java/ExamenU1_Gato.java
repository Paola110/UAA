
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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

    }

    @Override
    public void actionPerformed(ActionEvent AE) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
