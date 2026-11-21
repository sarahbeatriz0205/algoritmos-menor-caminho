package ui;
import javax.swing.*;
// import grafo.Grafo;

public class Labirinto {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menor Caminho - Dijkstra e A*");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JButton buttonCriarGrafo = new JButton("Criar grafo");

        buttonCriarGrafo.addActionListener(e -> {
            // Grafo grafo = new Grafo();
            JButton buttonDijkstra = new JButton("Usar Dijkstra");
            JButton buttonAEstrela = new JButton("Usar A*");
            panel.add(buttonDijkstra);
            panel.add(buttonAEstrela);
            buttonCriarGrafo.setEnabled(false);
            panel.revalidate();
            panel.repaint();
        });
        panel.add(buttonCriarGrafo);
       
        frame.add(panel);
        frame.setVisible(true);
    }
}
