// 3. Clase principal
public class Main {
    public static void main(String[] args) {
        // Probamos primero con 10 incrementos y luego con valores mayores (ej. 100.000 o 1.000.000)
        int incrementos = 10;

        System.out.println("--- PRUEBA CON " + incrementos + " INCREMENTOS POR HEBRA ---");
        ejecutarPrueba(incrementos);

        int incrementosGrandes = 100_000;
        System.out.println("\n--- PRUEBA CON " + incrementosGrandes + " INCREMENTOS POR HEBRA ---");
        ejecutarPrueba(incrementosGrandes);
    }

    private static void ejecutarPrueba(int incrementos) {
        VariableCompartida variable = new VariableCompartida(0);

        // Creamos las dos hebras compartiendo la misma instancia
        Thread hebra1 = new Thread(new TareaIncremento(variable, incrementos));
        Thread hebra2 = new Thread(new TareaIncremento(variable, incrementos));

        // Arrancamos las hebras
        hebra1.start();
        hebra2.start();

        // El hilo principal espera a que ambas hebras terminen con join()
        try {
            hebra1.join();
            hebra2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Mostramos el resultado final desde la hebra principal
        int resultadoEsperado = incrementos * 2;
        System.out.println("Valor esperado: " + resultadoEsperado);
        System.out.println("Valor final de v: " + variable.get());
    }
}