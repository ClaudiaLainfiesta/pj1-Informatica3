import java.util.*;

public class solver1 {

    public solver1() {
        // Constructor vacío, si necesitas inicializar algo, hazlo aquí
    }

    public String solve(Maze maze) {
        Node start = maze.getStartingSpace();
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Si hemos llegado al nodo de salida
            if (current.getExit()) {
                return reconstructPath(cameFrom, current);
            }

            // Explorar vecinos válidos
            for (Node neighbor : getValidNeighbors(current, maze)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    cameFrom.put(neighbor, current);
                }
            }
        }
        // Si no se encuentra un camino válido
        return "[-1]";
    }

    // Obtener vecinos válidos evitando nodos peligrosos
    private List<Node> getValidNeighbors(Node node, Maze maze) {
        List<Node> neighbors = new ArrayList<>();
        
        Node north = maze.moveNorth(node);
        if (north != node && !north.danger) neighbors.add(north);
        
        Node south = maze.moveSouth(node);
        if (south != node && !south.danger) neighbors.add(south);
        
        Node west = maze.moveWest(node);
        if (west != node && !west.danger) neighbors.add(west);
        
        Node east = maze.moveEast(node);
        if (east != node && !east.danger) neighbors.add(east);
        
        Node up = maze.moveUp(node);
        if (up != node && !up.danger) neighbors.add(up);
        
        Node down = maze.moveDown(node);
        if (down != node && !down.danger) neighbors.add(down);

        return neighbors;
    }

    // Reconstrucción del camino para devolver el formato correcto
    private String reconstructPath(Map<Node, Node> cameFrom, Node current) {
        List<String> path = new ArrayList<>();
        while (current != null) {
            path.add("[" + current.xIndex + "," + current.yIndex + "," + current.zIndex + "]");
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return String.join(",", path);
    }
}
