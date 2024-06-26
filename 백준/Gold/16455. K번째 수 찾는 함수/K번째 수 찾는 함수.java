public class Test {
	int kth(int[] a, int k) {
        return kth(a, 0, a.length - 1, k - 1);
    }
    
    int kth(int[] a, int l, int r, int k) {
        if (l == r) return a[l];
        int pivot = a[(l + r) / 2];
        int i = l - 1, j = r + 1;
        while (true) {
            while (a[++i] < pivot);
            while (a[--j] > pivot);
            if (i >= j) break;
            swap(a, i, j);
        }
        if (k <= j)
            return kth(a, l, j, k);
        else
            return kth(a, j + 1, r, k);
    }
    
    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
