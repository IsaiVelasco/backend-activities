package traductor_con_json.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import traductor_con_json.model.Palabras;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaticController {
    public static List<Palabras> traducir (String palabra){

        List<Palabras> palabras = getWordsFromJson();
        List<Palabras> resultados = palabras.stream()
                .filter(item -> item.getEs().equals(palabra.toLowerCase()))
                .toList();
        return resultados;
    }
    public static List<Palabras> getWordsFromJson(){
        List<Palabras> palabrasFromJson = new ArrayList<>();
        File fileJson = new File("src/traductor_con_json/files/filejson.json");
        if(fileJson.exists()){
            //LEYENDO JSON FILE
            try {
                FileReader fileReader = new FileReader(fileJson);
                Type type = new TypeToken<ArrayList<Palabras>>(){}.getType();
                Gson gson = new Gson();
                palabrasFromJson = gson.fromJson(fileReader, type);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else System.out.println("Archivo no encontrado");
        return palabrasFromJson;
    }
    public static void addNewWord(Palabras newWords){
        File fileJson = new File("src/traductor_con_json/files/filejson.json");
        if(fileJson.exists()){
            try {
                List<Palabras> listToWrite = getWordsFromJson();
                listToWrite.add(newWords);

                FileWriter fileWriter = new FileWriter(fileJson);
                Gson newgson = new Gson();
                newgson.toJson(listToWrite, fileWriter);
                fileWriter.close();
                System.out.println("Palabra agregada.");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else System.out.println("Archivo no encontrado");
    }
    public static void executeComand(String[] command){

        String option = command[1].toLowerCase();
        List<String> lineas = getSigleLanguage(option,getWordsFromJson());

        if(lineas != null){
            String data = "";
            for (String line:lineas) {
                data+=line+"\n";
            }

            LocalDateTime date = LocalDateTime.now();
            File fichero = new File("src/traductor_con_json/files/"+option+"-"+formatear(date)+".txt");

            BufferedWriter bw = null;
            FileWriter fw = null;

            try {
                File file = fichero;
                if (!file.exists()) {
                    file.createNewFile();
                }
                // flag true, indica adjuntar información al archivo.
                fw = new FileWriter(file.getAbsoluteFile(), false);
                bw = new BufferedWriter(fw);
                bw.write(data);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    //Cierra instancias de FileWriter y BufferedWriter
                    if (bw != null)
                        bw.close();
                    if (fw != null)
                        fw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                System.out.println("Idioma " + command[1] + " exportado con exito");
            }
        }
    }

    private static String formatear(LocalDateTime currentDate){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return  formatDate.format(currentDate);
    }
    private static List<String> getSigleLanguage(String option, List<Palabras> palabras){
        List<String> siglesList = new ArrayList<>();
        boolean invalid = false;
        for (Palabras p:palabras
             ) {
            switch (option){
                case "ingles":
                    siglesList.add(p.getEn());
                    break;
                case "español":
                    siglesList.add(p.getEs());
                    break;
                case "frances":
                    siglesList.add(p.getFr());
                    break;
                default:
                    invalid=true;
                    break;
            }
        }
        if(invalid) {
            System.out.println("Opciones invalidas\n\"exportar [idioma]\"");
            siglesList = null;
        }
        return siglesList;
    }

}
