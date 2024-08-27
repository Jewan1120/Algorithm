import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int q = read();
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        while (q-- > 0) {
            int oper = read();
            if (oper == 1) {
                int p = read();
                tm.put(p, tm.getOrDefault(p, 0) + 1);
            } else if (oper == 2) {
                int p = read();
                if (tm.containsKey(p)) {
                    if (tm.get(p) == 1) {
                        tm.remove(p);
                    } else {
                        tm.put(p, tm.get(p) - 1);
                    }
                }
            } else {
                int pages = 0;
                if (!tm.isEmpty()) {
                    Integer boundary = tm.firstKey();
                    pages++;
                    while ((boundary = tm.higherKey(boundary * 2 - 1)) != null) {
                        pages++;
                    }
                }
                sb.append(pages).append("\n");
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