import java.util.ArrayList;


public class Ubicacion  implements Comparable<Ubicacion> {
    private String nombre;
    private float distanciaAlexandria;
    private int cantidadZombies;
    public static ArrayList<Ubicacion> ubicaciones = new ArrayList<>();

    public Ubicacion(String nombre, float distanciaAlexandria, int cantidadZombies) {
        this.nombre = nombre;
        this.distanciaAlexandria = distanciaAlexandria;
        this.cantidadZombies = cantidadZombies;
        Ubicacion.ubicaciones.add(this);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDistanciaAlexandria(float distanciaAlexandria) {

        this.distanciaAlexandria = distanciaAlexandria;
    }

    public void setCantidadZombies(int cantidadzombies) {

        this.cantidadZombies = cantidadzombies;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getDistanciaAlexandria() {
        return this.distanciaAlexandria;
    }

    public int getCantidadZombies() {
        return this.cantidadZombies;
    }

    public String toString() {
        return "Nombre: " + this.nombre + " Distancia: " + this.distanciaAlexandria + " Cantidad de zombies: " + this.cantidadZombies;
    }

    public static Ubicacion lugarSeguro(ArrayList<Ubicacion> ubicaciones) {
        Ubicacion menor = ubicaciones.get(0);
        int menorNumero = ubicaciones.get(0).getCantidadZombies();
        for (int i = 1; i < ubicaciones.size(); i++) {
            if (ubicaciones.get(i).getCantidadZombies() < menorNumero) {
                menor = ubicaciones.get(i);
            }
        }
        return menor;
    }

    public static ArrayList<Ubicacion> ordenarArreglo(ArrayList<Ubicacion> ubicaciones) {
        int n = ubicaciones.size();
        Ubicacion temporal;

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ubicaciones.get(j).getDistanciaAlexandria() < ubicaciones.get(j + 1).getDistanciaAlexandria()) {
                    temporal = ubicaciones.get(j);
                    ubicaciones.set(j, ubicaciones.get(j + 1));
                    ubicaciones.set(j + 1, temporal);
                }
            }
        }
        return ubicaciones;
    }
    public int compareTo(Ubicacion ubicacion){
        if(ubicacion.getDistanciaAlexandria()>distanciaAlexandria){
            return -1;
        }else if(ubicacion.getDistanciaAlexandria()==distanciaAlexandria){
            return 0;
        }else{
            return 1;
        }
    }
}



