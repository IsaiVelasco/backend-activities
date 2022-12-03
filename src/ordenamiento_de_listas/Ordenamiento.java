package ordenamiento_de_listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenamiento {
    public static void main(String[] args) {
        List<Integer> enterosAleatorios = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            enterosAleatorios.add((int) (Math.random()*1000+1));
        }

        System.out.println("Numeros generados:\n"+enterosAleatorios);
        Collections.sort(enterosAleatorios);
        System.out.println("Numeros ordenados:\n"+enterosAleatorios);
        Collections.reverse(enterosAleatorios);
        System.out.println("Numeros invertidos:\n"+enterosAleatorios);
    }
}
