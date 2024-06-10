import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            char[] arr = br.readLine().toCharArray();
            char p = '0';
            int[] nums = new int[10];
            int idx = 0;
            for (idx = arr.length - 1; idx > 0; idx--) {
                nums[arr[idx] - '0']++;
                if (p <= arr[idx]) p = arr[idx];
                else break;
            }
            if (idx == 0) {
                sb.append("BIGGEST\n");
                continue;
            }
            int f = arr[idx] - '0';
            for (int i = f + 1; i < 10; i++) {
                if (nums[i] > 0) {
                    arr[idx++] = (char) (i + '0');
                    nums[i]--;
                    break;
                }
            }
            for (; idx < arr.length; idx++) {
                for (int i = 0; i < 10; i++) {
                    if (nums[i] > 0) {
                        arr[idx] = (char) (i + '0');
                        nums[i]--;
                        break;
                    }
                }
            }
            sb.append(new String(arr)).append("\n");
        }
        System.out.println(sb);
    }
}