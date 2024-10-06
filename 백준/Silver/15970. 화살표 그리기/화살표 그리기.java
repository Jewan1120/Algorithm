import java.util.ArrayList;

public class Main {

    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 0; i < n + 1; i++)
            al.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = read(), y = read();
            al.get(y).add(x);
        }
        for (int i = 0; i < n + 1; i++)
            al.get(i).sort((o1, o2) -> o1 - o2);
        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            int size = al.get(i).size();
            for (int j = 0; j < size; j++) {
                int left = 100_001, right = 100_001;
                if (j > 0)
                    left = al.get(i).get(j) - al.get(i).get(j - 1);
                if (j < size - 1)
                    right = al.get(i).get(j + 1) - al.get(i).get(j);
                sum += Math.min(left, right);
            }
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