import java.util.*;

public class Solver {
    private String caminoMasCorto;
    private Maze mapa;

    public Solver() {
        caminoMasCorto = null;
    }

    private void busquedaRecursiva(Node actual, String camino, Set<Node> visitados) {
        if (actual.getExit()) {
            if (caminoMasCorto == null || camino.length() < caminoMasCorto.length()) {
                caminoMasCorto = camino;
            }
            return;
        }
        visitados.add(actual);

        // Orden de exploración corregido: Sur, Este, Arriba, Norte, Oeste, Abajo
        Node siguiente = mapa.moveSouth(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "S", visitados);
        }
        siguiente = mapa.moveEast(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "E", visitados);
        }
        siguiente = mapa.moveUp(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "U", visitados);
        }
        siguiente = mapa.moveNorth(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "N", visitados);
        }
        siguiente = mapa.moveWest(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "W", visitados);
        }
        siguiente = mapa.moveDown(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "D", visitados);
        }

        visitados.remove(actual);
    }

    public String solve(Maze maze) {
        this.mapa = maze;
        this.caminoMasCorto = null;
        Set<Node> visitados = new HashSet<>();
        busquedaRecursiva(mapa.getStartingSpace(), "", visitados);

        if (caminoMasCorto == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < caminoMasCorto.length(); i++) {
            sb.append(caminoMasCorto.charAt(i));
            if (i < caminoMasCorto.length() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
