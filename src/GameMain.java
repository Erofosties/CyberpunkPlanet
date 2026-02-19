import Personaje.Personaje;
import Personaje.Civil.Trabajador;
import Personaje.Civil.Trabajador.Profession;
import Personaje.Guerrero.Guerrero;
import Personaje.Guerrero.Guerrero.Tipo;
import edificio.Edificio;
import edificio.Edificio.TipoEdificio;

public class GameMain {

    public static void main(String[] args) {

        Colonia colonia = new Colonia();

     // Crear personajes manualmente
        Trabajador t1 = new Trabajador("Neo", 50, Profession.GRINDER);
        Trabajador t2 = new Trabajador("Ivy", 50, Profession.AGROTECH);
        Guerrero g1 = new Guerrero(Tipo.RUNNER);

        colonia.addPersonaje(t1);
        colonia.addPersonaje(t2);
        colonia.addPersonaje(g1);

        // Guardar en BD
        colonia.guardarPersonajesEnBD();
        
        //cargar personajes desde bbdd
        colonia.cargarPersonajesDesdeBD();
        
        // 🔹 CREAR EDIFICIOS
        Edificio mina = new Edificio(TipoEdificio.MINA_NEOCROMO);
        Edificio granja = new Edificio(TipoEdificio.GRANJA_KROMAFRUTA);
        Edificio lab = new Edificio(TipoEdificio.LAB_NANOCURA);

        

        colonia.addEdificio(mina);
        colonia.addEdificio(granja);
        colonia.addEdificio(lab);

        //Asignar trabajadores automaticamente
        for (Personaje p : colonia.getPoblacion()) {

            if (p instanceof Trabajador t) {

                switch (t.getProfession()) {

                    case GRINDER -> mina.addTrabajador(t);
                    case AGROTECH -> granja.addTrabajador(t);
                    case FIXER -> lab.addTrabajador(t);
                    default -> {}
                }
            }
        }
        // 🔹 SIMULAR UN DÍA
        colonia.simularDia();
        colonia.guardarRecursosEnBD();
        
        //simular ataque
        colonia.simularAtaque(500);


        // 🔹 MOSTRAR RECURSOS GENERADOS
        colonia.mostrarEstado();
        colonia.getRecursos().verRecursos();
    }
}