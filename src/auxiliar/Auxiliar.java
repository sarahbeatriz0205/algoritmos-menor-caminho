package auxiliar;
import grafo.Vertice;

// par que vai na lista de distancias, que vai guardar a distancia atual e o antecessor
public class Auxiliar {
    private int distancia;
    private Vertice antecessor;

    public Auxiliar(int distancia, Vertice antecessor) {
        this.distancia = distancia;
        this.antecessor = antecessor;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public Vertice getAntecessor() {
        return this.antecessor;
    }

    public void setDistancia(int d) {
        this.distancia = d;
    }

    public void setAntecessor(Vertice v) {
        this.antecessor = v;
    }
}
