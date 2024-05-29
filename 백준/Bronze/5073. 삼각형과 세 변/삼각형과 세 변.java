import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while(true) {
            int[] arr = {read(), read(), read()};
            if (arr[0] == 0) break;
            Arrays.sort(arr);
            if (arr[0] + arr[1] <= arr[2]) {
                sb.append("Invalid\n");
            } else {
                if (arr[0] == arr[1] && arr[0] == arr[2]) {
                    sb.append("Equilateral\n");
                } else if (arr[0] != arr[1] && arr[0] != arr[2] && arr[1] != arr[2]) {
                    sb.append("Scalene\n");
                } else {
                    sb.append("Isosceles\n");
                }
            }
        }
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}