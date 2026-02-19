package defensa;

public class Defensas {

    private int escudos;              // cantidad
    private int torretasNeocromo;     // cantidad
    private int canonesHexalium;      // cantidad

    private int integridadNave;       // 0 - 100

    public Defensas() {
        this.escudos = 1;
        this.torretasNeocromo = 2;
        this.canonesHexalium = 1;
        this.integridadNave = 100;
    }

    // 🔹 Poder defensivo total
    public int calcularPoderDefensivo() {

        int poderEscudos = escudos * 80;
        int poderTorretas = torretasNeocromo * 40;
        int poderCanones = canonesHexalium * 70;

        return poderEscudos + poderTorretas + poderCanones;
    }

    // 🔹 Simular ataque automático
    public void recibirAtaque(int fuerzaEnemiga) {

        System.out.println("⚠️ Ataque enemigo detectado!");
        int poderDefensa = calcularPoderDefensivo();

        if (poderDefensa >= fuerzaEnemiga) {

            System.out.println("🛡️ La defensa ha repelido el ataque.");

            // Algunas torretas pueden dañarse
            dañarEstructuras(fuerzaEnemiga / 10);

        } else {

            int dañoRestante = fuerzaEnemiga - poderDefensa;

            System.out.println("💥 La defensa ha sido superada.");

            integridadNave -= dañoRestante / 5;

            if (integridadNave < 0) integridadNave = 0;

            dañarEstructuras(fuerzaEnemiga / 5);
        }

        mostrarEstado();
    }

    // 🔹 Dañar defensas
    private void dañarEstructuras(int impacto) {

        torretasNeocromo -= impacto / 20;
        canonesHexalium -= impacto / 25;

        if (torretasNeocromo < 0) torretasNeocromo = 0;
        if (canonesHexalium < 0) canonesHexalium = 0;
    }

    // 🔹 Reparación (para usar con TECHIES)
    public void reparar(int cantidad) {

        integridadNave += cantidad;
        if (integridadNave > 100) integridadNave = 100;
    }

    // 🔹 Construcción
    public void construirEscudo() {
        escudos++;
    }

    public void construirTorreta() {
        torretasNeocromo++;
    }

    public void construirCanon() {
        canonesHexalium++;
    }

    public void mostrarEstado() {

        System.out.println("---- DEFENSA ----");
        System.out.println("Escudos: " + escudos);
        System.out.println("Torretas Neocromo: " + torretasNeocromo);
        System.out.println("Cañones Hexalium: " + canonesHexalium);
        System.out.println("Integridad Nave: " + integridadNave);
        System.out.println("-----------------");
    }
}