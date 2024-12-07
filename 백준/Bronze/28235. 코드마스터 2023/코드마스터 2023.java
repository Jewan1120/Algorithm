import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.equals("SONGDO"))
            System.out.println("HIGHSCHOOL");
        else if (str.equals("CODE"))
            System.out.println("MASTER");
        else if (str.equals("2023"))
            System.out.println("0611");
        else
            System.out.println("CONTEST");
    }
}