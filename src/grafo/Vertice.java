package grafo;
import java.util.Vector;

public class Vertice {
    private int verticeId;
    private int grauEntrada; 
    private int grauSaida;
    private Object elemento;
    private Vector<Adjacencia> adjacentes;
    private int coordenadaX; 
    private int coordenadaY;

    // para o A*
    private int distanciaReal; // g(n)
    private int distanciaHeuristica; // h(n)
    private int custoTotal; // f(n)

    public Vertice(Object elemento, int numVertices, int coordenadaX, int coordenadaY) {
        this.elemento = elemento;
        this.verticeId = numVertices+1;
        this.adjacentes = new Vector<Adjacencia>();
        this.grauSaida = 0;
        this.grauEntrada = 0;
        this.distanciaReal = 0;
        this.distanciaHeuristica = 0;
        this.custoTotal = 0;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Vector<Adjacencia> getAdjacencias() {
        return this.adjacentes;
    }

    public int getGrau() {
        return this.grauSaida;
    }

    public int getGrauEntrada() {
        return this.grauEntrada;
    }

    public int getId() {
        return this.verticeId;
    }

    public Object getElemento() {
        return this.elemento;
    }

    public int getDistanciaReal() {
        return this.distanciaReal;
    }

    public int getDistanciaHeuristica() {
        return this.distanciaHeuristica;
    }

    public int getCustoTotal() {
        return this.custoTotal;
    }

    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    public void substituir(Object elemento) {
        this.elemento = elemento;
    }

    public void setGrau(int grau) {
        this.grauSaida = grau;
    }

    public void setGrauEntrada(int grau) {
        this.grauEntrada = grau;
    }

    public void setAdjacencia(Vector<Adjacencia> adjacencias) {
        this.adjacentes = adjacencias;
    }

    public void setDistanciaReal(int distanciaReal) {
        this.distanciaReal = distanciaReal;
    }

    public void setDistanciaHeuristica(int distanciaHeuristica) {
        this.distanciaHeuristica = distanciaHeuristica;
    }

    public void setCustoTotal(int custoTotal) {
        this.custoTotal = custoTotal;
    }
}