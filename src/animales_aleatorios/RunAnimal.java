package animales_aleatorios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RunAnimal {
    public static void main(String[] args) throws InterruptedException {
        List<Animal> animales = new ArrayList<>();
        List<Animal> multiplos = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            Animal x = new Animal(1);
            animales.add(x);
            if(i%1000==0) multiplos.add(x);
        }

        for (Animal animal:multiplos
             ) {
            System.out.println(animal.toString());
            System.out.println("Esperando "+formatear(LocalDateTime.now())+"...");
            Thread.sleep(2000);
        }

        int leones = animales.stream().filter(animal -> animal.getTipo().equals("León")).toArray().length;
        int gatos = animales.stream().filter(animal -> animal.getTipo().equals("Gato")).toArray().length;
        int perros = animales.stream().filter(animal -> animal.getTipo().equals("Perro")).toArray().length;
        int venados = animales.stream().filter(animal -> animal.getTipo().equals("Venado")).toArray().length;
        int elefantes = animales.stream().filter(animal -> animal.getTipo().equals("Elefante")).toArray().length;

        System.out.printf("Resumen: hay %d Leones, %d Gatos, %d Perros, %d Venados, %d Elefantes",
                leones, gatos, perros, venados, elefantes);
    }
    public static String formatear(LocalDateTime currentDate){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("HH:mm:ss");
        return  formatDate.format(currentDate);
    }
}
