/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
public class Solver {
    private Maze maze;

    public Solver(Maze maze) {
        //Sientase libre de implementar el contructor de la forma que usted lo desee
        this.maze = maze;
    }

    public String solve(Maze maze){
        //Implemente su metodo aqui. Sientase libre de implementar métodos adicionales
        return "[-1]";
    }

    //Metodo que nos dice que camara tiene peligro y cual no.
    public void peligro() {
        Node[][][] nodes = maze.getNodes();
        Node[][][] safeNodes = new Node[maze.getWidth()][maze.getHeight()][maze.getDepth()];

        for (int z = 0; z < maze.getDepth(); z++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                for (int x = 0; x < maze.getWidth(); x++) {
                    Node currentNode = nodes[x][y][z];

                    if (!currentNode.danger) {
                        safeNodes[x][y][z] = currentNode;
                    }
                }
            }
        }
        Maze safeMaze = new Maze(safeNodes, maze.getWidth(), maze.getHeight(), maze.getDepth());

        // for (int z = 0; z < maze.getDepth(); z++) {
        //     for (int y = 0; y < maze.getHeight(); y++) {
        //         for (int x = 0; x < maze.getWidth(); x++) {
        //             Node currentNode = safeNodes[x][y][z];

        //             if (currentNode != null) {
        //                 System.out.println("Cámara segura en (" + x + ", " + y + ", " + z + ")");
        //             }
        //         }
        //     }
        // }
        System.out.println("Maze original:");
        for (int z = 0; z < maze.getDepth(); z++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                for (int x = 0; x < maze.getWidth(); x++) {
                    Node currentNode = nodes[x][y][z];

                    if (currentNode.danger) {
                        System.out.println("Cámara en (" + x + ", " + y + ", " + z + ") tiene peligro.");
                    } else {
                        System.out.println("Cámara en (" + x + ", " + y + ", " + z + ") está segura.");
                    }
                }
            }
        }
        System.out.println("Maze ya seguro:");
        for (int z2 = 0; z2 < safeMaze.getDepth(); z2++) {
            for (int y2 = 0; y2 < safeMaze.getHeight(); y2++) {
                for (int x2 = 0; x2 < safeMaze.getWidth(); x2++) {
                    Node currentNode2 = nodes[x2][y2][z2];

                    if (currentNode2.danger) {
                        System.out.println("Cámara en (" + x2 + ", " + y2 + ", " + z2 + ") tiene peligro.");
                    } else {
                        System.out.println("Cámara en (" + x2 + ", " + y2 + ", " + z2 + ") está segura.");
                    }
                }
            }
        }
    }

        public static void main(String[] args) throws Exception {
            Maze maze = new Maze("prueba.txt");
            Solver solver = new Solver(maze);
            solver.peligro();
        }

    
}
