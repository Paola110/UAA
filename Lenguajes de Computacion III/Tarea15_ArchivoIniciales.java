
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Tarea15_ArchivoIniciales extends JFrame {

        private JPanel panel;

        public Tarea15_ArchivoIniciales() {
            this.setVisible(true);
            this.setSize(400, 500);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("Leer archivo");

            panel = new JPanel();
            panel.setLayout(new BorderLayout());
            this.getContentPane().add(panel);

            JButton but = new JButton("Leer archivo");
            panel.add(but, BorderLayout.NORTH);

            JTextArea text = new JTextArea(40,40);
            panel.add(text, BorderLayout.CENTER);

            but.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String line;
                    try {
                        
                        FileReader file = new FileReader("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Tarea15_NuevoArchivo.txt");

                        try (BufferedReader br = new BufferedReader(file)) {
                            line = br.readLine();
                            while (line != null) {
                                line = line.replace(",", ", ");
                                line += "                " +Iniciales(line);
                                text.append(line + "\n");
                                line = br.readLine();
                            }
                        }

                    } catch (IOException ex) {
                        System.out.println("Ocurrió un problema al leer el archivo.");
                    }
                }
                 private String Iniciales(String line) {
                    String[] names = line.split(", "); // Dividir los nombres por guiones
                    StringBuilder Inicial = new StringBuilder();

                    for (String name : names) {
                        if (name.length() > 0) {
                            String primera_letra = name.substring(0, 1);
                            Inicial.append(primera_letra);
                        }
                    }
                    return Inicial.toString();
                }
            });
        }

        public static void main(String[] args) {
            new Tarea15_ArchivoIniciales();
        }
    }
