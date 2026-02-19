import Personaje.Civil.Trabajador;
import Personaje.Civil.Trabajador.Profession;
import Personaje.Guerrero.Guerrero;
import Personaje.Guerrero.Guerrero.Tipo;
import edificio.Edificio;
import edificio.Edificio.TipoEdificio;

public class GameMain {

    public static void main(String[] args) {

        Colonia colonia = new Colonia();

        // 🔹 CREAR TRABAJADORES
        Trabajador minero1 = new Trabajador("Neo", 50, Profession.GRINDER);
        Trabajador minero2 = new Trabajador("Axel", 50, Profession.GRINDER);
        Trabajador agro1 = new Trabajador("Ivy", 50, Profession.AGROTECH);
        Trabajador fixer1 = new Trabajador("Hex", 50, Profession.FIXER);

        colonia.addPersonaje(minero1);
        colonia.addPersonaje(minero2);
        colonia.addPersonaje(agro1);
        colonia.addPersonaje(fixer1);

        // 🔹 CREAR GUERREROS
        Guerrero runner1 = new Guerrero(Tipo.RUNNER);
        Guerrero chopper1 = new Guerrero(Tipo.CHOPPER);

        colonia.addPersonaje(runner1);
        colonia.addPersonaje(chopper1);

        // 🔹 CREAR EDIFICIOS
        Edificio mina = new Edificio(TipoEdificio.MINA_NEOCROMO);
        Edificio granja = new Edificio(TipoEdificio.GRANJA_KROMAFRUTA);
        Edificio lab = new Edificio(TipoEdificio.LAB_NANOCURA);

        // 🔹 ASIGNAR TRABAJADORES
        mina.addTrabajador(minero1);
        mina.addTrabajador(minero2);

        granja.addTrabajador(agro1);

        lab.addTrabajador(fixer1);

        colonia.addEdificio(mina);
        colonia.addEdificio(granja);
        colonia.addEdificio(lab);

        // 🔹 MOSTRAR ESTADO INICIAL
        colonia.mostrarEstado();

        // 🔹 SIMULAR UN DÍA
        colonia.simularDia();

        // 🔹 MOSTRAR RECURSOS GENERADOS
        colonia.getRecursos().verRecursos();
    }
}