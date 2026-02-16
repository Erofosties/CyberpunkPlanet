import Personaje.Personaje;
import Personaje.Civil.Trabajador;
import Personaje.Civil.Trabajador.Profession;
import Personaje.Guerrero.Guerrero;
import Personaje.Guerrero.Guerrero.Tipo;
import recursos.Recursos;
import recursos.Recursos.ResourceType;

public class GameMain {

    public static void main(String[] args) {

        System.out.println("=== BIENVENIDO A CYBERPUNK PLANET ===\n");

        // 1️⃣ Crear colonia
        Population colonia = new Population();

        // 2️⃣ Crear trabajadores
        Trabajador neo = new Trabajador("Neo", 50, Profession.GRINDER);
        Trabajador ivy = new Trabajador("Ivy", 50, Profession.GRINDER);
        Trabajador hex = new Trabajador("Hex", 50, Profession.AGROTECH);

        // Asignar recursos (esto simula la UI del jugador)
        neo.assignResource(ResourceType.NEOCROMO);
        ivy.assignResource(ResourceType.UMBRIUM);
        hex.assignResource(ResourceType.KROMAFRUTA);

        colonia.addPjs(neo);
        colonia.addPjs(ivy);
        colonia.addPjs(hex);

        // 3️⃣ Crear guerreros
        Guerrero runner = new Guerrero(Tipo.RUNNER);
        Guerrero chopper = new Guerrero(Tipo.CHOPPER);

        colonia.addPjs(runner);
        colonia.addPjs(chopper);

        // 4️⃣ Crear almacén de recursos del día
        Recursos recursos = new Recursos();

        System.out.println("Simulando Día 1...\n");

        // 5️⃣ Producción diaria
        for (Personaje p : colonia.getPersonajes()) {

            if (p instanceof Trabajador t && t.getAssignedResource() != null) {
                int producido = t.getProduccion();
                recursos.add(t.getAssignedResource(), producido);

                System.out.println(
                    "Trabajador " + t.getNombre() +
                    " produjo " + producido +
                    " de " + t.getAssignedResource()
                );
            }

            if (p instanceof Guerrero g && g.getDisponible()) {

                if (g.getTipo() == Tipo.RUNNER) {
                    int explorado = g.explorar(4); // 4 horas
                    recursos.add(ResourceType.EXPLORACION, explorado);

                    System.out.println(
                        "Runner " + g.getNombre() +
                        " exploró y obtuvo " + explorado + " puntos"
                    );
                }
            }
        }

        // 6️⃣ Fin del día: mostrar resumen
        System.out.println("\n=== RESUMEN DEL DÍA ===");
        recursos.verRecursos();

        System.out.println("\nEstado de la colonia:");
        colonia.showStatus();

        System.out.println("\n=== FIN DEL DÍA 1 ===");
    }
}