package bbdd;
import java.sql.Connection;


public class TestConnection {

    public static void main(String[] args) {

        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("✅ Conexión exitosa a Oracle");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}