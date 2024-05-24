public class Main {
    static int n;
    static int s;
    static int cnt = 0;
    static int[] nums;
    
    public static void main(String[] args) throws Exception {
        n = read();
        s = read();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = read();
        }
        dfs(0, 0);
        if (s == 0) {
            cnt--;
        }
        System.out.println(cnt);
    }
    
    public static void dfs(int p, int sum) {
        if (p == n) {
            if (sum == s) {
                cnt++;   
            }
            return;
        }
        dfs(p + 1, sum);
        dfs(p + 1, sum + nums[p]);
    }
    
    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean negative = n == 13;
        if (negative) {
            n = System.in.read() & 15;
        }
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return negative ? ~n + 1 : n;
    }
}