
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


public class Tarea14_ArchivoCapitalLatter extends JFrame {

        private JPanel panel;

        public Tarea14_ArchivoCapitalLatter() {
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
                        
                        FileReader file = new FileReader("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Tarea14_NuevoArchivo.txt");

                        try (BufferedReader br = new BufferedReader(file)) {
                            line = br.readLine();
                            while (line != null) {
                                line = line.replace(",", ", ");
                                line = capitalizeNames(line);
                                text.append(line + "\n");
                                line = br.readLine();
                            }
                        }

                    } catch (IOException ex) {
                        System.out.println("Ocurrió un problema al leer el archivo.");
                    }
                }
                 private String capitalizeNames(String line) {
                    String[] names = line.split(", "); // Dividir los nombres por guiones
                    StringBuilder capitalizedLine = new StringBuilder();

                    for (String name : names) {
                        if (name.length() > 0) {
                            String capitalized = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                            capitalizedLine.append(capitalized).append(", ");
                        }
                    }

                    // Eliminar el último guion adicional al final
                    if (capitalizedLine.length() > 0) {
                        capitalizedLine.setLength(capitalizedLine.length() - 2);
                    }

                    return capitalizedLine.toString();
                }
            });
        }

        public static void main(String[] args) {
            new Tarea14_ArchivoCapitalLatter();
        }
    }
