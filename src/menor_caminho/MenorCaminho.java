package menor_caminho;
import java.util.Vector;
import grafo.Adjacencia;
import grafo.Grafo;
import grafo.Vertice;

public class MenorCaminho {
    private Grafo grafo;

    public MenorCaminho(Grafo grafo) {
        this.grafo = grafo;
    }

    private int encontraDistancia(Vertice v1, Vertice v2) {
        if (this.grafo.ehAdjacente(v1, v2)) {
            for (Adjacencia adj : v1.getAdjacencias()) {
                if (adj.getVertice() == v2) {
                    return adj.getAresta().getValor();
                }
            }
        }
        return Integer.MAX_VALUE; // simula o infinito. se nao existir adjacencia, nao existe distancia, então é infinito
    }

    public void executaDijkstra(Vertice origem) {
        Vector<Vertice> visitados = new Vector<>();
        visitados.add(origem); // começa adicionando o vertice inicial 
        int[] distancias = new int[this.grafo.getNumVertices()];

        for (int i=0; i < this.grafo.getVertices().size(); i++) {
            Vertice v = this.grafo.getVertices().get(i);
            if (v == origem) {
                distancias[i] = 0;
            }
            else {
                distancias[i] = encontraDistancia(origem, v);
            }
        }

        while (visitados != this.grafo.getVertices()) {
            // ????
        }


    }

    public void executaAEstrela(Vertice origem) {
        
    }
}