import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);


        while (true) {
            System.out.println(" Ingresa el numero  0 para finalizar el programa");
            System.out.println(" Ingresa el numero 1, para Digitar información el zombie");
            System.out.println(" Ingresa el numero 2, para mostrar la informacion de cada zombie");
            System.out.println(" Ingresa el numero 3, para mostrar la cantidad de zombies actuales");
            System.out.println(" Ingresa el numero 4, para mostrar zombies con sangre O+ y AB+");
            System.out.println(" Ingresa el numero 5, para mostrar zombies que nacieron depues del 2000");
            System.out.println(" Ingresa el numero 6, para disminuir la salud de todos los zombies a la mitad");
            System.out.println(" Ingresa el numero 7, para digitar nombre, distancia a Alexandria y cantidad de Zombies de una ubicación");
            System.out.println(" Ingresa el numero 8, para Mostar la informacion de todas las ubicacionbes hasta el momento");
            System.out.println(" Ingresa el numero 9, para Mostar la ubicacion mas segura y con menos zombies de la ciudad");
            System.out.println(" Ingresa el numero 10, para Mostar una lista de ubicaciones de la ciudad ordenadas de menor a mayor a alexandria");
            System.out.println(" Ingresa el numero 11, para Mostar una frase de zombies");
            System.out.println(" Ingresa el numero 12, para duplicar la salud de los zombies");
            int numeroInicial = entrada.nextInt();
            if (numeroInicial == 0) {
                break;
            }
            Principal.mostrarMenu(numeroInicial);

        }
    }

    public static void mostrarMenu(int numero_I) {

        while (true) {

            if (numero_I == 0) {
                break;
            }
            if (numero_I == 1) {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Ingresar el nombre del zombie");
                String nombre = entrada.next();
                System.out.println("Ingrese la salud del zombie");
                int salud = entrada.nextInt();
                System.out.println("Ingrese la fecha de nacimiento");
                String fechaNacimiento = entrada.next();
                System.out.println("Ingrese el tipo de sangre del zombie");
                String sangre = entrada.next().toUpperCase();

                Zombie nuevoZombie = new Zombie(nombre, salud, fechaNacimiento, sangre);

                nuevoZombie.setNombre(nombre);
                nuevoZombie.setSalud(salud);
                nuevoZombie.setFechaNacimiento(fechaNacimiento);
                nuevoZombie.setTipoSangre(sangre);
                break;


            }

            if (numero_I == 2) {
                Principal.mostrarInformacionZombie(Zombie.zombies);
                break;

            }
            if (numero_I == 3) {
                System.out.println(Zombie.contadorZombies);
                break;
            }
            if (numero_I == 4) {
                for (int i = 0; i < Zombie.zombies.size(); i++) {

                    if (Zombie.zombies.get(i).getTipoSangre().equalsIgnoreCase("O+") || Zombie.zombies.get(i).getTipoSangre().equalsIgnoreCase("AB+")) {
                        System.out.println(Zombie.zombies.get(i).toString());


                    }
                }
                break;
            }
            if (numero_I == 5) {

                for (int j = 0; j < Zombie.zombies.size(); j++) {
                    String Fecha = Zombie.zombies.get(j).getFechaNacimiento();
                    int Año = Integer.parseInt(Fecha.substring(6, 10));
                    if (Año > 2000) {
                        System.out.println(Zombie.zombies.get(j).toString());

                    }
                }
                break;
            }
            if (numero_I == 6) {
                Zombie.disminuirSalud(Zombie.zombies);
                break;

            }
            if (numero_I == 7) {
                Scanner entrada = new Scanner(System.in);
                System.out.println("Ingresar el nombre");
                String nombre = entrada.next();
                System.out.println("Ingrese la distancia a Alexandria");
                float distancia = entrada.nextInt();
                System.out.println("Ingrese la cantidad de zombies de la ubicación");
                int cantidadZombies = entrada.nextInt();

                Ubicacion nuevaUbicacion = new Ubicacion(nombre, distancia, cantidadZombies);
                /*nuevaUbicacion.setNombre(nombre);
                nuevaUbicacion.setDistanciaAlexandria(distancia);
                nuevaUbicacion.setCantidadZombies(cantidadZombies);*/
                break;
            }
            if (numero_I == 8) {
                Principal.mostrarInformacionUbicacion(Ubicacion.ubicaciones);
                break;
            }
            if (numero_I == 9) {
                System.out.println("La Ubicacion más segura es " + Ubicacion.lugarSeguro(Ubicacion.ubicaciones).toString());
                break;

            }
            if (numero_I == 10) {
                Collections.sort(Ubicacion.ubicaciones);
                Principal.mostrarInformacionUbicacion(Ubicacion.ubicaciones);

                break;


            }


            if (numero_I == 11) {
                int aleatorio = 0;

                aleatorio = (int) (Math.random() * 4);
                if (aleatorio == 0) {
                    System.out.println("Los zombies van a comer tu cerebro");
                }
                if (aleatorio == 1) {
                    System.out.println("Los zombies estan cerca");
                }

                if (aleatorio == 2) {
                    System.out.println("Los zombies entraron a la ciudad");
                }

                if (aleatorio == 3) {
                    System.out.println("Si te muerde un zombie te conviertes en uno");
                }

                if (aleatorio == 4) {
                    System.out.println("Para matar a un zombie debes dispararle en la cabeza");
                }

                break;
            }

            if (numero_I == 12) {

                    Zombie.zombiesAlimentados(Zombie.zombies);
                    System.out.println("Los zombies se han comido a tu familia");

                break;

            }
        }
    }



    public static void mostrarInformacionZombie( ArrayList<Zombie> zombies) {

        for (int i = 0; i < zombies.size(); i++) {
            System.out.println(zombies.get(i).toString());

        }
    }
    public static void mostrarInformacionUbicacion( ArrayList<Ubicacion> ubicaciones){
        for(int i = 0; i< ubicaciones.size(); i++){
            System.out.println(ubicaciones.get(i).toString());
        }
    }
}
