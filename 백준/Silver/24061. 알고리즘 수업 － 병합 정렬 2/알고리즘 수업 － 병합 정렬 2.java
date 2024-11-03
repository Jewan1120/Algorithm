public class Main {

    static int n, k;
    static String result = "-1";

    public static void main(String[] args) throws Exception {
        n = read();
        k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        mergeSort(arr, 0, n - 1);
        System.out.println(result);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int i = l, j = m + 1, t = 0;
        int[] temp = new int[r - l + 1];
        while (i <= m && j <= r)
            if (arr[i] <= arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        while (i <= m)
            temp[t++] = arr[i++];
        while (j <= r)
            temp[t++] = arr[j++];
        i = l;
        t = 0;
        for (t = 0; t < temp.length; t++) {
            arr[l + t] = temp[t];
            k--;
            if (k == 0) {
                StringBuilder sb = new StringBuilder();
                for (int idx = 0; idx < n; idx++)
                    sb.append(arr[idx]).append(" ");
                result = sb.toString();
            }
        }
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