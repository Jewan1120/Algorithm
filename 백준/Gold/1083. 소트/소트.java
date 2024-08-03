public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int s = read();
        for (int i = 0; i < n - 1 && 0 < s; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n && j <= i + s; j++) {
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            for (int j = maxIndex; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                s--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}