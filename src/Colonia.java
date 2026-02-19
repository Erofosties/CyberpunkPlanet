import java.util.ArrayList;
import Personaje.Personaje;
import Personaje.Civil.Trabajador;
import Personaje.Guerrero.Guerrero;
import Personaje.Guerrero.Guerrero.Tipo;
import edificio.Edificio;
import recursos.Recursos;
import recursos.Recursos.ResourceType;

public class Colonia {

    private ArrayList<Personaje> poblacion;
    private ArrayList<Edificio> edificios;
    private Recursos recursos;

    public Colonia() {
        poblacion = new ArrayList<>();
        edificios = new ArrayList<>();
        recursos = new Recursos();
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
}