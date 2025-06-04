import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        if(arr[0] < arr[1] && arr[1] < arr[2] && arr[2] < arr[3]) System.out.printf("Fish Rising");
        else if(arr[0] > arr[1] && arr[1] > arr[2] && arr[2] > arr[3]) System.out.printf("Fish Diving");
        else if(arr[0] == arr[1] && arr[1] == arr[2] && arr[2] == arr[3]) System.out.printf("Fish At Constant Depth");
        else System.out.printf("No Fish");
    }
}