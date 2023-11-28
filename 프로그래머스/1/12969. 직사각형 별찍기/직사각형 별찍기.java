import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append(("*".repeat(a) + "\n").repeat(b));
        System.out.println(sb.toString());
    }
}