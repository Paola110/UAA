import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;



public class Proyecto2_Graficos extends JFrame{

    private JPanel panel;

    public Proyecto2_Graficos(){
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel (new BorderLayout());
        add(panel, BorderLayout.CENTER);


        String ruta = "C:\\Users\\monts\\OneDrive\\Escritorio\\UAA\\Lenguajes de Computacion III\\DatosP2.txt";

        String line;
        Map<String,int[]> personas = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            while ((line = br.readLine()) != null) {
                String[] fila = line.split(",");
                String Genero = fila[4];
                String Estado = fila[5];

                personas.putIfAbsent(Estado, new int[]{0, 0});
                
                // Incrementar conteo basado en el género
                if (Genero.equals("H")) {
                    personas.get(Estado)[0]++;
                } else if (Genero.equals("M")) {
                    personas.get(Estado)[1]++;
                }

            }
        } catch (IOException e) {
            System.out.println("Ocurrió un problema al leer el archivo: " + e.getMessage());
        }
        
        for (String Estado : personas.keySet()){
            int[] si = personas.get(Estado);
            DefaultPieDataset dataset = new DefaultPieDataset();
            dataset.setValue("Hombres", si[0]);
            dataset.setValue("Mujeres", si[1]);


            JFreeChart grafico = ChartFactory.createPieChart(
                "Estado: "+ Estado,
                dataset,
                true,
                true,
                false
            );

            ChartPanel GraficoEstado = new ChartPanel(grafico);
            GraficoEstado.setPreferredSize(new java.awt.Dimension(400, 300));

            panel.add(Estado,
                GraficoEstado
            );
        }


    }

    public static void main(String[] args) {
        Proyecto2_Graficos ventana = new Proyecto2_Graficos();
        ventana.setTitle("Proyecto 2");
        ventana.setVisible(true);
    }

}