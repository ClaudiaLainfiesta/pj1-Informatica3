// /*
//     Esta es su clase principal. El unico metodo que debe implementar es
//     public String[] solve(Maze maze)
//     pero es libre de crear otros metodos y clases en este u otro archivo que desee.
// */

// import java.util.ArrayList;
// import java.util.HashSet;
// import java.util.Set;

// public class Solver {

//     public Solver() {
//         // Constructor vacío
//     }

//     public String[] solve(Maze maze) {
//         ArrayList<String> path = new ArrayList<>();
//         Set<Node> visited = new HashSet<>();
//         Node start = maze.getStartingSpace();
//         if (findPathWithDrone(maze, start, path, visited)) {
//             return path.toArray(new String[0]);
//         } else {
//             return new String[]{"[-1]"};
//         }
//     }

//     private boolean findPathWithDrone(Maze maze, Node current, ArrayList<String> path, Set<Node> visited) {
//         if (current.isExit()) {
//             return true;
//         }

//         visited.add(current);
//         Node next;

//         // Simulación del dron moviéndose en diferentes direcciones
//         String[] directions = {"N", "S", "W", "E", "U", "D"};
//         Node[] moves = {
//             maze.moveNorth(current),
//             maze.moveSouth(current),
//             maze.moveWest(current),
//             maze.moveEast(current),
//             maze.moveUp(current),
//             maze.moveDown(current)
//         };

//         for (int i = 0; i < directions.length; i++) {
//             next = moves[i];
//             if (!visited.contains(next) && next != current) {
//                 path.add(directions[i]);
//                 if (findPathWithDrone(maze, next, path, visited)) return true;
//                 path.remove(path.size() - 1);
//             }
//         }

//         visited.remove(current);
//         return false;
//     }
// }
