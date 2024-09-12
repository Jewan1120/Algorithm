public class Main {

    static int cnt = 0;
    static int[] result = new int[10];
    static int[] arr = new int[10];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++)
            arr[i] = read();
        recursion(0);
        System.out.println(cnt);
    }

    private static void recursion(int depth) {
        if (depth == 10) {
            int answer = 0;
            for (int i = 0; i < 10; i++)
                if (arr[i] == result[i])
                    answer++;
            if (answer >= 5)
                cnt++;
            return;
        }
        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (i == result[depth - 1] && result[depth - 1] == result[depth - 2])
                    continue;
            }
            result[depth] = i;
            recursion(depth + 1);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}