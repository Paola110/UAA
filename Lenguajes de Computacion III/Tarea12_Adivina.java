import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tarea12_Adivina extends JFrame {

    private int numeroAleatorio;
    private int intentos;
    private JTextField campoNumero;
    private JLabel resultado;

    public Tarea12_Adivina() {
        setTitle("Adivina el Número");
        setLayout(new FlowLayout());

        // Generar número aleatorio entre 1 y 25
        numeroAleatorio = (int) (Math.random() * 25) + 1;
        intentos = 3;

        // Crear componentes
        JLabel label = new JLabel("Ingresa el número: ");
        campoNumero = new JTextField(5);
        JButton botonAdivinar = new JButton("Adivinar");
        resultado = new JLabel("Tienes 3 intentos");

        // Agregar componentes a la ventana
        add(label);
        add(campoNumero);
        add(botonAdivinar);
        add(resultado);

        // Acción del botón
        botonAdivinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarNumero();
            }
        });

        // Configuración de la ventana
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void verificarNumero() {
        try {
            int numeroUsuario = Integer.parseInt(campoNumero.getText());

            if (numeroUsuario == numeroAleatorio) {
                resultado.setText("¡Le atinaste! Reiniciando...");
                reiniciarJuego();
            } else {
                intentos--;
                if (intentos > 0) {
                    if (numeroUsuario < numeroAleatorio) {
                        resultado.setText("Es mayor. Te quedan " + intentos + " intentos");
                    } else {
                        resultado.setText("Es menor. Te quedan " + intentos + " intentos");
                    }
                } else {
                    resultado.setText("No le atinaste. Reiniciando...");
                    reiniciarJuego();
                }
            }
        } catch (NumberFormatException ex) {
            resultado.setText("Ingresa un número válido");
        }
    }

    private void reiniciarJuego() {
        // Espera un poco antes de reiniciar
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroAleatorio = (int) (Math.random() * 25) + 1;
                intentos = 3;
                resultado.setText("Tienes 3 intentos");
                campoNumero.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void main(String[] args) {
        new Tarea12_Adivina();
    }
}