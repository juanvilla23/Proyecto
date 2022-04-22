import java.util.ArrayList;
public class Zombie {
    private String nombre;
    private int salud;
    private String fechaNacimiento;
    private String tipoSangre;
    public static int contadorZombies = 0;
    public static ArrayList<Zombie> zombies = new ArrayList<>();

    public Zombie(String nombre, int salud, String fechaNacimiento, String tipoSangre) {
        this.nombre = nombre;
        this.salud = salud;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSangre = tipoSangre;
        Zombie.zombies.add(this);
        Zombie.contadorZombies++;
    }

    public void setNombre(String nombre_) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getSalud() {
        return this.salud;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public String getTipoSangre() {
        return this.tipoSangre;
    }

    public String toString() {
        return "El nombre del zombie es: " + this.nombre + " La salud del zombie es: " + this.salud + " Fecha de nacimiento: " + this.fechaNacimiento + " Sangre: " + this.tipoSangre;
    }

    public static void disminuirSalud(ArrayList<Zombie> zombies) {
        for (int i = 0; i < zombies.size(); i++) {
            zombies.get(i).setSalud(zombies.get(i).getSalud() / 2);

        }
    }

    public static void eliminarZombies(ArrayList<Zombie> zombies) {

        for (int i = 0; i < zombies.size(); i++) {
            zombies.remove(i);
        }
    }

    public static void zombiesAlimentados(ArrayList<Zombie> zombies) {
        for (int i = 0; i < zombies.size(); i++) {
            zombies.get(i).setSalud(zombies.get(i).getSalud() * 2);
        }
    }
}

