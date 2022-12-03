package manejo_de_fechas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SumasDuration {
    public static void main(String[] args) {
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println(formatear(ahora));
        LocalDateTime futuro = LocalDateTime.now();
        futuro = futuro.plusHours(5);
        System.out.println(formatear(futuro));

        Duration duration =  Duration.between(ahora,futuro);
        System.out.println(duration.toMinutes()+" Minutos in between");
        System.out.println(duration.toHours()+" Horas in between");
    }
    public static String formatear(LocalDateTime currentDate){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return  formatDate.format(currentDate);
    }
}
