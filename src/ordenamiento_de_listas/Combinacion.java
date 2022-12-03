package ordenamiento_de_listas;

import java.util.*;

public class Combinacion {
    public static void main(String[] args) {
        ArrayList<Character> list1 = new ArrayList<>(Arrays.asList('A', 'B', 'C', 'D', 'E'));
        ArrayList<Character> list2 = new ArrayList<>(Arrays.asList('B', 'D', 'F', 'G', 'H'));
        list1.addAll(list2);
        List<Character>listaMezcla = new ArrayList<>(new HashSet<>(list1));
        System.out.println(listaMezcla);
    }
}
