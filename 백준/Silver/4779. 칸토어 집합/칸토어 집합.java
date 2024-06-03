import java.util.Arrays;
public class Main {

    public static void main(String[] args) throws Exception {
        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = read()) < 13) {
            int len = (int) Math.pow(3, n);
            char[] arr = new char[len];
            Arrays.fill(arr, ' ');
            cantor(arr, 0, len);
            sb.append(arr).append("\n");
        }
        System.out.println(sb);
    }

    private static void cantor(char[] arr, int l, int r) {
        if (r - l == 1) {
            arr[l] = '-';
            return;
        }
        cantor(arr, l, l + ((r - l) / 3));
        cantor(arr, l + (2 * (r - l) / 3), r);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}