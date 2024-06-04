public class Main {
    static int cnt;
    static int result = -1;
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws Exception {
        int n = read();
        cnt = read();
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        mergeSort(0, n - 1);
        System.out.println(result);
    }
    private static void mergeSort(int l, int r) {
        if (l < r) {
            int m = (r + l) / 2;
            mergeSort(l, m);
            mergeSort(m + 1, r);
            merge(l, m, r);
        }
    }
    private static void merge(int l, int m, int r) {
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        i = l;
        k = 0;
        while (i <= r) {
            arr[i] = temp[k++];
            if(--cnt == 0) {
                result = arr[i];
            }
            i++;
        }
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}