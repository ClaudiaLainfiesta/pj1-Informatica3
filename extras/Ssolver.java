import java.util.*;

public class Solver18 {
    // Variable "global" para guardar todos los caminos posibles
    private List<String> caminos;
    private Maze mapa;

    public Solver() {
        // Constructor vacío
        caminos = new ArrayList<>();
    }

    // Método recursivo para buscar caminos válidos
    private void busquedaRecursiva(Node actual, String camino, Set<Node> visitados) {
        if (actual.getExit()) {
            // Al llegar a la salida, agregar el camino a la lista de caminos
            caminos.add(camino);
            return;
        }

        visitados.add(actual);

        // Probar cada dirección en el orden especificado: N, W, S, E, U, D
        Node siguiente = mapa.moveNorth(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "N", visitados);
        }

        siguiente = mapa.moveWest(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "W", visitados);
        }

        siguiente = mapa.moveSouth(actual);
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

        siguiente = mapa.moveDown(actual);
        if (siguiente != null && !visitados.contains(siguiente)) {
            busquedaRecursiva(siguiente, camino + "D", visitados);
        }

        visitados.remove(actual);
    }

    public String caminoMasCorto() {
        if (caminos.isEmpty()) {
            return "[]";
        }

        // Encontrar el camino más corto
        String masCorto = caminos.get(0);
        for (String opcion : caminos) {
            if (opcion.length() < masCorto.length()) {
                masCorto = opcion;
            }
        }

        // Formatear el camino más corto como un array de direcciones
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < masCorto.length(); i++) {
            sb.append(masCorto.charAt(i));
            if (i < masCorto.length() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public String solve(Maze maze) {
        this.mapa = maze;
        this.caminos.clear(); // Limpiar la lista de caminos
        Set<Node> visitados = new HashSet<>();
        busquedaRecursiva(mapa.getStartingSpace(), "", visitados);
        return caminoMasCorto();
    }
}