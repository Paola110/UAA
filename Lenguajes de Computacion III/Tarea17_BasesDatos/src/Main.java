import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/tarea17_basedatosxampp";
        String user = "root"; // Adjust as necessary
        String password = ""; // Adjust as necessary

            // Establish the connection
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("Conectado a la base de datos tarea17_basedatosxampp");
                System.out.println("> Datos de la tabla alumno01");
                
                try (Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM alumno01;")) {

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String nombre = rs.getString("nom");
                        int edad = rs.getInt("edad");
                        System.out.format("%s | %s | %s\n", id, nombre, edad);
                    }
                } catch (SQLException ex) {
                    System.err.println("Error al ejecutar la consulta: " + ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.getMessage());
        }

        System.out.println("Fin programa.");
    }
}