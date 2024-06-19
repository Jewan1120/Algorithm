import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++)
            arr[i] = new int[]{read(), read()};
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] lis = new int[n]; // i = 0 : lis 길이 1의 최솟값 , i = 1 : lis 길이 2의 최솟값
        int len = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i][1];
            int idx = Arrays.binarySearch(lis, 0, len, num); // 이분 탐색으로 num이 들어갈 수 있는 인덱스 탐색
            if (idx < 0) {
                idx = -(idx + 1); // 이분 탐색으로 찾은 인덱스에 값 변경 -> lis의 값들을 최소로 유지
            }
            lis[idx] = num;
            if (idx == len) // lis의 길이가 늘어났을 경우
                len++;
        }
        System.out.println(n - len); // 지워야하는 전선은 lis 이외의 전선들
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}