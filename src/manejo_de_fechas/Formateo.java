package manejo_de_fechas;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Formateo {
    public static void main(String[] args) {
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("DateTimeFormater\n"+formatDate.format(currentDate));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("SimpleDateFormat");
        System.out.println(simpleDateFormat.format(Date.from(currentDate.toInstant(ZoneOffset.UTC))));
    }
}
