 /*
//     Esta es su clase principal. El unico metodo que debe implementar es
//     public String[] solve(Maze maze)
//     pero es libre de crear otros metodos y clases en este u otro archivo que desee.
// */
// public class solver{
//     //Variable "global" para guardar todos los caminos posibles
//     private String[] caminos;
//     private Maze mapa;
    
//     public solver22(){
//         // Constructor vacío
//     }

//     // Método recursivo para buscar caminos válidos
//     private void busquedaRecursiva(Node actual, String camino, Set<Node> visitados){
//         if(actual.isExit()){
//             // Al llegar a la salida, agregar el camino a la lista de caminos
//             ArrayList<String> listaCaminos = new ArrayList<>(Arrays.asList(caminos));
//             listaCaminos.add(camino);
//             caminos = listaCaminos.toArray(new String[0]);
//             return;
//         }
        
//         visitados.add(actual);
//         Node siguiente;
        
//         // Probar cada dron (dirección)
//         siguiente = mapa.moveNorth(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "N", visitados);
//         }

//         siguiente = mapa.moveSouth(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "S", visitados);
//         }

//         siguiente = mapa.moveWest(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "W", visitados);
//         }

//         siguiente = mapa.moveEast(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "E", visitados);
//         }

//         siguiente = mapa.moveUp(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "U", visitados);
//         }

//         siguiente = mapa.moveDown(actual);
//         if(!visitados.contains(siguiente)){
//             busquedaRecursiva(siguiente, camino + "D", visitados);
//         }

//         visitados.remove(actual);
//     }

//     public String caminoMasCorto(){
//         if(caminos == null || caminos.length == 0){
//             return "[]";
//         }

//         String masCorto = caminos[0];
//         for(String opcion : caminos){
//             if(opcion.length() < masCorto.length()){
//                 masCorto = opcion;
//             }
//         }
//         return masCorto;
//     }

//     public String solve(Maze maze){
//         this.mapa = maze;
//         this.caminos = new String[0];
//         Set<Node> visitados = new HashSet<>();
//         busquedaRecursiva(mapa.getStartingSpace(), "", visitados);
//         return caminoMasCorto();
//     }
// }
