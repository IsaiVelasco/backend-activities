package traductor_con_json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import traductor_con_json.controller.StaticController;
import traductor_con_json.controller.ViewControler;
import traductor_con_json.model.Palabras;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            ViewControler.executeInteraction(br);
        }while (ViewControler.finish(br));

    }


}
