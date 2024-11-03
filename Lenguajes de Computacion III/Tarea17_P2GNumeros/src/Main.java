import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Main extends JFrame {
    private JPanel panel;

    public Main() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String rutaArchivo = "C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\DatosP2.txt";
        HashMap<String, int[]> personas = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String genero = datos[4];
                String estado = datos[5];

                personas.putIfAbsent(estado, new int[]{0, 0});

                // Incrementa el conteo de hombres o mujeres basado en el género
                if (genero.equals("H")) {
                    personas.get(estado)[0]++;
                } else if (genero.equals("M")) {
                    personas.get(estado)[1]++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un problema al leer el archivo: " + e.getMessage());
        }

        // Crear el conjunto de datos para el gráfico
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (String estado : personas.keySet()) {
            int[] counts = personas.get(estado);
            dataset.addValue(counts[0], "Hombres", estado);
            dataset.addValue(counts[1], "Mujeres", estado);
        }

        // Crear el gráfico de barras
        JFreeChart grafico = ChartFactory.createBarChart(
            "Cantidad de Hombres y Mujeres por Estado",
            "Estado",
            "Cantidad",
            dataset
        );

        // Configuración del renderizador para mostrar etiquetas
        CategoryPlot plot = grafico.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);  // Color azul para hombres
        renderer.setSeriesPaint(1, Color.PINK);  // Color rosa para mujeres
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setDefaultItemLabelsVisible(true); // Muestra las etiquetas

        // Crear el panel del gráfico
        ChartPanel graficoPanel = new ChartPanel(grafico);
        graficoPanel.setPreferredSize(new Dimension(800, 600));

        // Configuración de la ventana principal
        panel = new JPanel(new BorderLayout());
        panel.add(graficoPanel, BorderLayout.CENTER);
        add(panel);
    }

    public static void main(String[] args) {
        Main ventana = new Main();
        ventana.setTitle("Proyecto 2");
        ventana.setVisible(true);
    }
}

// Compilar y ejecutar en bash:

/*
javac -cp "lib/*" src/Main.java
java -cp "lib/*;src" Main
 */