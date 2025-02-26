import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int n;
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            int cur = 0, prev = 0;
            int totalCnt = 0, uCnt = 0;
            boolean dFlag = false;
            for (int i = 0; i < n; i++) {
                cur = sc.nextInt();
                if (prev < cur) {
                    if (dFlag) {
                        uCnt = 1;
                        dFlag = false;
                    }
                    uCnt++;
                } else {
                    dFlag = true;
                    totalCnt += uCnt - 1;
                }
                prev = cur;
            }
            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }
        System.out.println(sb);
    }
}