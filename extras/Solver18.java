/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
import java.util.*;
public class Solver18{

    private ArrayList<String> caminos;
    private Maze mapa;
    private Node inicio;
    public Solver18(){
        //Sientase libre de implementar el contructor de la forma que usted lo desee

    }

    private void busquedaSalidas(Node actual, ArrayList<Node> nodosVisitados, String camino){
        if (mapa.moveNorth(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "N,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (mapa.moveWest(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "W,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (mapa.moveSouth(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "S,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (mapa.moveEast(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "E,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (mapa.moveUp(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "U,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (mapa.moveDown(actual) != actual || !nodosVisitados.contains(actual) || !actual.isDanger() || !actual.getExit()) {
            nodosVisitados.add(actual);
            camino += "D,";
            busquedaSalidas(actual, nodosVisitados, camino);
        } else if (actual.getExit()){
            nodosVisitados.add(actual);
            camino += "]";
        }
    }
    private void dron1(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveNorth(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "N,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }
    private void dron2(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveWest(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "W,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }
    private void dron3(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveSouth(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "S,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }
    private void dron4(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveEast(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "E,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }
    private void dron5(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveUp(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "U,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }
    private void dron6(){
        this.inicio = mapa.getStartingSpace();
        Node siguienteNodo = mapa.moveDown(this.inicio);
        String camino = "[";
        ArrayList<Node> nodosVisitados = new ArrayList<>();
        if(siguienteNodo != this.inicio){
            nodosVisitados.add(this.inicio);
            camino += "D,";
            busquedaSalidas(siguienteNodo, nodosVisitados, camino);
        }
    }

    public String caminoMasCorto() {
        if (caminos == null || caminos.isEmpty()) {
            return "[]";
        }
    
        String masCorto = caminos.get(0);
        for (String opcion : caminos) {
            if (opcion.length() < masCorto.length()) {
                masCorto = opcion;
            }
        }
        return masCorto;
    }

    public String solve(Maze maze){
        this.mapa = maze;
        dron1();
        dron2();
        dron3();
        dron4();
        dron5();
        dron6();
        //Implemente su metodo aqui. Sientase libre de implementar métodos adicionales
        return caminoMasCorto();
    }

}