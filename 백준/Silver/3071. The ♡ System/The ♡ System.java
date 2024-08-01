public class Main {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int p = read();
            String str = "0" + Integer.toString(Math.abs(p), 3);
            char[] arr = str.toCharArray();
            char[] result = new char[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                switch (arr[i]) {
                    case '3':
                        arr[i - 1]++;
                        result[i] = '0';
                        break;
                    case '2':
                        arr[i - 1]++;
                        result[i] = '-';
                        break;
                    case '1':
                        result[i] = '1';
                        break;
                    case '0':
                        result[i] = '0';
                        break;
                }
            }
            if (p < 0) {
                for (int i = 0; i < result.length; i++)
                    if (result[i] == '1')
                        result[i] = '-';
                    else if (result[i] == '-')
                        result[i] = '1';
            }
            StringBuilder temp = new StringBuilder(String.valueOf(result));
            if (temp.charAt(0) == '0')
                temp.deleteCharAt(0);
            sb.append(temp).append("\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}