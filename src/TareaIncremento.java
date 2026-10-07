// 2. Tarea que ejecutarán las hebras
class TareaIncremento implements Runnable {
    private final VariableCompartida variable;
    private final int numIncrementos;

    public TareaIncremento(VariableCompartida variable, int numIncrementos) {
        this.variable = variable;
        this.numIncrementos = numIncrementos;
    }

    @Override
    public void run() {
        for (int i = 0; i < numIncrementos; i++) {
            variable.inc();
        }
    }
}