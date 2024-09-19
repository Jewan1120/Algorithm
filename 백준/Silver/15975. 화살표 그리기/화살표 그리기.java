import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            al.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = read(), y = read();
            al.get(y).add(x);
        }
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            ArrayList<Integer> subAl = al.get(i);
            if (subAl.size() < 2) {
                continue;
            }
            subAl.sort((o1, o2) -> o1 - o2);
            sum += subAl.get(1) - subAl.get(0);
            sum += subAl.get(subAl.size() - 1) - subAl.get(subAl.size() - 2);
            for (int j = 1; j < subAl.size() - 1; j++) {
                sum += Math.min(subAl.get(j) - subAl.get(j - 1), subAl.get(j + 1) - subAl.get(j));
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