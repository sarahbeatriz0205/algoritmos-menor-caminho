package menor_caminho;
import java.util.Vector;
import auxiliar.Auxiliar;
import grafo.Adjacencia;
import grafo.Grafo;
import grafo.Vertice;

public class MenorCaminho {
    private Grafo grafo;

    public MenorCaminho(Grafo grafo) {
        this.grafo = grafo;
    }

    // para dijkstra e o custo real (g(n)) no A*
    private int encontraDistancia(Vertice v1, Vertice v2) {
        for (Adjacencia adj : v1.getAdjacencias()) {
                if (adj.getVertice().equals(v2)) {
                    return adj.getValor(); // resolvi guardar o valor na adjacencia, mas nao adiantou muita coisa
                }
            }
        return Integer.MAX_VALUE; // simula o infinito. se nao existir adjacencia, nao existe distancia, então é infinito
    }

    // menor custo computacional e funciona indo pra todos os lados. nao sei se ta certo
    private int heuristicaChebyshev(Vertice v1, Vertice v2) {
        int absCoordenadasX = Math.abs(v1.getCoordenadaX() - v2.getCoordenadaX());
        int absCoordenadasY = Math.abs(v1.getCoordenadaY() - v2.getCoordenadaY());
        return Math.max(absCoordenadasX, absCoordenadasY);
    }

    public Auxiliar[] executaDijkstra(Vertice origem) {
        Vector<Vertice> verticesTotais = this.grafo.getVertices();
        Vector<Vertice> visitados = new Vector<>();
        visitados.add(origem); // começa adicionando o vertice inicial 
        Auxiliar[] distancias = new Auxiliar[this.grafo.getNumVertices()];

        // popula distancias iniciais
        for (int i=0; i < verticesTotais.size(); i++) {
            Vertice v = verticesTotais.get(i);
            if (v == origem) {
                distancias[i] = new Auxiliar(0, null);
            }
            else {
                distancias[i] = new Auxiliar(encontraDistancia(origem, v), origem);
            }
        }

        while (visitados.size() < verticesTotais.size()) {
            // setar infinito como menor. operacao segura, pq o menor é só pra comparar
            int menor = Integer.MAX_VALUE; int indiceMenor = -1;
            for (int i=0; i < distancias.length; i++) { 
                // verifica se o vertice atual ja foi visitado, ou seja, se existe na nuvem
                if (!visitados.contains(verticesTotais.get(i))) {
                    if (distancias[i].getDistancia() < menor) {
                        menor = distancias[i].getDistancia();
                        indiceMenor = i; // pra que a adição na nuvem seja O(1)
                    }
                }
                
            }
            Vertice w = this.grafo.getVertices().get(indiceMenor);
            visitados.add(w);
            distancias[indiceMenor].setDistancia(menor);

            for (Vertice v : verticesTotais) {
                if (visitados.contains(v)) { // se v ja foi visitado, ignora o vertice e vai pra a proxima iteracao
                    continue; 
                }

                int somaDistancias = 0;
                if (distancias[w.getId()].getDistancia() == Integer.MAX_VALUE || encontraDistancia(w, v) == Integer.MAX_VALUE) {
                    somaDistancias = distancias[v.getId()].getDistancia();
                    continue;
                }
                else {
                    somaDistancias = distancias[w.getId()].getDistancia() + encontraDistancia(w, v);
                }

                if (somaDistancias < distancias[v.getId()].getDistancia()) {
                    distancias[v.getId()].setDistancia(somaDistancias);
                    distancias[v.getId()].setAntecessor(w);
                }
                else {
                    distancias[v.getId()].setDistancia(Math.min(distancias[v.getId()].getDistancia(), somaDistancias));
                }   
            }    
        }
        return distancias;
    }

    // errado
    public void executaAEstrela(Vertice origem, Vertice destino) {
        Vector<Vertice> listaAberta = new Vector<>(); 
        Vector<Vertice> listaFechada = new Vector<>(); 
        listaAberta.add(origem);
        Vector<Adjacencia> listaAtual = origem.getAdjacencias();
        Vertice verticePai = origem;

        while (listaAtual.size() > 0) { // enquanto ainda houver distancia pra calcular na primeira passada
            
        }
    }
}