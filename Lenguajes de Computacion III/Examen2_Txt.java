

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Examen2_Txt extends JFrame {
    public Examen2_Txt() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane pestañas = new JTabbedPane();
        
        JTextArea TA_trabajo = new JTextArea();
        TA_trabajo.setPreferredSize(new Dimension(350, 100));
        JButton btnGuardarTrabajo = new JButton("Guardar Trabajo");

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\trabajo.txt", TA_trabajo);
        btnGuardarTrabajo.addActionListener(e -> guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\trabajo.txt", TA_trabajo));

        JPanel trabajo = new JPanel();
        trabajo.add(new JLabel("Trabajo"));
        trabajo.add(TA_trabajo);
        trabajo.add(btnGuardarTrabajo);
        pestañas.addTab("Trabajo", trabajo);

        JTextArea TA_gym = new JTextArea();
        TA_gym.setPreferredSize(new Dimension(350, 100));
        JButton btnGuardarGym = new JButton("Guardar Gym");

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\gym.txt", TA_gym);
        btnGuardarGym.addActionListener(e -> guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\gym.txt", TA_gym));

        JPanel gym = new JPanel();
        gym.add(new JLabel("Gym"));
        gym.add(TA_gym);
        gym.add(btnGuardarGym);
        pestañas.addTab("Gym", gym);

        JTextArea TA_casa = new JTextArea();
        TA_casa.setPreferredSize(new Dimension(350, 100));
        JButton btnGuardarCasa = new JButton("Guardar Casa");

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\casa.txt", TA_casa);
        btnGuardarCasa.addActionListener(e -> guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\casa.txt", TA_casa));

        JPanel casa = new JPanel();
        casa.add(new JLabel("Casa"));
        casa.add(TA_casa);
        casa.add(btnGuardarCasa);
        pestañas.addTab("Casa", casa);
        
        getContentPane().add(pestañas);
    }

    private void leerArchivo(String ruta, JTextArea textArea) {
        String line;
        textArea.setText("");

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                textArea.append(line + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un problema al leer el archivo: " + e.getMessage());
        }
    }

    private void guardarArchivo(String ruta, JTextArea textArea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write(textArea.getText());
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un problema al guardar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Examen2_Txt ventana = new Examen2_Txt();
        ventana.setTitle("Examen 2");
        ventana.setVisible(true);
    }
}