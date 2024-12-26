public class Main {

    static int[] arr, temp;
    static long cnt = 0;

    public static void main(String[] args) throws Exception {
        int n = read();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        temp = new int[n];
        mergeSort(0, n - 1);
        System.out.println(cnt);
    }

    private static void mergeSort(int l, int r) {
        if (l < r) {
            int m = (l + r) >> 1;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }

    private static void merge(int l, int m, int r) {
        for (int i = l; i <= r; i++) {
            temp[i] = arr[i];
        }
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
                cnt += m + 1 - i;
            }
            k++;
        }
        while (i <= m) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}