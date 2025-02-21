/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
import java.util.*;
public class Solver100{

    private List<> caminos;

    public Solver100(){
        //Sientase libre de implementar el contructor de la forma que usted lo desee
    }

    public String caminoMasCorto(){
        if(caminos == null || caminos.length == 0){
            return "[]";
        }

        String masCorto = caminos[0];
        for(String opcion : caminos){
            if(opcion.length() < masCorto.length()){
                masCorto = opcion;
            }
        }
        return masCorto;
    }

    public String solve(Maze maze){
        //Implemente su metodo aqui. Sientase libre de implementar métodos adicionales
        return caminoMasCorto();
    }

}