import java.util.ArrayList;
import Personaje.Personaje;
import Personaje.Civil.Trabajador;
import Personaje.Civil.Trabajador.Profession;
import Personaje.Guerrero.Guerrero;
import Personaje.Guerrero.Guerrero.Tipo;
import bbdd.DatabaseConnection;
import defensa.Defensas;
import edificio.Edificio;
import recursos.Recursos;
import recursos.Recursos.ResourceType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;



public class Colonia {

    private ArrayList<Personaje> poblacion;
    private ArrayList<Edificio> edificios;
    private Recursos recursos;
    private Defensas defensa;

    public Colonia() {
        poblacion = new ArrayList<>();
        edificios = new ArrayList<>();
        recursos = new Recursos();
        defensa = new Defensas();
    }

    // 🔹 POBLACIÓN
    public void addPersonaje(Personaje p) {
        poblacion.add(p);
    }

    public void removePersonaje(Personaje p) {
        poblacion.remove(p);
    }

    public ArrayList<Personaje> getPoblacion() {
        return poblacion;
    }

    // 🔹 EDIFICIOS
    public void addEdificio(Edificio e) {
        edificios.add(e);
    }

    public ArrayList<Edificio> getEdificios() {
        return edificios;
    }

    // 🔹 RECURSOS
    public Recursos getRecursos() {
        return recursos;
    }

    // 🔹 SIMULACIÓN DE EXPLORACIÓN (RUNNERS)
    private void simularExploracion(int horas) {
        int totalExploracion = 0;

        for (Personaje p : poblacion) {
            if (p instanceof Guerrero g) {
                if (g.getTipo() == Tipo.RUNNER && g.isDisponible()) {
                    int puntos = g.explorar(horas);
                    totalExploracion += puntos;
                }
            }
        }

        recursos.add(ResourceType.EXPLORACION, totalExploracion);
    }

    // 🔹 SIMULACIÓN DE PRODUCCIÓN (EDIFICIOS)
    private void simularProduccion() {
        for (Edificio e : edificios) {
            e.simularDia(recursos);
        }
    }
    
    //SImular ataque
    public void simularAtaque(int fuerzaEnemiga) {
        defensa.recibirAtaque(fuerzaEnemiga);
    }

    // 🔹 SIMULAR UN DÍA COMPLETO
    public void simularDia() {

        System.out.println("🌞 Simulando día en la colonia...\n");

        simularProduccion();
        simularExploracion(5); // horas de exploración de los runners

        System.out.println("✅ Día completado\n");
    }

    // 🔹 MOSTRAR ESTADO COLONIA
    public void mostrarEstado() {

        System.out.println("👥 Población total: " + poblacion.size());
        System.out.println("🏗️ Edificios: " + edificios.size());

        int trabajadores = 0;
        int guerreros = 0;

        for (Personaje p : poblacion) {
            if (p instanceof Trabajador) trabajadores++;
            if (p instanceof Guerrero) guerreros++;
        }

        System.out.println("Trabajadores: " + trabajadores);
        System.out.println("Guerreros: " + guerreros);
        System.out.println();
    }
    public void guardarRecursosEnBD() {

        String sql = "MERGE INTO RECURSOS r " +
                     "USING (SELECT ? AS TIPO, ? AS CANTIDAD FROM dual) tmp " +
                     "ON (r.TIPO = tmp.TIPO) " +
                     "WHEN MATCHED THEN UPDATE SET r.CANTIDAD = tmp.CANTIDAD " +
                     "WHEN NOT MATCHED THEN INSERT (TIPO, CANTIDAD) VALUES (tmp.TIPO, tmp.CANTIDAD)";

        try (Connection conn = DatabaseConnection.getConnection()) {

            for (ResourceType type : ResourceType.values()) {

                int cantidad = recursos.getCantidad(type); // ahora te explico esto

                try (PreparedStatement ps = conn.prepareStatement(sql)) {
                    ps.setString(1, type.name());
                    ps.setInt(2, cantidad);
                    ps.executeUpdate();
                }
            }

            System.out.println("💾 Recursos guardados en BD");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void cargarPersonajesDesdeBD() {

        String sql = "SELECT * FROM PERSONAJES";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            poblacion.clear();

            while (rs.next()) {

                String nombre = rs.getString("NOMBRE");
                int vida = rs.getInt("VIDA");
                String clase = rs.getString("CLASE");
                String subtipo = rs.getString("SUBTIPO");

                if (clase.equals("TRABAJADOR")) {
                    Profession prof = Profession.valueOf(subtipo);
                    Trabajador t = new Trabajador(nombre, vida, prof);
                    poblacion.add(t);
                }
                else if (clase.equals("GUERRERO")) {
                    Tipo tipo = Tipo.valueOf(subtipo);
                    Guerrero g = new Guerrero(tipo);
                    poblacion.add(g);
                }
            }

            System.out.println("📥 Personajes cargados desde BD");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void guardarPersonajesEnBD() {

        String deleteSQL = "DELETE FROM PERSONAJES";
        String insertSQL = 
            "INSERT INTO PERSONAJES (NOMBRE, VIDA, CLASE, SUBTIPO) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection()) {

            // 🔹 1. Limpiar tabla (modo simple para clase)
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(deleteSQL);
            }

            // 🔹 2. Insertar cada personaje
            for (Personaje p : poblacion) {

                try (PreparedStatement ps = conn.prepareStatement(insertSQL)) {

                    ps.setString(1, p.getNombre());
                    ps.setInt(2, p.getVida());

                    if (p instanceof Trabajador t) {
                        ps.setString(3, "TRABAJADOR");
                        ps.setString(4, t.getProfession().name());
                    }
                    else if (p instanceof Guerrero g) {
                        ps.setString(3, "GUERRERO");
                        ps.setString(4, g.getTipo().name());
                    }

                    ps.executeUpdate();
                }
            }

            System.out.println("💾 Personajes guardados en BD correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}