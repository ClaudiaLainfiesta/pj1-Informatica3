/*
    Esta es su clase principal. El unico metodo que debe implementar es
    public String[] solve(Maze maze)
    pero es libre de crear otros metodos y clases en este u otro archivo que desee.
*/
public class Solver{

    private String[] caminos;

    public Solver(String[] caminos){
        //Sientase libre de implementar el contructor de la forma que usted lo desee
    }

    private void busquedaSalidas(){

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