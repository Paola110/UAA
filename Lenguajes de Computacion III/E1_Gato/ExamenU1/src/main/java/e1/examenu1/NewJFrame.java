/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package e1.examenu1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Osorio García Paola Montserrat
 * 
 */
public class NewJFrame extends JFrame implements ActionListener{
    
    private int TurnoOX = 1;
    private int GanaO = 0;
    private int GanaX = 0;
    
    public NewJFrame() {
        super("Examen U1 Gato Paola Osorio");
        initComponents();
        setSize(500, 350);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        Reiniciar.addActionListener(this);
        
        UU.addActionListener(this);
        UD.addActionListener(this);
        UT.addActionListener(this);
        
        DU.addActionListener(this);
        DD.addActionListener(this);
        DT.addActionListener(this);
        
        TU.addActionListener(this);
        TD.addActionListener(this);
        TT.addActionListener(this);
        
        Turno.setText("Turno de jugador O");
        R1.setText("0");
        R2.setText("0");
        
    }
    
    public void actionPerformed(ActionEvent AE){
        if (AE.getSource()== Reiniciar){
            UU.setText(""); UD.setText(""); UT.setText("");
            DU.setText(""); DD.setText(""); DT.setText("");
            TU.setText(""); TD.setText(""); TT.setText("");
            TurnoOX = 1;
            Turno.setText("Turno de jugador O");
            
            R1.setText("0");
            R2.setText("0");
            GanaO = 0;
            GanaX = 0;
            R1.enable(false);
            R2.enable(false);
        }
        
        if (AE.getSource() == UU) {
            if (UU.getText().equals("")) {
                alternarTurno(UU);
            }
        }
        if (AE.getSource() == UD) {
            if (UD.getText().equals("")) {
                alternarTurno(UD);
            }
        }
        if (AE.getSource() == UT) {
            if (UT.getText().equals("")) {
                alternarTurno(UT);
            }
        }
        if (AE.getSource() == DU) {
            if (DU.getText().equals("")) {
                alternarTurno(DU);
            }
        }
        if (AE.getSource() == DD) {
            if (DD.getText().equals("")) {
                alternarTurno(DD);
            }
        }
        if (AE.getSource() == DT) {
            if (DT.getText().equals("")) {
                alternarTurno(DT);
            }
        }
        if (AE.getSource() == TU) {
            if (TU.getText().equals("")) {
                alternarTurno(TU);
            }
        }
        if (AE.getSource() == TD) {
            if (TD.getText().equals("")) {
                alternarTurno(TD);
            }
        }
        if (AE.getSource() == TT) {
            if (TT.getText().equals("")) {
                alternarTurno(TT);
            }
        }
    }
    
    private void alternarTurno(JButton boton) {
        if (TurnoOX == 1) {
            boton.setText("O");
            Turno.setText("Turno de jugador X");
            TurnoOX = 2;
            verificarGanador("O");
        } else if (TurnoOX == 2) {
            boton.setText("X");
            Turno.setText("Turno de jugador O");
            TurnoOX = 1;
            verificarGanador("X");
        }
    }

    private void BorrarTablero(){
        UU.setText(""); UD.setText(""); UT.setText("");
        DU.setText(""); DD.setText(""); DT.setText("");
        TU.setText(""); TD.setText(""); TT.setText("");
        TurnoOX = 1;
        Turno.setText("Turno de jugador O");
    }
    
    private void verificarGanador(String jugador) {
        if ((UU.getText().equals(jugador) && UD.getText().equals(jugador) && UT.getText().equals(jugador)) ||
            (DU.getText().equals(jugador) && DD.getText().equals(jugador) && DT.getText().equals(jugador)) ||
            (TU.getText().equals(jugador) && TD.getText().equals(jugador) && TT.getText().equals(jugador)) ||
            (UU.getText().equals(jugador) && DU.getText().equals(jugador) && TU.getText().equals(jugador)) ||
            (UD.getText().equals(jugador) && DD.getText().equals(jugador) && TD.getText().equals(jugador)) ||
            (UT.getText().equals(jugador) && DT.getText().equals(jugador) && TT.getText().equals(jugador)) ||
            (UU.getText().equals(jugador) && DD.getText().equals(jugador) && TT.getText().equals(jugador)) ||
            (UT.getText().equals(jugador) && DD.getText().equals(jugador) && TU.getText().equals(jugador))) {

            if (jugador.equals("O")) {
                GanaO++;
                Ganador.setText("El ganador es el jugador O !!!");
                R1.setText(String.valueOf(GanaO));
            } else {
                GanaX++;
                Ganador.setText("El ganador es el jugador X !!!");
                R2.setText(String.valueOf(GanaX));
            }
            javax.swing.Timer timer = new javax.swing.Timer(3000, (ActionEvent e) -> {
                Ganador.setText("");
                BorrarTablero(); 
            });
            timer.setRepeats(false);
            timer.start();
        } else if ((!UU.getText().equals("") && !UD.getText().equals("") && !UT.getText().equals("")) &&
        (!DU.getText().equals("") && !DD.getText().equals("") && !DT.getText().equals("")) &&
        (!TU.getText().equals("") && !TD.getText().equals("") && !TT.getText().equals(""))){
            Ganador.setText("Ninguno gana :(");
            javax.swing.Timer timer = new javax.swing.Timer(3000, (ActionEvent e) -> {
                Ganador.setText("");
                BorrarTablero(); 
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        UU = new javax.swing.JButton();
        UD = new javax.swing.JButton();
        UT = new javax.swing.JButton();
        DU = new javax.swing.JButton();
        DD = new javax.swing.JButton();
        DT = new javax.swing.JButton();
        TU = new javax.swing.JButton();
        TD = new javax.swing.JButton();
        TT = new javax.swing.JButton();
        Instrucciones = new javax.swing.JLabel();
        Turno = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        P1 = new javax.swing.JLabel();
        J2 = new javax.swing.JLabel();
        R1 = new javax.swing.JTextField();
        R2 = new javax.swing.JTextField();
        Reiniciar = new javax.swing.JButton();
        Ganador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UU.setBackground(new java.awt.Color(204, 204, 204));
        UU.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        UU.setToolTipText("");

        UD.setBackground(new java.awt.Color(204, 204, 204));
        UD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        UD.setToolTipText("");

        UT.setBackground(new java.awt.Color(204, 204, 204));
        UT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        UT.setToolTipText("");

        DU.setBackground(new java.awt.Color(204, 204, 204));
        DU.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DU.setToolTipText("");

        DD.setBackground(new java.awt.Color(204, 204, 204));
        DD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DD.setToolTipText("");

        DT.setBackground(new java.awt.Color(204, 204, 204));
        DT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DT.setToolTipText("");

        TU.setBackground(new java.awt.Color(204, 204, 204));
        TU.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TU.setToolTipText("");

        TD.setBackground(new java.awt.Color(204, 204, 204));
        TD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TD.setToolTipText("");

        TT.setBackground(new java.awt.Color(204, 204, 204));
        TT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TT.setToolTipText("");

        Instrucciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Instrucciones.setText("Seleccione la casilla deseada");

        Turno.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Turno.setText("Turno de ");

        Titulo.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Examen Unidad 1 Gato Paola Osorio");

        P1.setText("Jugador O");

        J2.setText("Jugador X");

        R1.setEnabled(false);

        R2.setEnabled(false);

        Reiniciar.setBackground(new java.awt.Color(255, 51, 51));
        Reiniciar.setForeground(new java.awt.Color(255, 255, 255));
        Reiniciar.setText("Reiniciar marcadores");
        Reiniciar.setPreferredSize(new java.awt.Dimension(140, 25));

        Ganador.setBackground(new java.awt.Color(255, 255, 255));
        Ganador.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        Ganador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Instrucciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(TU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(DU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(UU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Turno, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Reiniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(J2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(R2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(P1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(R1))
                            .addComponent(Ganador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(Titulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Instrucciones)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Turno)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TD, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TU, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Ganador)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(P1)
                            .addComponent(R1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(J2)
                            .addComponent(R2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(66, 66, 66)
                        .addComponent(Reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        
        new NewJFrame().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DD;
    private javax.swing.JButton DT;
    private javax.swing.JButton DU;
    private javax.swing.JLabel Ganador;
    private javax.swing.JLabel Instrucciones;
    private javax.swing.JLabel J2;
    private javax.swing.JLabel P1;
    private javax.swing.JTextField R1;
    private javax.swing.JTextField R2;
    private javax.swing.JButton Reiniciar;
    private javax.swing.JButton TD;
    private javax.swing.JButton TT;
    private javax.swing.JButton TU;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel Turno;
    private javax.swing.JButton UD;
    private javax.swing.JButton UT;
    private javax.swing.JButton UU;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
