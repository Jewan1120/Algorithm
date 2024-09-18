import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        PriorityQueue<int[]> weightDq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int i = 0; i < n; i++)
            weightDq.add(new int[] { read(), read() });
        int[] bags = new int[k];
        for (int i = 0; i < k; i++)
            bags[i] = read();
        Arrays.sort(bags);
        long sum = 0;
        PriorityQueue<Integer> valueDq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            while (!weightDq.isEmpty() && weightDq.peek()[0] <= bags[i])
                valueDq.add(weightDq.poll()[1]);
            if (!valueDq.isEmpty())
                sum += valueDq.poll();
        }
        System.out.println(sum);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}