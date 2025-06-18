import java.util.Scanner;
 
public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        int testCase = sc.nextInt();
        
        for (int i = 1; i <= testCase; i++) {
            int maxNum = 0;
            for (int j = 0; j < 5; j++) {
                int inputNum = sc.nextInt();
                if (maxNum < inputNum) maxNum = inputNum;
            }
            
            System.out.println("Case #" + i + ": " + maxNum);
        }
    }
}