package traductor_con_json.controller;

import traductor_con_json.model.Palabras;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class ViewControler {

    public static void executeInteraction(BufferedReader br){
        String palabra = ViewControler.solicitarInput(br);

        if (palabra.split(" ").length == 2){
            System.out.println("Generando archivo...");
            StaticController.executeComand(palabra.split(" "));
        }else if(!palabra.isEmpty()){
            List<Palabras> results = StaticController.traducir(palabra);

            if(!results.isEmpty()){
                System.out.println(results);
            }else if (ViewControler.questionToAdd(br)){
                Palabras newWords = ViewControler.requesTranslation(br, palabra);

                if(newWords != null){
                    StaticController.addNewWord(newWords);
                }
            }
        }
    }
    public static String solicitarInput(BufferedReader br){
        System.out.print("-------------------------------------------------" +
                "\nEscribe \"exportar [nombre-idioma]\" para exportar" +
                "\nO escribe una palabra para traducirla" +
                "\n-------------------------------------------------" +
                "\n\\INPUT> ");
        String palabra = "";
        try { palabra = br.readLine();}
        catch (IOException e) {System.out.println(e.getMessage()); }

        return palabra;
    }
    public static boolean questionToAdd(BufferedReader br){
        boolean res = false;
        System.out.print("\nPalabra sin traducción" +
                "\nDeseas agregar una traduccion? Y/N" +
                "\n-------------------------------------------------" +
                "\n\\INPUT> ");

        String input = "";
        try { input = br.readLine();}
        catch (IOException e) {System.out.println(e.getMessage()); }
        if(input.equalsIgnoreCase("Y")) res = true;
        return res;
    }
    public static Palabras requesTranslation(BufferedReader br, String palabra){
        Palabras newWord = null;
        String en = "";
        String fr = "";
        boolean correcto = true;
        try {
            do {
                System.out.print("\nIngresa el significado de "+palabra +" en INGLES> ");
                en = br.readLine();
                System.out.print("\nIngresa el significado de "+palabra +" en FRANCES> ");
                fr = br.readLine();
                if(en.isEmpty() | fr.isEmpty()){
                    System.out.println("No ingrese cadenas vacias");
                    correcto = false;
                }
            }while (!correcto);

            newWord = new Palabras(palabra.toLowerCase(), en.toLowerCase(), fr.toLowerCase());
        }
        catch (IOException e) {System.out.println(e.getMessage()); }
        return newWord;
    }
    public static boolean finish(BufferedReader br){
        System.out.print("\nDESEAS INTENTAR DE NUEVO? Y/N" +
                "\n-------------------------------------------------" +
                "\n\\INPUT> ");

        String input = "";
        try { input = br.readLine();}
        catch (IOException e) {System.out.println(e.getMessage()); }

        if(input.equalsIgnoreCase("Y")) return true;
        return false;
    }
}
