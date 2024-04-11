import java.time.LocalDate;
import java.time.ZoneId; 
public class Main {
    public static void main(String[] args) {
        System.out.print(LocalDate.now(ZoneId.of("Asia/Seoul")));
    }
}