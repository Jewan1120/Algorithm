public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int x = n - 1;
        while (x > 0 && arr[x - 1] <= arr[x])
            x--;
        if (x == 0) {
            System.out.println(-1);
            return;
        }
        int y = n - 1;
        while (arr[x - 1] <= arr[y])
            y--;
        swap(arr, x - 1, y);
        int z = n - 1;
        while (x < z) {
            swap(arr, x, z);
            x++;
            z--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++)
            sb.append(arr[i]).append(" ");
        System.out.println(sb);
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
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