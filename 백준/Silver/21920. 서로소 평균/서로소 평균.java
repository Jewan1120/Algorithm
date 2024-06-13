import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(), arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();
        int x = read();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 2; i <= x; i++)
            if (x % i == 0) al.add(i);
        double sum = 0, cnt = 0;
        next: for (int num : arr) {
            for (int div : al)
                if (num % div == 0) continue next;
            sum += num;
            cnt++;
        }
        System.out.println(sum / cnt);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}