

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Tarea17_E2CerrGu extends JFrame implements WindowListener {
    
    private JTextArea TA_trabajo;
    private JTextArea TA_gym;
    private JTextArea TA_casa;
    
    public Tarea17_E2CerrGu() {
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTabbedPane pestañas = new JTabbedPane();
        
        TA_trabajo = new JTextArea();
        TA_trabajo.setPreferredSize(new Dimension(350, 100));

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\trabajo.txt", TA_trabajo);

        JPanel trabajo = new JPanel();
        trabajo.add(new JLabel("Trabajo"));
        trabajo.add(TA_trabajo);
        pestañas.addTab("Trabajo", trabajo);

        TA_gym = new JTextArea();
        TA_gym.setPreferredSize(new Dimension(350, 100));

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\gym.txt", TA_gym);

        JPanel gym = new JPanel();
        gym.add(new JLabel("Gym"));
        gym.add(TA_gym);
        pestañas.addTab("Gym", gym);

        TA_casa = new JTextArea();
        TA_casa.setPreferredSize(new Dimension(350, 100));

        leerArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\casa.txt", TA_casa);

        JPanel casa = new JPanel();
        casa.add(new JLabel("Casa"));
        casa.add(TA_casa);
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
        Tarea17_E2CerrGu ventana = new Tarea17_E2CerrGu();
        ventana.setTitle("Examen 2");
        ventana.setVisible(true);
        ventana.addWindowListener(ventana);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\trabajo.txt", TA_trabajo);
        guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\gym.txt", TA_gym);
        guardarArchivo("C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\Examen2\\casa.txt", TA_casa);
        System.exit(0);
    }
    
    @Override
    public void windowOpened(WindowEvent e) {    }

    @Override
    public void windowClosed(WindowEvent e) {    }

    @Override
    public void windowIconified(WindowEvent e) {    }

    @Override
    public void windowDeiconified(WindowEvent e) {    }

    @Override
    public void windowActivated(WindowEvent e) {    }

    @Override
    public void windowDeactivated(WindowEvent e) {    }
}