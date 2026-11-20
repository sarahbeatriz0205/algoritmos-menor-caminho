package grafo;

public class Adjacencia {
    private Vertice vertice;
    private Aresta aresta;
    private int valor; // distancia presente na aresta

    public Adjacencia(Vertice vertice, Aresta aresta, int valor) {
        this.vertice = vertice;
        this.aresta = aresta;
        this.valor = valor;
    }

    public Vertice getVertice() {
        return this.vertice;
    }

    public Aresta getAresta() {
        return this.aresta;
    }

    public int getValor() {
        return this.valor;
    }
}