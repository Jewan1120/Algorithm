public class Main {

    static int[] nums = new int[10];

    public static void main(String[] args) throws Exception {
        int n = read();
        int t = 1;
        while (n > 0) {
            while (n % 10 != 9 && n > 0) {
                addNums(n, t);
                n--;
            }
            if (n == 0)
                break;
            n /= 10;
            for (int i = 0; i < 10; i++)
                nums[i] += (n + 1) * t;
            nums[0] -= t;
            t *= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num).append(" ");
        System.out.println(sb);
    }

    private static void addNums(int num, int t) {
        while (num > 0) {
            nums[num % 10] += t;
            num /= 10;
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