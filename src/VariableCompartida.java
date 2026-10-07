// 1. Clase que encapsula la variable compartida
class VariableCompartida {
    private int v;

    public VariableCompartida(int valorInicial) {
        this.v = valorInicial;
    }

    public int get() {
        return this.v;
    }

    public void set(int v) {
        this.v = v;
    }

    // Método que incrementa el valor de v
    public void inc() {
        // En una sola línea o simulando lectura-modificación-escritura:
        this.v = this.v + 1;
    }
}