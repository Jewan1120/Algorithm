import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int rivalCost=sc.nextInt();
        int rivalPer=sc.nextInt();

        int rival=rivalPer/rivalCost;

        int warCost=sc.nextInt();
        int warPer=rival*3*warCost;

        System.out.println(warPer);
    }
}
